package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.impl.ChatLieuServiceImpl;
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
public class ChatLieuController {
    @Autowired
    ChatLieuServiceImpl chatLieuService;
    @GetMapping("/chat_lieu/hien_thi")
    public String  hienThiChatLieu(@RequestParam(value = "pageNo",defaultValue = "1")Integer page, Model model){
        Page<ChatLieu> listcl=chatLieuService.getAll(page-1,5);
        model.addAttribute("danhsachcl",listcl.toList());
        model.addAttribute("cl",new ChatLieu());
        return "/ChatLieu/ChatLieuindex";
    }
    @PostMapping("/chat_lieu/add")
    public String addChatLieu(@Valid @ModelAttribute("cl") ChatLieu chatLieu, BindingResult result){
        if (result.hasErrors()){
            return "/ChatLieu/ChatLieuindex";
        }
        chatLieuService.addChatLieu(chatLieu);
        return "redirect:/chat_lieu/hien_thi";
    }
    @GetMapping("/chat_lieu/detail/{id}")
    public String dtailChatLieu(@PathVariable("id") Integer id, Model model){
        ChatLieu chatLieu= chatLieuService.detail(id);
        model.addAttribute("cl",chatLieu);
        return "/ChatLieu/ChatLieuindex";
    }
@PostMapping("/chat_lieu/update")
public String updateChatLieu(@Valid @ModelAttribute("cl") ChatLieu chatLieu, BindingResult result){
    if (result.hasErrors()){
        return "/ChatLieu/ChatLieuUpdate";
    }
    chatLieuService.addChatLieu(chatLieu);
    return "redirect:/chat_lieu/hien_thi";
}
    @GetMapping("/chat_lieu/view_update/{id}")
    public String viewUpdate(@PathVariable("id")Integer id,Model model){
        ChatLieu chatLieu= chatLieuService.detail(id);
        model.addAttribute("cl",chatLieu);
        return "/ChatLieu/ChatLieuUpdate";
    }
    @GetMapping("/chat_lieu/delete/{id}")
    public String deleteChatLieu(@PathVariable("id") Integer id){
        chatLieuService.delete(id);
        return "redirect:/chat_lieu/hien_thi";
    }
}
