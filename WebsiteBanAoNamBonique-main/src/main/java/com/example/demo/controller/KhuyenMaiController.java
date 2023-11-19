package com.example.demo.controller;

import com.example.demo.model.KhuyenMai;
import com.example.demo.model.MauSac;
import com.example.demo.model.TrangThai;
import com.example.demo.repository.IKhuyenMaiRepository;
import com.example.demo.repository.ITrangThaiRepository;
import com.example.demo.repository.KhuyenMaiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/khuyen-mai")
public class KhuyenMaiController {
    @Autowired
    IKhuyenMaiRepository iKhuyenMaiRepository;
    @Autowired
    ITrangThaiRepository iTrangThaiRepository;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    KhuyenMai khuyenMai = new KhuyenMai();

    @GetMapping
    public String viewAll(Model model, @Param("phanTramGiam")Float phanTramGiam) {
        List<KhuyenMai> khuyenMais;
        if(phanTramGiam == null){
          khuyenMais = iKhuyenMaiRepository.findAll();

        }else {
            khuyenMais =iKhuyenMaiRepository.searchKhuyenMaiByPhanTramGiam(phanTramGiam);
        }


        model.addAttribute("khuyenMais", khuyenMais);
        model.addAttribute("khuyenMai", khuyenMai);
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate", currentDate);

        return "khuyen-mai/khuyen-mai";
    }

    @PostMapping("/add")
    public String addMauSac(@Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai,BindingResult result) {
        TrangThai trangThai = iTrangThaiRepository.findTrangThaiById(1);/* dang hoat dong*/
        TrangThai trangThai2 = iTrangThaiRepository.findTrangThaiById(2);/* ngung hoat dong*/
        TrangThai trangThai3 = iTrangThaiRepository.findTrangThaiById(3);/* chua dien ra*/
        if (result.hasErrors()) {
            // Nếu có lỗi, trả về view "mau-sac/hien-thi" để hiển thị lại form với thông báo lỗi
            return "khuyen-mai/khuyen-mai";
        }
        String KM = "KM" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
        LocalDate currentDate = LocalDate.now();
        if (khuyenMai.getNgayBatDau().isAfter(currentDate) && khuyenMai.getNgayKetThuc().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai3);
            khuyenMai.setMa(KM);
        } else if (khuyenMai.getNgayBatDau().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai3);
            khuyenMai.setMa(KM);
        } else if (khuyenMai.getNgayBatDau().isBefore(currentDate) && khuyenMai.getNgayKetThuc().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai);
            khuyenMai.setMa(KM);
        } else if (khuyenMai.getNgayBatDau().isEqual(currentDate) && khuyenMai.getNgayKetThuc().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai);
            khuyenMai.setMa(KM);
        }
        else if (khuyenMai.getNgayBatDau().isEqual(currentDate) && khuyenMai.getNgayKetThuc().isEqual(currentDate)) {
            khuyenMai.setTrangThai(trangThai);
            khuyenMai.setMa(KM);
        }
        else if (khuyenMai.getNgayBatDau().isBefore(currentDate) && khuyenMai.getNgayKetThuc().isBefore(currentDate)) {
            khuyenMai.setTrangThai(trangThai2);
            khuyenMai.setMa(KM);
        } else {
            khuyenMai.setMa(KM);
            khuyenMai.setTrangThai(trangThai2);
        }
        //    khuyenMai.setTrangThai(trangThai2);
        iKhuyenMaiRepository.save(khuyenMai);
        return "redirect:/khuyen-mai";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@ModelAttribute("khuyenMai") KhuyenMai khuyenMai, Model model
            , @PathVariable("id") Integer id) {
        khuyenMai = iKhuyenMaiRepository.findById(id).orElse(null);
        model.addAttribute("khuyenMai", khuyenMai);

        return "khuyen-mai/khuyen-mai-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("khuyenMai") KhuyenMai khuyenMai, Model model
            , @PathVariable("id") Integer id) {
        TrangThai trangThai = iTrangThaiRepository.findTrangThaiById(1);/* dang hoat dong*/
        TrangThai trangThai2 = iTrangThaiRepository.findTrangThaiById(2);/* ngung hoat dong*/
        TrangThai trangThai3 = iTrangThaiRepository.findTrangThaiById(3);/* chua dien ra*/

        String KM = "KM" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
        LocalDate currentDate = LocalDate.now();
        if (khuyenMai.getNgayBatDau().isAfter(currentDate) && khuyenMai.getNgayKetThuc().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai3);
        } else if (khuyenMai.getNgayBatDau().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai3);
            khuyenMaiRepository.updateAllChiTietSanPham();

        } else if (khuyenMai.getNgayBatDau().isBefore(currentDate) && khuyenMai.getNgayKetThuc().isAfter(currentDate)) {
            khuyenMai.setTrangThai(trangThai);

        } else if (khuyenMai.getNgayBatDau().isBefore(currentDate) && khuyenMai.getNgayKetThuc().isBefore(currentDate)) {
            khuyenMai.setTrangThai(trangThai2);
            khuyenMaiRepository.updateAllChiTietSanPham();
        } else {
            khuyenMai.setTrangThai(trangThai2);
        }
        //    khuyenMai.setTrangThai(trangThai2);
        iKhuyenMaiRepository.save(khuyenMai);

        return "redirect:/khuyen-mai";
    }

    @GetMapping("/ngung/{id}")
    public String ngungHoatDong(@PathVariable("id") Integer id) {
        TrangThai trangThai2 = iTrangThaiRepository.findTrangThaiById(2);/* ngung hoat dong*/
        khuyenMai = iKhuyenMaiRepository.findById(id).orElse(null);
        khuyenMai.setTrangThai(trangThai2);
        iKhuyenMaiRepository.save(khuyenMai);
        khuyenMaiRepository.updateAllChiTietSanPham();
        return "redirect:/khuyen-mai";
    }
    @GetMapping("/hoat-dong/{id}")
    public String HoatDong(@PathVariable("id") Integer id) {
        TrangThai trangThai2 = iTrangThaiRepository.findTrangThaiById(1);/* ngung hoat dong*/
        khuyenMai = iKhuyenMaiRepository.findById(id).orElse(null);
        khuyenMai.setTrangThai(trangThai2);
        iKhuyenMaiRepository.save(khuyenMai);

        return "redirect:/khuyen-mai";
    }
    @GetMapping("/ap-dung/{id}")
    public String apDung(@PathVariable("id") Integer id) {
        khuyenMai = iKhuyenMaiRepository.findById(id).orElse(null);
        khuyenMaiRepository.updateAll(khuyenMai);

        return "redirect:/khuyen-mai";
    }
}
