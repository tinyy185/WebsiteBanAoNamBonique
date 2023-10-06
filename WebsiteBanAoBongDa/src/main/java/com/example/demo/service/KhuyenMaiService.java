package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMai> GetAll();
    Page<KhuyenMai> getAll(Integer pageNo , Integer size);
    void addKhuyenMai(KhuyenMai khuyenMai);
    KhuyenMai detailKhuyenMai(Integer id);
    void deleteKhuyenMai(Integer id);
}
