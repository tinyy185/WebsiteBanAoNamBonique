package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.DoiBong;
import com.example.demo.service.impl.DoiBongServiceImpl;
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
public class DoiBongController {
    @Autowired
    DoiBongServiceImpl doiBongService;
    @GetMapping("/doi_bong/hien_thi")
    public String  hienThiDoiBong(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<DoiBong> listcl=doiBongService.getAll(page-1,5);
        model.addAttribute("danhsachdb",listcl.toList());
        model.addAttribute("db",new DoiBong());
        return "/DoiBong/DoiBongIndex";
    }
    @PostMapping("/doi_bong/add")
    public String addDoiBong(@Valid @ModelAttribute("db") DoiBong doiBong, BindingResult result){
        if (result.hasErrors()){
            return "/DoiBong/DoiBongIndex";
        }
        doiBongService.addDoiBong(doiBong);
        return "redirect:/doi_bong/hien_thi";
    }
    @GetMapping("/doi_bong/detail/{id}")
    public String dtailDoiBong(@PathVariable("id") Integer id, Model model){
        DoiBong doiBong= doiBongService.detail(id);
        model.addAttribute("db",doiBong);
        return "/DoiBong/DoiBongIndex";
    }
    @PostMapping("/doi_bong/update")
    public String updateDoiBong(@Valid @ModelAttribute("db") DoiBong doiBong, BindingResult result){
        if (result.hasErrors()){
            return "/DoiBong/DoiBongUpdate";
        }
        doiBongService.addDoiBong(doiBong);
        return "redirect:/doi_bong/hien_thi";
    }
    @GetMapping("/doi_bong/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        DoiBong doiBong= doiBongService.detail(id);
        model.addAttribute("db",doiBong);
        return "/DoiBong/DoiBongUpdate";
    }
    @GetMapping("/doi_bong/delete/{id}")
    public String deleteDoiBong(@PathVariable("id") Integer id){
        doiBongService.delete(id);
        return "redirect:/doi_bong/hien_thi";
    }
}
