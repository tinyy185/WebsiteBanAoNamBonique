package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.Hang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HangService {
    List<Hang> GetAll();
    Page<Hang> getAll(Integer pageNo , Integer size);
    void addhang(Hang hang);
    Hang detail(Integer id);
    void delete(Integer id);
}
