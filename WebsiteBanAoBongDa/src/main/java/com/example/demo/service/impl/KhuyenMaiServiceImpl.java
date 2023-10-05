package com.example.demo.service.impl;


import com.example.demo.entity.KhachHang;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService{
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> GetAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public Page<KhuyenMai> getAll(Integer pageNo, Integer size) {
        return khuyenMaiRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addKhuyenMai(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public KhuyenMai detailKhuyenMai(Integer id) {
        return khuyenMaiRepository.findById(id).get();
    }

    @Override
    public void deleteKhuyenMai(Integer id) {
        khuyenMaiRepository.deleteById(id);
    }
}
