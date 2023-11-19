package com.example.demo.repository;

import com.example.demo.model.ChitietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IChiTietSanPhamRepository extends JpaRepository<ChitietSanPham,Integer> {

    @Query("select ctsp from ChitietSanPham ctsp order by ctsp.idTrangThai.id ")
    Page<ChitietSanPham> findAll(Pageable pageable);

    //   San pham có mới về
    @Query("SELECT ctsp FROM ChitietSanPham ctsp ORDER BY ctsp.ngayNhap DESC")
    Page<ChitietSanPham> findTop6ByOrderByNgayNhapDesc(Pageable pageable);


    @Query("UPDATE ChitietSanPham c SET c.soLuongTon = c.soLuongTon + :quantityToSubtract WHERE c.id = :chitietsanphamId")
    void updateChitietSanPham(@Param("chitietsanphamId") int chitietsanphamId, @Param("quantityToSubtract") int quantityToSubtract);


    @Query("update ChitietSanPham set giaKhuyenMai =:giaSauKM")
    void updateAll(@Param("giaSauKM")BigDecimal giaSauKM);

    ChitietSanPham findChitietSanPhamById(Integer id);

    @Query("SELECT ctsp FROM ChitietSanPham ctsp WHERE ctsp.ten LIKE %:ten%")
    Page<ChitietSanPham> searchByTen(@Param("ten") String ten, Pageable pageable);


    @Query("SELECT ctsp FROM ChitietSanPham ctsp WHERE ctsp.ten LIKE %:ten% AND ctsp.giaBan BETWEEN :min AND :max")
    Page<ChitietSanPham> searchByTenAndGiaRange(@Param("ten") String ten, @Param("min") BigDecimal min, @Param("max") BigDecimal max, Pageable pageable);


//    tìm khoảng giá khuyến mãi
@Query("SELECT ctsp FROM ChitietSanPham ctsp WHERE ctsp.ten LIKE %:ten% AND ctsp.giaKhuyenMai BETWEEN :min AND :max")
Page<ChitietSanPham> searchByTenAndGiaKhuyenMai(@Param("ten") String ten, @Param("min") BigDecimal min, @Param("max") BigDecimal max, Pageable pageable);


    @Query("SELECT ctsp FROM ChitietSanPham ctsp JOIN ctsp.idLoai d WHERE ctsp.idLoai.id = :id")
    Page<ChitietSanPham> findByIdLoai(@Param("id") Integer idLoai, Pageable pageable);


    @Query("SELECT ctsp FROM ChitietSanPham ctsp JOIN ctsp.idMauSac d WHERE ctsp.idMauSac.id = :id")
    List<ChitietSanPham> findByIdMauSac(@Param("id") Integer idMauSac, Pageable pageable);

    // Tìm giá lớn nhất trong cột 'gia' của bảng ChitietSanPham
    @Query("SELECT MAX(ctsp.giaKhuyenMai) FROM ChitietSanPham ctsp")
    Page<ChitietSanPham> findMaxGiaWithPagination(Pageable pageable);


    ChitietSanPham findById(ChitietSanPham idChiTietSanPham);

    @Query("select ctsp from ChitietSanPham ctsp ORDER BY ctsp.giaBan DESC")
    Page<ChitietSanPham> findChitietSanPhamByGiaKhuyenMaiDesc(Pageable pageable);

    @Query("select ctsp from ChitietSanPham ctsp ORDER BY ctsp.giaBan ASC")
    Page<ChitietSanPham> findChitietSanPhamByGiaKhuyenMaiAsc(Pageable pageable);


//    List<ChitietSanPham> findByIdSanPhamAndIdMauSac(int idSanPham, int mauSac);

    @Query("SELECT ctsp FROM ChitietSanPham ctsp WHERE ctsp.idMauSac.id = :mauSacId AND ctsp.idSanPham.id = :sanPhamId")
    List<ChitietSanPham> findChitietSanPhamByIdSanPhamAndIdMauSac(int mauSacId, int sanPhamId);


    @Query("select ctsp from ChitietSanPham ctsp ORDER BY ctsp.giaBan ASC")
    Page<ChitietSanPham> findChitietSanPhamByIdSanPham(Pageable pageable);
//    @Query("SELECT p.soLuongTon FROM ChitietSanPham p WHERE p.idMauSac.ten = :mauSac AND p.idKichCo.ten = :kichCo")
//    int getSoLuongSanPham(@Param("mauSac") String mauSac, @Param("kichCo") String kichCo);

}
