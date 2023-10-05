package com.example.demo.service.impl;

import com.example.demo.entity.Anh;
import com.example.demo.repository.AnhRepository;
import com.example.demo.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnhServiceImpl implements AnhService {
    @Autowired
    AnhRepository anhRepository;

    @Override
    public List<Anh> GetAll() {
        return anhRepository.findAll();
    }

    @Override
    public Page<Anh> getAll(Integer pageNo, Integer size) {
        return anhRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addAnh(Anh anh) {
        anhRepository.save(anh);
    }

    @Override
    public Anh detail(Integer id) {
        return anhRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        anhRepository.deleteById(id);
    }
}
