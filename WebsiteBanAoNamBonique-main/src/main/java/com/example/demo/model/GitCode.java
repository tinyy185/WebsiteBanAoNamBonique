package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "gitcode")
@Entity
public class GitCode {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tengitcode")
    private String tenGitCode;

    @Column(name = "giatiengiam")
    private Float giaTienGiam;

    @Column(name = "trangthai")
    private Integer trangThai;

}
