package com.example.demo.service.impl;

import com.example.demo.entity.KichCo;
import com.example.demo.repository.KichCoRepository;
import com.example.demo.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichCoServiceImpl implements KichCoService {
    @Autowired
    KichCoRepository kichCoRepository;

    @Override
    public List<KichCo> GetAll() {
        return kichCoRepository.findAll();
    }

    @Override
    public Page<KichCo> getAll(Integer pageNo, Integer size) {
        return kichCoRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addKichCo(KichCo kichCo) {
        kichCoRepository.save(kichCo);
    }

    @Override
    public KichCo detail(Integer id) {
        return kichCoRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        kichCoRepository.deleteById(id);
    }
}
