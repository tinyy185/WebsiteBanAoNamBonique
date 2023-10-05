package com.example.demo.service;

import com.example.demo.entity.Anh;
import com.example.demo.entity.ChatLieu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AnhService {
    List<Anh> GetAll();
    Page<Anh> getAll(Integer pageNo , Integer size);
    void addAnh(Anh anh);
    Anh detail(Integer id);
    void delete(Integer id);
}
