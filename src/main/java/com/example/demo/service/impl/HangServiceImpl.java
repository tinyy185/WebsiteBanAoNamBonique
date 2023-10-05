package com.example.demo.service.impl;

import com.example.demo.entity.Hang;
import com.example.demo.repository.HangRepository;
import com.example.demo.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HangServiceImpl implements HangService {
    @Autowired
    HangRepository hangRepository;
    @Override
    public List<Hang> GetAll() {
               return hangRepository.findAll();
    }

    @Override
    public Page<Hang> getAll(Integer pageNo, Integer size) {
        return hangRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addhang(Hang hang) {
        hangRepository.save(hang);
    }

    @Override
    public Hang detail(Integer id) {
        return hangRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        hangRepository.deleteById(id);
    }
}
