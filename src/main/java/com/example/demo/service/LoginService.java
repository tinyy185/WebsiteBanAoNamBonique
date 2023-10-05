package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;

public interface LoginService {

    KhachHang login(String email);

    void sendResetPasswordEmail(String recipientEmail, String resetToken);

    KhachHang dangKy(KhachHang khachHang);
}
