package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JavaMailSender email;

    @Override
    public KhachHang login(String email) {
        return loginRepository.findByEmail(email);
    }

    @Override
    public void sendResetPasswordEmail(String recipientEmail, String resetToken) {
        // Tạo một đối tượng SimpleMailMessage để cấu hình email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Yêu cầu đặt lại mật khẩu");
        message.setText("Xin chào,\n\nBạn đã yêu cầu đặt lại mật khẩu. "
                + "Vui lòng truy cập liên kết sau để đặt lại mật khẩu:\n\n"
                + "http://example.com/resetpassword?token=" + resetToken + "\n\n"
                + "Nếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này."
        );

        // Gửi email
        email.send(message);
    }

    @Override
    public KhachHang dangKy(KhachHang khachHang) {
        return loginRepository.save(khachHang);
    }
}
