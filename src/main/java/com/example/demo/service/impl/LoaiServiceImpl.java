package com.example.demo.service.impl;

import com.example.demo.entity.Loai;
import com.example.demo.repository.LoaiRepository;
import com.example.demo.service.LoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiServiceImpl implements LoaiService {
    @Autowired
    LoaiRepository loaiRepository;

    @Override
    public List<Loai> GetAll() {
        return loaiRepository.findAll();
    }

    @Override
    public Page<Loai> getAll(Integer pageNo, Integer size) {
        return loaiRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addLoai(Loai loai) {
        loaiRepository.save(loai);
    }

    @Override
    public Loai detail(Integer id) {
        return loaiRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        loaiRepository.deleteById(id);
    }
}
