package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.impl.KhachHangServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangServiceImpl khachHangService;
    @GetMapping("/khach_hang/hien_thi")
    public String  hienThiKhachHang(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<KhachHang> listkh=khachHangService.getAll(page-1,5);
        model.addAttribute("danhsachkh",listkh.toList());
        model.addAttribute("kh",new KhachHang());
        return "/KhachHang/khachhangindex";
    }
    @PostMapping("/khach_hang/add")
    public String addkhachHang(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult result){
        if (result.hasErrors()){
            return "/KhachHang/khachhangadd";
        }
        khachHangService.addKhachHang(khachHang);
        return "redirect:/khach_hang/hien_thi";
    }
    @GetMapping("/view_add")
    public String ViewAdd(Model model){
        List<KhachHang>listcv=khachHangService.GetAll();
        model.addAttribute("kh",listcv);
        model.addAttribute("kh",new KhachHang());
        return "/KhachHang/khachhangadd";
    }
    @GetMapping("/khach_hang/detail/{id}")
    public String dtailKhachhang(@PathVariable("id") Integer id, Model model){
        KhachHang khachHang= khachHangService.detailKhachHang(id);
        model.addAttribute("kh",khachHang);
        return "/KhachHang/khachhangindex";
    }
    @PostMapping("/khach_hang/update")
    public String updatekhachHang(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult result){
        if (result.hasErrors()){
            return "/KhachHang/khachhangUpdate";
        }
        khachHangService.addKhachHang(khachHang);
        return "redirect:/khach_hang/hien_thi";
    }
    @GetMapping("/khach_hang/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        KhachHang khachHang= khachHangService.detailKhachHang(id);
        model.addAttribute("kh",khachHang);
        return "/KhachHang/khachhangUpdate";
    }
    @GetMapping("/khach_hang/delete/{id}")
    public String deleteKhachHang(@PathVariable("id") Integer id){
        khachHangService.deletKhachHang(id);
        return "redirect:/khach_hang/hien_thi";
    }
}
