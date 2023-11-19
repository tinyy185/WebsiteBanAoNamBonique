package com.example.demo.repository;

import com.example.demo.model.ChitietSanPham;
import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISanphamRepository extends JpaRepository<SanPham,Integer> {
//    void setTrangThai(int trangThai);
   Page<SanPham> findAll(Pageable pageable);

   SanPham findSanPhamById(Integer id);
}
