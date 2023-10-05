package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<KhachHang, Integer> {

    KhachHang findByEmail(String email);

    KhachHang findByMatKhau(String matKhau);

    KhachHang findByResetPass(String token);



}
