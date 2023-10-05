package com.example.demo.controller;

import com.example.demo.entity.KichCo;
import com.example.demo.entity.MauSac;
import com.example.demo.service.impl.MauSacServiceImpl;
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
public class MauSacController {
    @Autowired
    MauSacServiceImpl mauSacService;
    @GetMapping("/mau_sac/hien_thi")
    public String  hienThiMauSac(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<MauSac> listcl=mauSacService.getAll(page-1,5);
        model.addAttribute("danhsachms",listcl.toList());
        model.addAttribute("ms",new MauSac());
        return "/MauSac/MauSacindex";
    }
    @PostMapping("/mau_sac/add")
    public String addMauSac(@Valid @ModelAttribute("ms") MauSac mauSac, BindingResult result){
        if (result.hasErrors()){
            return "/MauSac/MauSacindex";
        }
        mauSacService.addMauSac(mauSac);
        return "redirect:/mau_sac/hien_thi";
    }
    @GetMapping("/mau_sac/detail/{id}")
    public String dtailMauSac(@PathVariable("id") Integer id, Model model){
        MauSac mauSac= mauSacService.detail(id);
        model.addAttribute("ms",mauSac);
        return "/MauSac/MauSacindex";
    }
    @PostMapping("/mau_sac/update")
    public String updateMauSac(@Valid @ModelAttribute("ms") MauSac mauSac, BindingResult result){
        if (result.hasErrors()){
            return "/MauSac/MauSacUpdate";
        }
        mauSacService.addMauSac(mauSac);
        return "redirect:/mau_sac/hien_thi";
    }
    @GetMapping("/mau_sac/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        MauSac mauSac= mauSacService.detail(id);
        model.addAttribute("ms",mauSac);
        return "/MauSac/MauSacUpdate";
    }
    @GetMapping("/mau_sac/delete/{id}")
    public String deleteMauSac(@PathVariable("id") Integer id){
        mauSacService.delete(id);
        return "redirect:/mau_sac/hien_thi";
    }
}
