package com.example.demo.controller;

import com.example.demo.entity.Anh;
import com.example.demo.entity.ChatLieu;
import com.example.demo.service.impl.AnhServiceImpl;
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
public class AnhController {
    @Autowired
    AnhServiceImpl anhService;
    @GetMapping("/anh/hien_thi")
    public String  hienThianh(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<Anh> listcl=anhService.getAll(page-1,5);
        model.addAttribute("danhsachanh",listcl.toList());
        model.addAttribute("anh",new Anh());
        return "/Anh/Anhindex";
    }
    @PostMapping("/anh/add")
    public String addanh(@Valid @ModelAttribute("anh") Anh anh, BindingResult result){
        if (result.hasErrors()){
            return "/Anh/Anhindex";
        }
        anhService.addAnh(anh);
        return "redirect:/anh/hien_thi";
    }
    @GetMapping("/anh/detail/{id}")
    public String dtailanh(@PathVariable("id") Integer id, Model model){
        Anh anh= anhService.detail(id);
        model.addAttribute("anh",anh);
        return "/Anh/Anhindex";
    }
    @PostMapping("/anh/update")
    public String updateanh(@Valid @ModelAttribute("anh") Anh anh, BindingResult result){
        if (result.hasErrors()){
            return "/Anh/AnhUpdate";
        }
        anhService.addAnh(anh);
        return "redirect:/anh/hien_thi";
    }
    @GetMapping("/anh/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        Anh anh= anhService.detail(id);
        model.addAttribute("anh",anh);
        return "/Anh/AnhUpdate";
    }
    @GetMapping("/anh/delete/{id}")
    public String deleteanh(@PathVariable("id") Integer id){
        anhService.delete(id);
        return "redirect:/anh/hien_thi";
    }
}
