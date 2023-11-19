package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.IAppRoleRepository;
import com.example.demo.repository.IAppUserRepository;
import com.example.demo.repository.INhanVienRepository;
//import com.example.demo.service.INhanVienService;
//import com.example.demo.service.QRCodeScannerService;
import com.example.demo.repository.IUserRoleRepository;
import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {


    @Autowired
    private INhanVienRepository repository;

    @Autowired
    private IAppRoleRepository roleRepository;

    @Autowired
    private IUserRoleRepository repositoryUserRole;

    @Autowired
            private IAppUserRepository iAppUserRepository;

    Nhanvien nhanVien = new Nhanvien(); // Tạo đối tượng 'nhanVien'

    @GetMapping
    public String viewAll(Model model) {
        List<Nhanvien> listNV = repository.findAll();
        model.addAttribute("listNhanVien", listNV);
        return "nhan-vien/nhanvien";
    }


    @PostMapping("/decode")
    @ResponseBody
    public Map<String, String> decodeQrCode(@RequestParam("file") MultipartFile file) {
        Map<String, String> result = new HashMap<>();
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            MultiFormatReader reader = new MultiFormatReader();
            Result decodeResult = reader.decode(bitmap);
            result.put("text", decodeResult.getText());
        } catch (NotFoundException | IOException e) {
            result.put("error", "Không tìm thấy mã QR hoặc lỗi đọc mã.");
        }
        return result;
    }

    @PostMapping("/addToSql")
    @ResponseBody
    public String addToSql(@RequestBody Nhanvien qrCodeDataObj, RedirectAttributes redirectAttributes) {
        Map<String, String> response = new HashMap<>();

        try {
            repository.save(qrCodeDataObj);
            response.put("success", "true");
            response.put("message", "Đã thêm vào cơ sở dữ liệu.");
            redirectAttributes.addFlashAttribute("successMessage", "Thêm nhân viên thành công");
            return "redirect:/nhan-vien";
        } catch (Exception e) {
            response.put("success", "false");
            response.put("message", "Đã có lỗi xảy ra khi thêm vào cơ sở dữ liệu.");
        }

        return "error";
    }

    @GetMapping("/view-update/{userId}")
    public String viewUpdate(Model model, @PathVariable(name = "userId") Long userId) {
        Nhanvien nhanvien1 = repository.findNhanvienByUserId(userId);

        if (nhanvien1 != null) {
            model.addAttribute("nhanVien", nhanvien1);
            return "nhan-vien/themnhanvien"; // Thay "nhan-vien/themnhanvien" bằng tên trang JSP/Thymeleaf của bạn
        } else {
            // Xử lý trường hợp nhanvien1 không tồn tại
            return "redirect:/error-page"; // Thay "/error-page" bằng URL của trang lỗi hoặc xử lý khác
        }
    }

    private BCryptPasswordEncoder passwordEncoder;

// ...

    @PostMapping("/update/{userId}")
    public String updateNhanVien(
            @PathVariable(name = "userId") Long userId,
            @ModelAttribute("nhanVien") Nhanvien nhanVien) {

        // Tìm thông tin nhân viên hiện có từ cơ sở dữ liệu
        Nhanvien existingNhanVien = repository.findNhanvienByUserId(userId);

        // Cập nhật thông tin từ form vào nhân viên hiện có
        existingNhanVien.setUserName(nhanVien.getUserName());
        existingNhanVien.setEmail(nhanVien.getEmail());

        // Kiểm tra xem mật khẩu từ form có tồn tại không
        if (nhanVien.getEncrytedPassword() != null && !nhanVien.getEncrytedPassword().isEmpty()) {
            // Nếu có mật khẩu từ form, mã hóa và cập nhật mật khẩu
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(nhanVien.getEncrytedPassword());
            existingNhanVien.setEncrytedPassword(encodedPassword);
        }

        // Lưu thông tin nhân viên đã cập nhật vào cơ sở dữ liệu
        repository.save(existingNhanVien);

        // Tạo và lưu UserRole (nếu cần)
        Long idAppUser = existingNhanVien.getUserId();
        AppUser savedAppUser = iAppUserRepository.findById(idAppUser).orElse(null);
        AppRole appRole = roleRepository.findById(3L).orElse(null);

            UserRole userRole = new UserRole();
            userRole.setAppUser(savedAppUser);
            userRole.setAppRole(appRole);
            repositoryUserRole.save(userRole);

        return "redirect:/nhan-vien"; // Thay "/nhan-vien" bằng URL của trang danh sách của bạn
    }




}
