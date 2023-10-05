package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> GetAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public Page<MauSac> getAll(Integer pageNo, Integer size) {
        return mauSacRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac detail(Integer id) {
        return mauSacRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        mauSacRepository.deleteById(id);
    }
}
