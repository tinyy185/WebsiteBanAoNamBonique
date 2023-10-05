package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "NgayDat")
    private Date ngayDat;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayKhachNhan")
    private Date ngayKhachNhan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "SdtNguoiNhan")
    private String soNguoiNhan;

    @Column(name = "TongTien")
    private Float tongTien;
//
//    @ManyToOne
//    @JoinColumn(name = "IdKhachHang", referencedColumnName = "Id")
//    private KhachHang idKhachHang;

    @ManyToOne
    @JoinColumn(name = "IdNhanVien", referencedColumnName = "Id")
    private NhanVien idNhanVien;

    @ManyToOne
    @JoinColumn(name = "IdDiaChi", referencedColumnName = "Id")
    private DiaChi idDiaChi;

    @ManyToOne
    @JoinColumn(name = "IdTrangThaiHoaDon", referencedColumnName = "Id")
    private TrangThaiHoaDon idTrangThaiHoaDon;

}
