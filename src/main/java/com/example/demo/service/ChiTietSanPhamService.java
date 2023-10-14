package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> GetAll();
    Page<ChiTietSanPham> getAll(Integer pageNo , Integer size);
    void addChiTietSanPham(ChiTietSanPham chiTietSanPham);
    ChiTietSanPham detail(Integer id);
    void delete(Integer id);

}
