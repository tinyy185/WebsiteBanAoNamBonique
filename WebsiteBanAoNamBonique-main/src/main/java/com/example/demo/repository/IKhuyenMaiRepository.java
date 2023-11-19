package com.example.demo.repository;

import com.example.demo.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhuyenMaiRepository extends JpaRepository<KhuyenMai,Integer> {

    @Override
    @Query("select km from KhuyenMai km order by km.trangThai.id desc ")
    List<KhuyenMai> findAll();

    @Query("select km from KhuyenMai km where km.phanTramGiam = :phanTramGiam")
    List<KhuyenMai> searchKhuyenMaiByPhanTramGiam(@Param("phanTramGiam") Float phamTramGiam);

}
