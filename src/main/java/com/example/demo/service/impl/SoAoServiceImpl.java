package com.example.demo.service.impl;

import com.example.demo.entity.SoAo;
import com.example.demo.repository.SoAoRepository;
import com.example.demo.service.SoAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoAoServiceImpl implements SoAoService {
    @Autowired
    SoAoRepository soAoRepository;

    @Override
    public List<SoAo> GetAll() {
        return soAoRepository.findAll();
    }

    @Override
    public Page<SoAo> getAll(Integer pageNo, Integer size) {
        return soAoRepository.findAll(PageRequest.of(pageNo,size));
    }

    @Override
    public void addSoAo(SoAo soAo) {
        soAoRepository.save(soAo);
    }

    @Override
    public SoAo detail(Integer id) {
        return soAoRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        soAoRepository.deleteById(id);
    }
}
