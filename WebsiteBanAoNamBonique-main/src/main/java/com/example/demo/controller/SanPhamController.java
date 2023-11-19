package com.example.demo.controller;


import com.example.demo.model.MauSac;
import com.example.demo.model.SanPham;
import com.example.demo.repository.ISanphamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    @Autowired
    private ISanphamRepository repository;


    SanPham sp =new SanPham();

    List<SanPham> list;


    @GetMapping
    public String getAll(Model model){
        list =repository.findAll();
        model.addAttribute("ListSanPham",list);
        model.addAttribute("sanPham",sp);
        return "san-pham/sanphamht";
    }

    @PostMapping("/add")
    public String addMauSac(@Valid @ModelAttribute("sanPham") SanPham sanPham,  @RequestParam(value = "trangThai", defaultValue = "3") int trangThai) {
        // Kiểm tra tính hợp lệ của dữ liệu


        sanPham.setTrangThai(trangThai);
        repository.save(sanPham);

        return "redirect:/san-pham";
    }



}
