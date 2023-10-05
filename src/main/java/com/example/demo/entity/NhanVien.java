package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "nhanvien")
@Entity


public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    //
    @Column(name = "username")
    private String userName;

    @Column(name = "Encryted_Password")
    private String encrytedPassword;


    @Column(name = "Email")
    private String email;

    //
    @Column(name = "cccd")
    private String cccd;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "addresses")
    private String addresses;

    @Column(name = "qrcodedate")
    private String qrcodedate;

    @Column(name = "trangthai")
    private Integer trangThai;



    @ManyToOne
    @JoinColumn(name = "IdChucVu", referencedColumnName = "Id")
    private ChucVu idChucVu;
}
