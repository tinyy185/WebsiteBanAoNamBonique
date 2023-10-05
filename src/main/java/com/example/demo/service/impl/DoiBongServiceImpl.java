package com.example.demo.service.impl;

import com.example.demo.entity.DoiBong;
import com.example.demo.repository.DoBongRepository;
import com.example.demo.service.DoiBongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoiBongServiceImpl implements DoiBongService {
    @Autowired
    DoBongRepository doBongRepository;

    @Override
    public List<DoiBong> GetAll() {
        return doBongRepository.findAll();
    }

    @Override
    public Page<DoiBong> getAll(Integer pageNo, Integer size) {
        return doBongRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addDoiBong(DoiBong doiBong) {
        doBongRepository.save(doiBong);
    }

    @Override
    public DoiBong detail(Integer id) {
        return doBongRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        doBongRepository.deleteById(id);
    }
}
