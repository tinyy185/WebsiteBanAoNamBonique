package com.example.demo.repository;

import com.example.demo.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface IHoaDonRepository extends JpaRepository<HoaDon, Integer> {

    //Thong ke 5 tài khoản có doanh thu cao nhất
    @Query("SELECT u.userName, SUM(h.tongTien) AS tongDoanhThu " +
            "FROM HoaDon h " +
            "JOIN h.UserId u " +
            "GROUP BY u.userName " +
            "ORDER BY tongDoanhThu DESC")
    List<Object[]> findTotalRevenueByUser();



    @Query("select hd from HoaDon hd order by hd.idTT.id, hd.ngayDat desc ")
    List<HoaDon> findAll();



    @Query("SELECT hd FROM HoaDon hd WHERE hd.diaChi LIKE %:diaChiOrSdt% OR hd.sdt LIKE %:diaChiOrSdt%")
    List<HoaDon> searchHoaDonByDiaChiOrSdt(@Param("diaChiOrSdt") String diaChiOrSdt);







    @Query("SELECT h FROM HoaDon h WHERE h.UserId.userId = :userId")
    List<HoaDon> findByUserId(@Param("userId") Long userId);



    @Query("SELECT SUM(h.tongTien) FROM HoaDon h " +
            "WHERE FUNCTION('DAY', h.ngayDat) = FUNCTION('DAY', :selectedDate) " +   // Lấy theo ngày được chọn từ input
            "AND FUNCTION('MONTH', h.ngayDat) = FUNCTION('MONTH', :selectedDate) " + // Lấy theo tháng được chọn từ input
            "AND FUNCTION('YEAR', h.ngayDat) = FUNCTION('YEAR', :selectedDate) ")
    BigDecimal tinhTongDoanhThuTrongNgay(@Param("selectedDate") LocalDate selectedDate);

    @Query("SELECT SUM(h.tongTien) FROM HoaDon h " +
            "WHERE h.ngayDat >= :selectedDateStart and h.ngayDat <= :selectedDateEnd")
    BigDecimal tinhTongDoanhThuTrongKhoangNgay(@Param("selectedDateStart") LocalDateTime selectedDateStart,
                                               @Param("selectedDateEnd") LocalDateTime selectedDateEnd);

    @Query("SELECT SUM(h.tongTien) FROM HoaDon h " +
            "WHERE FUNCTION('YEAR', h.ngayDat) = FUNCTION('YEAR', :selectedDate) " +
            "AND FUNCTION('MONTH', h.ngayDat) = FUNCTION('MONTH', :selectedDate) ")
    BigDecimal tinhTongDoanhThuTrongThang(@Param("selectedDate") Date selectedDate);

    @Query("SELECT SUM(h.tongTien) FROM HoaDon h " +
            "WHERE FUNCTION('YEAR', h.ngayDat) = FUNCTION('YEAR', :selectedDate) "
    )
    BigDecimal tinhTongDoanhThuTrongNam(@Param("selectedDate") Date selectedDate);

    @Query("SELECT SUM(h.tongTien) FROM HoaDon h " +
            "WHERE FUNCTION('YEAR', h.ngayDat) = :year " +
            "AND FUNCTION('MONTH', h.ngayDat) = :month")
    BigDecimal tinhTongDoanhThuTrongThangChar(@Param("year") int year, @Param("month") int month);


}
