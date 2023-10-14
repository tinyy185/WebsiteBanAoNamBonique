package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSanPham> GetAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getAll(Integer pageNo, Integer size) {
        return chiTietSanPhamRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham detail(Integer id) {
        return chiTietSanPhamRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        chiTietSanPhamRepository.deleteById(id);
    }
}
