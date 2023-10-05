package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> GetAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> getAll(Integer pageNo, Integer size) {
        return khachHangRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addKhachHang(KhachHang khachHang) {
khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang detailKhachHang(Integer id) {
        return khachHangRepository.findById(id).get();
    }

    @Override
    public void deletKhachHang(Integer id) {
khachHangRepository.deleteById(id);
    }
}
