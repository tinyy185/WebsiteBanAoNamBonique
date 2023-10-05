package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.Loai;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoaiService {
    List<Loai> GetAll();
    Page<Loai> getAll(Integer pageNo , Integer size);
    void addLoai(Loai loai);
    Loai detail(Integer id);
    void delete(Integer id);
}
