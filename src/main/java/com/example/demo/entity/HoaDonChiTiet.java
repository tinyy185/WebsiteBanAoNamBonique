package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HoaDonChiTiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Float donGia;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSabPham", referencedColumnName = "Id")
    private ChiTietSanPham idChiTietSabPham;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private HoaDon idHoaDon;
}
