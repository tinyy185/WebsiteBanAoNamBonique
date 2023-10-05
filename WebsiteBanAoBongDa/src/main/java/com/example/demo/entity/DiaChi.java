package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DiaChi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "SoNha")
    private String soNha;

    @Column(name = "Xa")
    private String xa;

    @Column(name = "Huyen")
    private String huyen;

    @Column(name = "ThanhPho")
    private String thanhPho;

}
