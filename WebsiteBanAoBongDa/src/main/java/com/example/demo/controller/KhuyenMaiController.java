package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
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
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiService khuyenMaiService;
    @GetMapping("/khuyen_mai/hien_thi")
    public String  hienThiKhuyenMai(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<KhuyenMai> listkm=khuyenMaiService.getAll(page-1,5);
        model.addAttribute("danhsachkm",listkm.toList());
        model.addAttribute("km",new KhuyenMai());
        return "/KhuyenMai/khuyenMaiIndex";
    }
    @PostMapping("/khuyen_mai/add")
    public String addKhuyenMai(@Valid @ModelAttribute("km") KhuyenMai khuyenMai, BindingResult result){
        if (result.hasErrors()){
            return "/KhuyenMai/khuyenMaiAdd";
        }
        khuyenMaiService.addKhuyenMai(khuyenMai);
        return "redirect:/khuyen_mai/hien_thi";
    }
    @GetMapping("/khuyen_mai/view_add")
    public String ViewAddKM(Model model){
        List<KhuyenMai> listkm=khuyenMaiService.GetAll();
        model.addAttribute("km",listkm);
        model.addAttribute("km",new KhuyenMai());
        return "/KhuyenMai/khuyenMaiAdd";
    }
    @GetMapping("/khuyen_mai/detail/{id}")
    public String detailKhuyenMai(@PathVariable("id") Integer id, Model model){
        KhuyenMai khuyenMai= khuyenMaiService.detailKhuyenMai(id);
        model.addAttribute("kh",khuyenMai);
        return "/KhuyenMai/KhuyenMaiIndex";
    }
    @PostMapping("/khuyen_mai/update")
    public String updateKhuyenMai(@Valid @ModelAttribute("km") KhuyenMai khuyenMai, BindingResult result){
        if (result.hasErrors()){
            return "/KhuyenMai/khuyenMaiUpdate";
        }
        khuyenMaiService.addKhuyenMai(khuyenMai);
        return "redirect:/khuyen_mai/hien_thi";
    }
    @GetMapping("/khuyen_mai/view_update/{id}")
    public String viewUpdateKM(@PathVariable("id")Integer id,Model model){
        KhuyenMai khuyenMai= khuyenMaiService.detailKhuyenMai(id);
        model.addAttribute("km",khuyenMai);
        return "/KhuyenMai/khuyenMaiUpdate";
    }
    @GetMapping("/khuyen_mai/delete/{id}")
    public String deleteKhachHang(@PathVariable("id") Integer id){
        khuyenMaiService.deleteKhuyenMai(id);
        return "redirect:/khuyen_mai/hien_thi";
    }
}
