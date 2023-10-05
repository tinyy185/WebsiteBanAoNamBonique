package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GioHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Gia")
    private Float gia;

    @Column(name = "TrangThai")
    private Integer trangThai;

//    @ManyToOne
//    @JoinColumn(name = "IdKhachHang", referencedColumnName = "Id")
//    private KhachHang idKhachHang;
}
