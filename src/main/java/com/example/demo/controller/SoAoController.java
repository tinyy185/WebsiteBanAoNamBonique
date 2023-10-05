package com.example.demo.controller;

import com.example.demo.entity.KichCo;
import com.example.demo.entity.SoAo;
import com.example.demo.service.impl.SoAoServiceImpl;
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
public class SoAoController {
    @Autowired
    SoAoServiceImpl soAoService;
    @GetMapping("/so_ao/hien_thi")
    public String  hienThiSoAo(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<SoAo> listcl=soAoService.getAll(page-1,5);
        model.addAttribute("danhsachsa",listcl.toList());
        model.addAttribute("sa",new SoAo());
        return "/SoAo/SoAoindex";
    }
    @PostMapping("/so_ao/add")
    public String addSoAo(@Valid @ModelAttribute("sa") SoAo soAo, BindingResult result){
        if (result.hasErrors()){
            return "/SoAo/SoAoindex";
        }
        soAoService.addSoAo(soAo);
        return "redirect:/so_ao/hien_thi";
    }
    @GetMapping("/so_ao/detail/{id}")
    public String dtailSoAo(@PathVariable("id") Integer id, Model model){
        SoAo soAo= soAoService.detail(id);
        model.addAttribute("sa",soAo);
        return "/SoAo/SoAoindex";
    }
    @PostMapping("/so_ao/update")
    public String updateSoAo(@Valid @ModelAttribute("sa") SoAo soAo, BindingResult result){
        if (result.hasErrors()){
            return "/SoAo/SoAoUpdate";
        }
        soAoService.addSoAo(soAo);
        return "redirect:/so_ao/hien_thi";
    }
    @GetMapping("/so_ao/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        SoAo soAo= soAoService.detail(id);
        model.addAttribute("sa",soAo);
        return "/SoAo/SoAoUpdate";
    }
    @GetMapping("/so_ao/delete/{id}")
    public String deleteSoAo(@PathVariable("id") Integer id){
        soAoService.delete(id);
        return "redirect:/so_ao/hien_thi";
    }
}
