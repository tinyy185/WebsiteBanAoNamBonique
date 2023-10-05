package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepository chatLieuRepository;
    @Override
    public List<ChatLieu> GetAll() {
        return chatLieuRepository.findAll();
    }

    @Override
    public Page<ChatLieu> getAll(Integer pageNo, Integer size) {
        return chatLieuRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addChatLieu(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu detail(Integer id) {
        return chatLieuRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
    chatLieuRepository.deleteById(id);
    }

    @Override
    public void updateChatLieu(ChatLieu chatLieu, Integer id) {
    }
}
