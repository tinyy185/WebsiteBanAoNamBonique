package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.DoiBong;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoiBongService {
    List<DoiBong> GetAll();
    Page<DoiBong> getAll(Integer pageNo , Integer size);
    void addDoiBong(DoiBong doiBong);
    DoiBong detail(Integer id);
    void delete(Integer id);
}
