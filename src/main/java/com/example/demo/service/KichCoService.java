package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichCo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KichCoService {
    List<KichCo> GetAll();
    Page<KichCo> getAll(Integer pageNo , Integer size);
    void addKichCo(KichCo kichCo);
    KichCo detail(Integer id);
    void delete(Integer id);
}
