package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichCo;
import com.example.demo.service.impl.KichCoServiceImpl;
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
public class KichCocontroller {
    @Autowired
    KichCoServiceImpl kichCoService;
    @GetMapping("/Kich_co/hien_thi")
    public String  hienThiKichCo(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<KichCo> listcl=kichCoService.getAll(page-1,5);
        model.addAttribute("danhsachkc",listcl.toList());
        model.addAttribute("kc",new KichCo());
        return "/KichCo/KichCoindex";
    }
    @PostMapping("/Kich_co/add")
    public String addKichCo(@Valid @ModelAttribute("kc") KichCo kichCo, BindingResult result){
        if (result.hasErrors()){
            return "/KichCo/KichCoindex";
        }
        kichCoService.addKichCo(kichCo);
        return "redirect:/Kich_co/hien_thi";
    }
    @GetMapping("/Kich_co/detail/{id}")
    public String dtailKichCo(@PathVariable("id") Integer id, Model model){
        KichCo kichCo= kichCoService.detail(id);
        model.addAttribute("kc",kichCo);
        return "/KichCo/KichCoindex";
    }
    @PostMapping("/Kich_co/update")
    public String updateKichCo(@Valid @ModelAttribute("kc") KichCo kichCo, BindingResult result){
        if (result.hasErrors()){
            return "/KichCo/KichCoUpdate";
        }
        kichCoService.addKichCo(kichCo);
        return "redirect:/Kich_co/hien_thi";
    }
    @GetMapping("/Kich_co/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        KichCo kichCo= kichCoService.detail(id);
        model.addAttribute("kc",kichCo);
        return "/KichCo/KichCoUpdate";
    }
    @GetMapping("/Kich_co/delete/{id}")
    public String deleteKichCo(@PathVariable("id") Integer id){
        kichCoService.delete(id);
        return "redirect:/Kich_co/hien_thi";
    }
}
