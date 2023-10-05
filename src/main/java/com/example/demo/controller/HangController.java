package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.Hang;
import com.example.demo.service.impl.HangServiceImpl;
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
public class HangController {
    @Autowired
    HangServiceImpl hangService;
    @GetMapping("/hang/hien_thi")
    public String  hienThiHang(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<Hang> listcl=hangService.getAll(page-1,5);
        model.addAttribute("danhsachhang",listcl.toList());
        model.addAttribute("hang",new Hang());
        return "/Hang/Hangindex";
    }
    @PostMapping("/hang/add")
    public String addHang(@Valid @ModelAttribute("hang") Hang hang, BindingResult result){
        if (result.hasErrors()){
            return "/Hang/Hangindex";
        }
        hangService.addhang(hang);
        return "redirect:/hang/hien_thi";
    }
    @GetMapping("/hang/detail/{id}")
    public String dtailHang(@PathVariable("id") Integer id, Model model){
        Hang hang= hangService.detail(id);
        model.addAttribute("hang",hang);
        return "/Hang/Hangindex";
    }
    @PostMapping("/hang/update")
    public String updateHang(@Valid @ModelAttribute("hang") Hang hang, BindingResult result){
        if (result.hasErrors()){
            return "/Hang/HangUpdate";
        }
        hangService.addhang(hang);
        return "redirect:/hang/hien_thi";
    }
    @GetMapping("/hang/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        Hang hang= hangService.detail(id);
        model.addAttribute("hang",hang);
        return "/Hang/hangUpdate";
    }
    @GetMapping("/hang/delete/{id}")
    public String deleteHang(@PathVariable("id") Integer id){
        hangService.delete(id);
        return "redirect:/hang/hien_thi";
    }
}
