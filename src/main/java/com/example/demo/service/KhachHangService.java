package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> GetAll();
    Page<KhachHang> getAll(Integer pageNo , Integer size);
    void addKhachHang(KhachHang khachHang);
    KhachHang detailKhachHang(Integer id);
    void deletKhachHang(Integer id);
}
