package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "KhuyenMai")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "ChieuKhau")
    private Integer chietKhau;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
