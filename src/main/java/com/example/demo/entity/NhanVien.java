package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Email")
    private String email;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdChucVu", referencedColumnName = "Id")
    private ChucVu idChucVu;
}
