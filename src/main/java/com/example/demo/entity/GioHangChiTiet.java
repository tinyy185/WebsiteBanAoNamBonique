package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GioHangChiTiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GioHangChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Float donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSabPham", referencedColumnName = "Id")
    private ChiTietSanPham idChiTietSabPham;

    @ManyToOne
    @JoinColumn(name = "IdGioHang", referencedColumnName = "Id")
    private GioHang idGioHang;
}
