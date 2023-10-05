package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.SoAo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SoAoService {
    List<SoAo> GetAll();
    Page<SoAo> getAll(Integer pageNo , Integer size);
    void addSoAo(SoAo soAo);
    SoAo detail(Integer id);
    void delete(Integer id);
}
