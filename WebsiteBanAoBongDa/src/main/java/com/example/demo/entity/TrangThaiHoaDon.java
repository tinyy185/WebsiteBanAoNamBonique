package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TrangThaiHoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrangThaiHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ten")
    private String ten;
}
