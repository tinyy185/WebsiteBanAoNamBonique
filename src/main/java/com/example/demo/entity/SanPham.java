package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SanPham")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdKhuyenMai", referencedColumnName = "Id")
    private KhuyenMai idKhuyenMai;
}
