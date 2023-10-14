package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.SanPham;
import com.example.demo.service.impl.KhuyenMaiServiceImpl;
import com.example.demo.service.impl.SanPhamServiceImpl;
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

@Controller
public class SanPhamController
{
    @Autowired
    SanPhamServiceImpl sanPhamService;
    @Autowired
    KhuyenMaiServiceImpl khuyenMaiService;
    @GetMapping("/san_pham/hien_thi")
    public String  hienThiSanPham(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<SanPham> listcl=sanPhamService.getAll(page-1,5);
        model.addAttribute("danhsachsp",listcl.toList());
        model.addAttribute("sp",new SanPham());
        List<KhuyenMai>listkm=khuyenMaiService.GetAll();
        model.addAttribute("danhsachkm",listkm);
        return "/SanPham/SanPhamindex";
    }
    @PostMapping("/san_pham/add")
    public String addSanPham(@Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result){
        if (result.hasErrors()){
            return "/SanPham/ChatLieuindex";
        }
        sanPhamService.addSanPham(sanPham);
        return "redirect:/san_pham/hien_thi";
    }
    @GetMapping("/san_pham/detail/{id}")
    public String dtailSanPham(@PathVariable("id") Integer id, Model model){
        SanPham sanPham= sanPhamService.detail(id);
        model.addAttribute("sp",sanPham);
        return "/SanPham/SanPhamindex";
    }
    @PostMapping("/san_pham/update")
    public String updateChatLieu(@Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result){
        if (result.hasErrors()){
            return "/SanPham/SanPhamUpdate";
        }
        sanPhamService.addSanPham(sanPham);
        return "redirect:/san_pham/hien_thi";
    }
    @GetMapping("/san_pham/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        SanPham sanPham= sanPhamService.detail(id);
        model.addAttribute("cl",sanPham);
        return "/SanPham/SanPhamUpdate";
    }
    @GetMapping("/san_pham/delete/{id}")
    public String deleteChatLieu(@PathVariable("id") Integer id){
        sanPhamService.delete(id);
        return "redirect:/san_pham/hien_thi";
    }
}
