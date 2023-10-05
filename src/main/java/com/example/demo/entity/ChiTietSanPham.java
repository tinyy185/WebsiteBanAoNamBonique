package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ChiTietSanPham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "Gia")
    private Float gia;

    @Column(name = "NgayNhap")
    private Date ngayNhap;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdHang", referencedColumnName = "Id")
    private Hang idHang;

    @ManyToOne
    @JoinColumn(name = "IdKichCo", referencedColumnName = "Id")
    private KichCo idKichCo;

    @ManyToOne
    @JoinColumn(name = "IdChatLieu", referencedColumnName = "Id")
    private ChatLieu idChatLieu;

    @ManyToOne
    @JoinColumn(name = "IdLoai", referencedColumnName = "Id")
    private Loai idLoai;

    @ManyToOne
    @JoinColumn(name = "IdTenCauThu", referencedColumnName = "Id")
    private TenCauThu idTenCauThu;

    @ManyToOne
    @JoinColumn(name = "IdDoiBong", referencedColumnName = "Id")
    private DoiBong idDoiBong;

    @ManyToOne
    @JoinColumn(name = "IdSoAo", referencedColumnName = "Id")
    private SoAo idSoAo;

    @ManyToOne
    @JoinColumn(name = "IdSanPham", referencedColumnName = "Id")
    private SanPham idSanPham;

    @ManyToOne
    @JoinColumn(name = "IdAnh", referencedColumnName = "Id")
    private Anh idAnh;
}
