package com.example.demo.controller;

import com.example.demo.entity.KichCo;
import com.example.demo.entity.Loai;
import com.example.demo.service.impl.LoaiServiceImpl;
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
public class LoaiController {
    @Autowired
    LoaiServiceImpl loaiService;
    @GetMapping("/loai/hien_thi")
    public String  hienThiLoai(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<Loai> listcl=loaiService.getAll(page-1,5);
        model.addAttribute("danhsachlh",listcl.toList());
        model.addAttribute("lh",new Loai());
        return "/Loai/Loaiindex";
    }
    @PostMapping("/loai/add")
    public String addLoai(@Valid @ModelAttribute("lh") Loai loai, BindingResult result){
        if (result.hasErrors()){
            return "/Loai/Loaiindex";
        }
        loaiService.addLoai(loai);
        return "redirect:/loai/hien_thi";
    }
    @GetMapping("/loai/detail/{id}")
    public String dtailLoai(@PathVariable("id") Integer id, Model model){
        Loai loai= loaiService.detail(id);
        model.addAttribute("lh",loai);
        return "/Loai/Loaiindex";
    }
    @PostMapping("/loai/update")
    public String updateLoai(@Valid @ModelAttribute("lh") Loai loai, BindingResult result){
        if (result.hasErrors()){
            return "/Loai/LoaiUpdate";
        }
        loaiService.addLoai(loai);
        return "redirect:/loai/hien_thi";
    }
    @GetMapping("/loai/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        Loai loai= loaiService.detail(id);
        model.addAttribute("lh",loai);
        return "/Loai/LoaiUpdate";
    }
    @GetMapping("/loai/delete/{id}")
    public String deleteLoai(@PathVariable("id") Integer id){
        loaiService.delete(id);
        return "redirect:/loai/hien_thi";
    }
}
