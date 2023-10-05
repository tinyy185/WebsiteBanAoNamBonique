package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChatLieuService {
    List<ChatLieu> GetAll();
    Page<ChatLieu> getAll(Integer pageNo , Integer size);
    void addChatLieu(ChatLieu chatLieu);
    ChatLieu detail(Integer id);
    void delete(Integer id);
    void updateChatLieu(ChatLieu chatLieu ,Integer id);
}
