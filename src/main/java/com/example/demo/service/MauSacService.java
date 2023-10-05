package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {
    List<MauSac> GetAll();
    Page<MauSac> getAll(Integer pageNo , Integer size);
    void addMauSac(MauSac mauSac);
    MauSac detail(Integer id);
    void delete(Integer id);
}
