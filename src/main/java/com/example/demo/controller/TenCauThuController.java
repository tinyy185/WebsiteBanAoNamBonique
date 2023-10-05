package com.example.demo.controller;

import com.example.demo.entity.KichCo;
import com.example.demo.entity.TenCauThu;
import com.example.demo.service.impl.TenCauThuServiceImpl;
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

@Controller
public class TenCauThuController {
    @Autowired
    TenCauThuServiceImpl tenCauThuService;
    @GetMapping("/ten_cau_thu/hien_thi")
    public String  hienThiTenCauThu(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<TenCauThu> listcl=tenCauThuService.getAll(page-1,5);
        model.addAttribute("danhsachtct",listcl.toList());
        model.addAttribute("tct",new TenCauThu());
        return "/TenCauThu/TenCauThuindex";
    }
    @PostMapping("/ten_cau_thu/add")
    public String addTenCauThu(@Valid @ModelAttribute("tct") TenCauThu tenCauThu, BindingResult result){
        if (result.hasErrors()){
            return "/TenCauThu/TenCauThuindex";
        }
        tenCauThuService.addTenCauThu(tenCauThu);
        return "redirect:/ten_cau_thu/hien_thi";
    }
    @GetMapping("/ten_cau_thu/detail/{id}")
    public String dtailTenCauThu(@PathVariable("id") Integer id, Model model){
        TenCauThu tenCauThu= tenCauThuService.detail(id);
        model.addAttribute("tct",tenCauThu);
        return "/TenCauThu/TenCauThuindex";
    }
    @PostMapping("/ten_cau_thu/update")
    public String updateTenCauThu(@Valid @ModelAttribute("tct") TenCauThu tenCauThu, BindingResult result){
        if (result.hasErrors()){
            return "/TenCauThu/TenCauThuUpdate";
        }
        tenCauThuService.addTenCauThu(tenCauThu);
        return "redirect:/ten_cau_thu/hien_thi";
    }
    @GetMapping("/ten_cau_thu/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        TenCauThu tenCauThu= tenCauThuService.detail(id);
        model.addAttribute("tct",tenCauThu);
        return "/TenCauThu/TenCauThuUpdate";
    }
    @GetMapping("/ten_cau_thu/delete/{id}")
    public String deleteChatLieu(@PathVariable("id") Integer id){
        tenCauThuService.delete(id);
        return "redirect:/ten_cau_thu/hien_thi";
    }
}
