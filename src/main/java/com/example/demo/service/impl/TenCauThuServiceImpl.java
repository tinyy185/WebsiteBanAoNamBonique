package com.example.demo.service.impl;

import com.example.demo.entity.TenCauThu;
import com.example.demo.repository.TenCauThuRepository;
import com.example.demo.service.TenCauThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TenCauThuServiceImpl implements TenCauThuService {
    @Autowired
    TenCauThuRepository tenCauThuRepository;

    @Override
    public List<TenCauThu> GetAll() {
        return tenCauThuRepository.findAll();
    }

    @Override
    public Page<TenCauThu> getAll(Integer pageNo, Integer size) {
        return tenCauThuRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addTenCauThu(TenCauThu tenCauThu) {
        tenCauThuRepository.save(tenCauThu);
    }

    @Override
    public TenCauThu detail(Integer id) {
        return tenCauThuRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        tenCauThuRepository.deleteById(id);
    }
}
