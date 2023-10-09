package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamService {
    List<SanPham> GetAll();
    Page<SanPham> getAll(Integer pageNo , Integer size);
    void addSanPham(SanPham sanPham);
    SanPham detail(Integer id);
    void delete(Integer id);
}
