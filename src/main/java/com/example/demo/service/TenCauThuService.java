package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.TenCauThu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TenCauThuService {
    List<TenCauThu> GetAll();
    Page<TenCauThu> getAll(Integer pageNo , Integer size);
    void addTenCauThu(TenCauThu tenCauThu);
    TenCauThu detail(Integer id);
    void delete(Integer id);
}
