package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;
import com.example.demo.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService = new LoginServiceImpl();

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/login")
    public String Login() {
        return "login/index";
    }

    @GetMapping("/login2")
    public String Login2() {
        return "login/mat-khau-moi";
    }

    @PostMapping("/checkLogin")
    private String viewAll(Model model,
                           @RequestParam(required = false, name = "email") String email,
                           @RequestParam(required = false, name = "matkhau") String matkhau) {
        KhachHang khachHang = loginService.login(email);

        if (khachHang != null && khachHang.getMatKhau().equals(matkhau)) {
            return "login/Error";
        } else {
            model.addAttribute("err", "Email hoặc Mật khẩu không chính xác !");
            return "login/index";
        }
    }

    @GetMapping("/quen-mat-khau")
    public String quenMatKhau() {
        return "login/quen-mat-khau";
    }

    @PostMapping("/quen-mat-khau")
    public String quenMK(@RequestParam("email") String email , Model model){
        KhachHang khachHang = loginRepository.findByEmail(email);
        if (khachHang == null){
            model.addAttribute("error","Email không tồn tại !");
            return "login/quen-mat-khau";
        }

//        Tạo mk và lưu vào db
        String resetToken = generateResetToken();
        khachHang.setResetPass(resetToken);
        loginRepository.save(khachHang);

        // Gửi email
//        loginService.sendResetPasswordEmail(khachHang.getEmail() , resetToken);
//        model.addAttribute("kiemTra","Vui lòng kiểm tra email");
        return "login/mat-khau-moi";
    }

    @GetMapping("/mat-khau-moi")
    public String resetPasswordForm(@RequestParam("resetPass") String token, Model model) {
        // Kiểm tra xem token có hợp lệ hay không
        KhachHang khachHang = loginRepository.findByResetPass(token);
        if (khachHang == null) {
            model.addAttribute("errorr", "Liên kết không hợp lệ hoặc đã hết hạn.");
            return "login/quen-mat-khau";
        }
        model.addAttribute("token", token);
        return "login/mat-khau-moi";
    }

    @PostMapping("/mat-khau-moi")
    public String resetPassword(@RequestParam("resetPass") String token, @RequestParam("xacnhan") String matKhauMoi,
            @PathVariable("email") String email , Model model) {
        // Kiểm tra xem token có hợp lệ hay không
        KhachHang khachHang = loginRepository.findByMatKhau(token);
        if (khachHang == null) {
            model.addAttribute("error", "Liên kết không hợp lệ hoặc đã hết hạn.");
            return "login/quen-mat-khau";
        }
        if (!matKhauMoi.equals(token)) {
            model.addAttribute("error", "Mật khẩu mới và xác nhận mật khẩu mới không khớp.");
            return "login/mat-khau-moi";
        }
        khachHang.setMatKhau(matKhauMoi);
        khachHang.setResetPass(null);
        loginRepository.save(khachHang);
        return "login/index";
    }

    private String generateResetToken() {
        // Sử dụng UUID để tạo một chuỗi ngẫu nhiên
        return UUID.randomUUID().toString();
    }

    @GetMapping("/dang-ky")
    public String dangKy() {
        return "login/dang-ky";
    }

    @PostMapping ("/dang-ky")
    public String dangKyTaiKhoan(@ModelAttribute  KhachHang khachHang , @RequestParam("email") String email , Model model) {
        if (loginService.login(khachHang.getEmail()) != null){
            model.addAttribute("successMessage","Email đã tồn tại !");
            return "login/dang-ky";
        }
        loginService.dangKy(khachHang);
        return "login/index";
    }

}
