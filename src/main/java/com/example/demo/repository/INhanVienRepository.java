package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INhanVienRepository extends JpaRepository<NhanVien,Integer> {
    @Override
    List<NhanVien> findAll();
    NhanVien findNhanVienById(Integer id);
}
