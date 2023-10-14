package com.example.demo.controller;

import com.example.demo.entity.Anh;
import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.DoiBong;
import com.example.demo.entity.Hang;
import com.example.demo.entity.KichCo;
import com.example.demo.entity.Loai;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.SoAo;
import com.example.demo.entity.TenCauThu;
import com.example.demo.service.KichCoService;
import com.example.demo.service.impl.AnhServiceImpl;
import com.example.demo.service.impl.ChatLieuServiceImpl;
import com.example.demo.service.impl.ChiTietSanPhamServiceImpl;
import com.example.demo.service.impl.DoiBongServiceImpl;
import com.example.demo.service.impl.HangServiceImpl;
import com.example.demo.service.impl.LoaiServiceImpl;
import com.example.demo.service.impl.MauSacServiceImpl;
import com.example.demo.service.impl.SanPhamServiceImpl;
import com.example.demo.service.impl.SoAoServiceImpl;
import com.example.demo.service.impl.TenCauThuServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ChiTietSanPhamController {
@Autowired
    ChiTietSanPhamServiceImpl chiTietSanPhamService;
@Autowired
    MauSacServiceImpl mauSacService;
@Autowired
    HangServiceImpl hangService;
@Autowired
    KichCoService kichCoService;
@Autowired
    ChatLieuServiceImpl chatLieuService;
@Autowired
    LoaiServiceImpl loaiService;
@Autowired
    TenCauThuServiceImpl tenCauThuService;
@Autowired
    SoAoServiceImpl soAoService;
@Autowired
    SanPhamServiceImpl sanPhamService;
@Autowired
    AnhServiceImpl anhService;
@Autowired
    DoiBongServiceImpl doiBongService;
    @GetMapping("/chi_tiet_sp/hien_thi")
    public String hienThiChiTietSP(@RequestParam(value = "pageNo",defaultValue = "1") Integer page, Model model){
        Page<ChiTietSanPham> listctsp = chiTietSanPhamService.getAll(page -1,5);
        model.addAttribute("danhsach",listctsp.toList());
        model.addAttribute("ctsp",new ChiTietSanPham());
        return "/ChiTietSanPham/chiTietSpIndex";
    }
    @GetMapping("/View_add")
    public String viewAdd( Model model){
        List<SanPham> listsp= sanPhamService.GetAll();
        model.addAttribute("danhsachsp",listsp);
        List<Hang>listhang=hangService.GetAll();
        model.addAttribute("danhsachhang",listhang);
        List<MauSac>listmausac=mauSacService.GetAll();
        model.addAttribute("danhsachms",listmausac);
        List<KichCo>listkc=kichCoService.GetAll();
        model.addAttribute("danhsachkc",listkc);
        List<ChatLieu>listcl=chatLieuService.GetAll();
        model.addAttribute("danhsachcl",listcl);
        List<Loai>listloai=loaiService.GetAll();
        model.addAttribute("danhsachloai",listloai);
        List<TenCauThu>listtct=tenCauThuService.GetAll();
        model.addAttribute("danhsachtct",listtct);
        List<DoiBong>listdb=doiBongService.GetAll();
        model.addAttribute("danhsachdb",listdb);
        List<SoAo>listsa=soAoService.GetAll();
        model.addAttribute("danhsachsa",listsa);
        List<Anh>listanh=anhService.GetAll();
        model.addAttribute("danhsachanh",listanh);
        model.addAttribute("ctsp",new ChiTietSanPham());
        return "/ChiTietSanPham/chiTietSpAdd";
    }
    @PostMapping("/chi_tiet_sp/add")
    public String addChiTietSp(@Valid @ModelAttribute("ctsp")ChiTietSanPham chiTietSP, BindingResult result, Model model){
        if (result.hasErrors()){

            return "/ChiTietSanPham/chiTietSpIndex";
        }
        chiTietSanPhamService.addChiTietSanPham(chiTietSP);
        return "redirect:/chi_tiet_sp/hien_thi";
    }
    @GetMapping("/chi_tiet_sp/detail/{id}")
    public String detailChiTietSp(@PathVariable("id") Integer id, Model model){
        List<SanPham> listsp= sanPhamService.GetAll();
        model.addAttribute("sanpham",listsp);
        List<Hang>listhang=hangService.GetAll();
        model.addAttribute("hang",listhang);
        List<MauSac>listmausac=mauSacService.GetAll();
        model.addAttribute("mausac",listmausac);
        List<KichCo>listkc=kichCoService.GetAll();
        model.addAttribute("kc",listkc);
        List<ChatLieu>listcl=chatLieuService.GetAll();
        model.addAttribute("cl",listcl);
        List<Loai>listloai=loaiService.GetAll();
        model.addAttribute("loai",listloai);
        List<TenCauThu>listtct=tenCauThuService.GetAll();
        model.addAttribute("tct",listtct);
        List<DoiBong>listdb=doiBongService.GetAll();
        model.addAttribute("db",listdb);
        List<SoAo>listsa=soAoService.GetAll();
        model.addAttribute("sa",listsa);
        model.addAttribute("ctsp",new ChiTietSanPham());
            ChiTietSanPham chiTietSanPham =chiTietSanPhamService.detail(id);
        return "/ChiTietSanPham/chiTietSpUpdate";
    }
    @GetMapping("/chi_tiet_sp/delete/{id}")
    public String deleteChiTietSp(@PathVariable("id")Integer id){
        chiTietSanPhamService.delete(id);
        return "redirect:/chi_tiet_sp/hien_thi";
    }
    @PostMapping("/chi_tiet_sp/update")
    public String UpdateChiTietSp(@Valid @ModelAttribute("ctsp")ChiTietSanPham chiTietSP, BindingResult result,Model model){
        if (result.hasErrors()){

            return "/ChiTietSanPham/chiTietSpUpdate";
        }
        chiTietSanPhamService.addChiTietSanPham(chiTietSP);
        return "redirect:/chi_tiet_sp/hien_thi";

    }
}
