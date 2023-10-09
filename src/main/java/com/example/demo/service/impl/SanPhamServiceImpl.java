package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> GetAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> getAll(Integer pageNo, Integer size) {
        return sanPhamRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham detail(Integer id) {
        return sanPhamRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        sanPhamRepository.deleteById(id);
    }
}
