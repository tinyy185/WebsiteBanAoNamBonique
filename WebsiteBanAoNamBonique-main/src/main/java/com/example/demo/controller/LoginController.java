package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.IChiTietSanPhamService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@Controller

public class LoginController {
    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Autowired
    private IHangRepository repositoryHang;

    @Autowired
    private ILoaiRepository repositoryLoai;

    @Autowired
    private IMauSacRepository repositoryMauSac;

    @Autowired
    private IChiTietSanPhamRepository repositoryChiTiet;

    @Autowired
    private IChatLieuRepository repositoryChatLieu;

    @Autowired
    private IKichCoRepository repositoryKichCo;

    @Autowired
    private IChiTietSanPhamService serviceChiTiet;
    @Autowired
    private IGioHangRepository gioHangRepository;

    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private IGioHangChiTietSessionRepo iGioHangChiTietSessionRepo;
    @Autowired
    private IHoaDonRepository iHoaDonRepository;
    @Autowired
    private ITrangThaiOrderRepo iTrangThaiOrderRepo;
    @Autowired
    private IHoaDonChiTietRepo iHoaDonChiTietRepo;

    @Autowired
    private ISanphamRepository repositorySP;

    @Autowired
    private IGitCodeRepository repositoryGitCode;

    @RequestMapping("/login")
    public String showLogin() {
        return "login/index";
    }


    @GetMapping("/checkLogin")
    private String viewAll(Model model, HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(defaultValue = "1") int page,
                           @RequestParam(required = false, name = "email") String username,
                           @RequestParam(required = false, name = "tenSanPham") String keyword,
                           @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                           @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max,
                           @RequestParam(name = "idLoai", required = false) Integer loaiId,
                           @RequestParam(name = "sortOption", required = false) String sortOption) {
        if (page < 1) {
            page = 1;
        }

        AppUser appUser = appUserRepository.findAppUserByEmail(username);

        UserRole userRole = iUserRoleRepository.findUserRoleByAppUser(appUser);

        Pageable pageable = PageRequest.of(page - 1, 6);

        Page<ChitietSanPham> listCTSP;
//        listCTSP = repositoryChiTiet.findAll(pageable);

        // Xử lý đăng nhập cho khách hàng
        // Thực hiện các thao tác đăng nhập của khách hàng
        if (loaiId != null) {
            listCTSP = repositoryChiTiet.findByIdLoai(loaiId, pageable);
        } else if ("low-high".equals(sortOption)) {
            listCTSP = repositoryChiTiet.findChitietSanPhamByGiaKhuyenMaiAsc(pageable);
        }  else if ("high-low".equals(sortOption)) {
            listCTSP = repositoryChiTiet.findChitietSanPhamByGiaKhuyenMaiDesc(pageable);
        }

        else if (keyword == null || keyword.isBlank() && min == null && max == null) {
            listCTSP = repositoryChiTiet.findAll(pageable);
        } else if (keyword == null || keyword.isBlank()) {
            listCTSP = repositoryChiTiet.findAll(pageable);
        } else {
            listCTSP = repositoryChiTiet.searchByTenAndGiaKhuyenMai(keyword, min, max, pageable);
        }
        model.addAttribute("appUser", appUser);
        model.addAttribute("listChiTietSanPham", listCTSP);


        redirectAttributes.addAttribute("sortOption", sortOption);

        return "ban-hang/shop";
    }

    @GetMapping("/home")
    private String viewHome(Model model, @RequestParam(defaultValue = "1") int page,
                            @RequestParam(required = false, name = "email") String username,
                            @RequestParam(required = false, name = "tenSanPham") String keyword,
                            @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                            @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max,
                            @RequestParam(name = "idLoai", required = false) Integer loaiId) {
        if (page < 1) {
            page = 1;
        }

        AppUser appUser = appUserRepository.findAppUserByEmail(username);

//        UserRole userRole = iUserRoleRepository.findUserRoleByAppUser(appUser);


        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<ChitietSanPham> listCTSP;

        listCTSP = repositoryChiTiet.findTop6ByOrderByNgayNhapDesc(pageable);

        model.addAttribute("appUser", appUser);
        model.addAttribute("listChiTietSanPhamTop5", listCTSP);

        return "ban-hang/home";

    }

    @PostMapping("/checkLogin")
    public String checkLogin(ModelMap modelMap,
                             @RequestParam(required = false, name = "email") String username,
                             @RequestParam(name = "matKhau") String password, Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false, name = "tenSanPham") String keyword,
                             @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                             @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max,
                             @RequestParam(name = "idLoai", required = false) Integer loaiId
    ) {

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            // Xử lý khi tên đăng nhập hoặc mật khẩu trống
            return "login/index";
        }

        AppUser appUser = appUserRepository.findAppUserByEmail(username);

        UserRole userRole = iUserRoleRepository.findUserRoleByAppUser(appUser);


//        if (appUser != null) {
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            if (passwordEncoder.matches(password, appUser.getEncrytedPassword())) {
//                if (userRole.getAppRole().getRoleName().equals("ROLE_ADMIN")) {
//                    // Xử lý đăng nhập cho admin
//                    // Thực hiện các thao tác đăng nhập của admin
//                    if (page < 1) {
//                        page = 1;
//                    }
//
//                    Pageable pageable = PageRequest.of(page - 1, 6);
//                    Page<ChitietSanPham> listCTSP;
//
//                    if (loaiId != null) {
//                        listCTSP = repositoryChiTiet.findByIdLoai(loaiId, pageable);
//                    } else if (keyword == null || keyword.isBlank() && min == null && max == null) {
//                        listCTSP = repositoryChiTiet.findAll(pageable);
//                    } else if (keyword == null || keyword.isBlank()) {
//                        listCTSP = repositoryChiTiet.findAll(pageable);
//
//                    } else {
//                        listCTSP = serviceChiTiet.searchByTenAndGiaRange(keyword, min, max, pageable);
//                    }
//                    model.addAttribute("listChiTietSanPham", listCTSP);
//
//                    return "chi-tiet-san-pham/tables";
//
//                } else
        if (userRole.getAppRole().getRoleName().equals("ROLE_USER")) {
            Pageable pageable = PageRequest.of(page - 1, 6);
            Page<ChitietSanPham> listCTSP;

            // Xử lý đăng nhập cho khách hàng
            // Thực hiện các thao tác đăng nhập của khách hàng
            if (loaiId != null) {
                listCTSP = repositoryChiTiet.findByIdLoai(loaiId, pageable);
            } else if (keyword == null || keyword.isBlank() && min == null && max == null) {
                listCTSP = repositoryChiTiet.findAll(pageable);
            } else if (keyword == null || keyword.isBlank()) {
                listCTSP = repositoryChiTiet.findAll(pageable);
            } else {
                listCTSP = serviceChiTiet.searchByTenAndGiaRange(keyword, min, max, pageable);
            }
            model.addAttribute("appUser", appUser);
            model.addAttribute("listChiTietSanPham", listCTSP);
            return "ban-hang/shop";

        } else {

            Pageable pageable = PageRequest.of(page - 1, 6);
            Page<ChitietSanPham> listCTSP;

            // Xử lý đăng nhập cho khách hàng
            // Thực hiện các thao tác đăng nhập của khách hàng
            if (loaiId != null) {
                listCTSP = repositoryChiTiet.findByIdLoai(loaiId, pageable);
            } else if (keyword == null || keyword.isBlank() && min == null && max == null) {
                listCTSP = repositoryChiTiet.findAll(pageable);
            } else if (keyword == null || keyword.isBlank()) {
                listCTSP = repositoryChiTiet.findAll(pageable);

            } else {
                listCTSP = serviceChiTiet.searchByTenAndGiaRange(keyword, min, max, pageable);
            }
            model.addAttribute("appUser", appUser);
            model.addAttribute("listChiTietSanPham", listCTSP);
            return "ban-hang/shop";
        }
    }

    @GetMapping("/cart/{userId}")
    private String cartUser(Model model,
                            @PathVariable(name = "userId") Long userId) {
        // tìm khach hang co id
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        // lấy ra gio hàng có id là khách hàng ở trêm
        GioHang gioHang = gioHangRepository.findGioHangByUserId(appUser);
        // lấy ghct
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietRepository.findByIdGioHang(gioHang);
        model.addAttribute("gioHangChiTiets", gioHangChiTiets);
        model.addAttribute("appUser", appUser);
        return "ban-hang/cart";
    }

    @GetMapping("/my-order/{userId}")
    public String viewOrder(Model model, @PathVariable(name = "userId") Long userId) {
        // Lấy danh sách hóa đơn dựa trên userId từ repository
        List<HoaDon> hoaDons = iHoaDonRepository.findByUserId(userId);
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        model.addAttribute("hoaDon", hoaDons);
        model.addAttribute("appUser", appUser);
        return "hoa-don/hoa-don"; // Trả về trang JSP hoặc thymeleaf tương ứng
    }

    @GetMapping("/tra-hang/{id}")
    public String yeuCauTra(@PathVariable(name = "id") Integer id){
        int trangThaiId = 0;
        HoaDonChiTiet hoaDonChiTiet =iHoaDonChiTietRepo.findHoaDonChiTietById(id);
        hoaDonChiTiet.setTrangThai(trangThaiId);
        iHoaDonChiTietRepo.save(hoaDonChiTiet);
        return "hoa-don/chitiethoadon";
    }


    @GetMapping("/tra-hang-admin")
    public String adminTraHang(Model model){
       List<HoaDonChiTiet> hoaDonChiTiets = iHoaDonChiTietRepo.hienThiTraHang();
        model.addAttribute("chiTietHoaDonAdmin",hoaDonChiTiets);
        return "tra-hang/donhangtra";
    }

    @GetMapping("/tra-hang-admin/{id}")
    public String adminDongY(@PathVariable("id")Integer id,Model model) {

        int trangThaiId = 1;

        HoaDonChiTiet hoaDonChiTiet =iHoaDonChiTietRepo.findHoaDonChiTietById(id);
        hoaDonChiTiet.setTrangThai(trangThaiId);
        iHoaDonChiTietRepo.save(hoaDonChiTiet);
        return "tra-hang/donhangtra"; // Tên của trang JSP (không cần đuôi .jsp)
    }

    @GetMapping("/tra-hang-admin/tu-choi/{id}")
    public String adminTuChoi(@PathVariable("id")Integer id,Model model) {

        int trangThaiId = 4;

        HoaDonChiTiet hoaDonChiTiet =iHoaDonChiTietRepo.findHoaDonChiTietById(id);
        hoaDonChiTiet.setTrangThai(trangThaiId);
        iHoaDonChiTietRepo.save(hoaDonChiTiet);
        return "redirect:/tra-hang-admin"; // Tên của trang JSP (không cần đuôi .jsp)
    }


    // dieu diện trả hàng soluong
@PostMapping("/tra-hang-soluong")
public String traHang(
        @RequestParam("hoadonchitietId") int hoadonchitietId,
        @RequestParam("quantityToSubtract") int quantityToSubtract,
        @RequestParam("trangThai" )int trangThai,
        RedirectAttributes redirectAttributes
) {

    int trangThai1 = 2;

    HoaDonChiTiet hdct = iHoaDonChiTietRepo.findHoaDonChiTietById(hoadonchitietId);
    hdct.setTrangThai(trangThai1);
    hdct.setSoLuongTra(quantityToSubtract);
    iHoaDonChiTietRepo.save(hdct);

        if(trangThai == 2){
            serviceChiTiet.traHang(hoadonchitietId, quantityToSubtract,trangThai);
        }

    return "hoa-don/chitiethoadon" ;
}
//trangthai==3
@PostMapping("/tra-hang-kiemtra")
public String traHangKiemtra(Model model,
        @RequestParam("hoadonchitietId") int hoadonchitietId,
        @RequestParam("quantityToSubtract") int quantityToSubtract,
        @RequestParam("trangThai") int trangThai,
        RedirectAttributes redirectAttributes
) {

        int newTrangThai = 3; // Đặt trạng thái mới (3 cho trạng thái đã xác nhận)
        HoaDonChiTiet hdct = iHoaDonChiTietRepo.findHoaDonChiTietById(hoadonchitietId);
         hdct.setTrangThai(newTrangThai);
         iHoaDonChiTietRepo.save(hdct);

    if(trangThai == 3) {
        // Thực hiện xử lý trả hàng
        serviceChiTiet.traHang(hoadonchitietId, quantityToSubtract, trangThai);
        model.addAttribute("quantityToSubtract", quantityToSubtract);

    }
         return "redirect:/chi-tiet-san-pham";
}

//
    @GetMapping("/tra-hang-soluong/{id}")
    public String hienThiTrangCapNhatHoaDonChiTiet(@PathVariable("id")Integer id,Model model) {

        HoaDonChiTiet hoaDonChiTiet = iHoaDonChiTietRepo.findHoaDonChiTietById(id);

        model.addAttribute("hd",hoaDonChiTiet);
        return "ban-hang/trahang"; // Tên của trang JSP (không cần đuôi .jsp)
    }



    @GetMapping("/tra-hang-kiemtra/{id}")
    public String donHangDongY(@PathVariable("id")Integer id,Model model) {

        HoaDonChiTiet hoaDonChiTiet = iHoaDonChiTietRepo.findHoaDonChiTietById(id);

        model.addAttribute("hd",hoaDonChiTiet);
        return "ban-hang/dongytrahang"; // Tên của trang JSP (không cần đuôi .jsp)
    }

//
    HoaDonChiTiet hoaDon = new HoaDonChiTiet();

    @GetMapping("/chi-tiet-hoa-don/{userId}")
    public String viewHoaDonChiTiet(Model model, @PathVariable(name = "userId") Long userId, @RequestParam(name = "hoaDonId", required = false) Integer hoaDonId) {

        List<HoaDonChiTiet> chiTietHoaDon;

        if (hoaDonId != null) {
            chiTietHoaDon = iHoaDonChiTietRepo.timKiemHoaDonCT(hoaDonId);
        } else {
            chiTietHoaDon = iHoaDonChiTietRepo.findAll();
        }

        List<HoaDon> hoaDons = iHoaDonRepository.findByUserId(userId);
        model.addAttribute("hoaDon", hoaDons);
        // Lấy danh sách tất cả các hóa đơn
//        List<HoaDon> listCTHD = iHoaDonRepository.findAll();
//        model.addAttribute("listCTHD", listCTHD);


        model.addAttribute("chiTietHoaDon", chiTietHoaDon);

        return "hoa-don/chitiethoadon";
    }


    @PostMapping("/add-to-cart/{id}")
    private String addToCart(Model model, @PathVariable(name = "id") Integer id
            , @RequestParam(name = "userId") Long userId
            , RedirectAttributes redirectAttributes
    ) {
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        ChitietSanPham chitietSanPham = serviceChiTiet.findChitietSanPhamById(id);
        int soLuong = chitietSanPham.getSoLuongTon();
        if (soLuong >= 1) {
            iGioHangChiTietSessionRepo.addToCart(chitietSanPham, userId);
            redirectAttributes.addFlashAttribute("soLuong", soLuong);
            model.addAttribute("appUser", appUser);
        } else {
            redirectAttributes.addFlashAttribute("soLuong", soLuong);
            model.addAttribute("appUser", appUser);
        }

        return "redirect:/cart/" + userId;

    }

    @PostMapping("/add-to-cart-in-detail/{id}")
    private String addToCartInDetail(Model model, @PathVariable(name = "id") Integer id
            , @RequestParam(name = "userId") Long userId
            , @RequestParam(name = "soLuong") String soLuong
            , RedirectAttributes redirectAttributes
    ) {
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        ChitietSanPham chitietSanPham = serviceChiTiet.findChitietSanPhamById(id);
        int soLuongSanPham = chitietSanPham.getSoLuongTon();
        if (soLuongSanPham >= 1) {
            iGioHangChiTietSessionRepo.addToCart(chitietSanPham, userId);
            redirectAttributes.addFlashAttribute("soLuong", soLuongSanPham);
            model.addAttribute("appUser", appUser);
        } else {
            redirectAttributes.addFlashAttribute("soLuong", soLuongSanPham);
            model.addAttribute("appUser", appUser);
        }
        return "redirect:/cart/" + userId;
    }



    @PostMapping("/reduce-cart/{id}")
    private String giamSanPham(Model model, @PathVariable(name = "id") Integer id
            , @RequestParam(name = "userId") Long userId
    ) {
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        ChitietSanPham chitietSanPham = serviceChiTiet.findChitietSanPhamById(id);
        iGioHangChiTietSessionRepo.truSanPham(userId, chitietSanPham);
        model.addAttribute("appUser", appUser);
        return "redirect:/cart/" + userId;


    }

    @PostMapping("/remove-cart/{id}")
    private String xoaSanPham(Model model, @PathVariable(name = "id") Integer id
            , @RequestParam(name = "userId") Long userId
    ) {
        AppUser appUser = appUserRepository.findById(userId).orElse(null);
        ChitietSanPham chitietSanPham = serviceChiTiet.findChitietSanPhamById(id);
        iGioHangChiTietSessionRepo.xoaSanPham(userId, chitietSanPham);
        model.addAttribute("appUser", appUser);
        return "redirect:/cart/" + userId;


    }


    @PostMapping("/tao-hoa-don")
    private String taoHoaDon(Model model ,
                             @RequestParam(name = "userId") Long userId,  HttpSession session,
//                             @RequestParam("tenGitCode") String gitcode,
                             @RequestParam(value = "totalPrice", required = false) BigDecimal totalPrice) {

            Integer tt = 1;
            TrangThaiOrder trangThaiOrder = iTrangThaiOrderRepo.findById(tt).orElse(null);
            AppUser appUser = appUserRepository.findById(userId).orElse(null);
            GioHang gioHang = gioHangRepository.findGioHangByUserId(appUser);
            // lấy ghct
            List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietRepository.findByIdGioHang(gioHang);
            HoaDon hoaDon = new HoaDon();
            hoaDon.setUserId(appUser);
            hoaDon.setIdTT(trangThaiOrder);
            hoaDon.setTongTien(totalPrice);
            LocalDateTime currentDateTime = LocalDateTime.now();
            hoaDon.setNgayDat(currentDateTime);
            iHoaDonRepository.save(hoaDon);

            Integer idHoaDonVuaTao = hoaDon.getId();
            HoaDon hoaDonIdVuaTao = iHoaDonRepository.findById(idHoaDonVuaTao).orElse(null);

            for (GioHangChiTiet gioHangChiTiet : gioHangChiTiets) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setIdHoaDon(hoaDonIdVuaTao);
                hoaDonChiTiet.setIdChiTietSanPham(gioHangChiTiet.getIdChiTietSanPham());
                hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
                hoaDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());
                iHoaDonChiTietRepo.save(hoaDonChiTiet);
            }

        session.setAttribute("hoaDon", hoaDon);
//        model.addAttribute("totalPrice", totalPrice);
        session.setAttribute("totalPrice", totalPrice);


//        model.addAttribute("hoaDon", hoaDon2);
            return "thanh-toan/checkout" ;
        }

    @PostMapping("/check-git-code")
    public String checkGitCode(@RequestParam(name = "userId") Long userId,
                               @RequestParam("tenGitCode") String gitcode,
                               Model model,
                               HttpSession session) {
        // Lấy giá trị totalPrice từ session
        BigDecimal totalPrice = (BigDecimal) session.getAttribute("totalPrice");

        // Lấy hoaDon từ session
        HoaDon hoaDonIdVuaTao = (HoaDon) session.getAttribute("hoaDon");
        GitCode gitCode = repositoryGitCode.findGitCodeByTenGitCode(gitcode);


        if (gitCode != null && gitCode.getTenGitCode().equals(gitcode)) {
            float discountAmount = Float.parseFloat(String.valueOf(gitCode.getGiaTienGiam()));
            model.addAttribute("discountAmount", discountAmount);
            session.setAttribute("totalPrice", totalPrice);
            session.setAttribute("hoaDon", hoaDonIdVuaTao);
        }


        // Kiểm tra xem hoaDon có tồn tại không
//        if (hoaDonIdVuaTao != null) {
//            // Xử lý khi `hoaDon` có giá trị
//            // ...
//
//            session.setAttribute("hoaDon", hoaDonIdVuaTao);
//            model.addAttribute("totalPrice", totalPrice);
//
//            return "thanh-toan/checkout";
//        } else {
//            // Xử lý khi `hoaDon` là null
//            // ...
//
//            return "error-page"; // Hoặc trang lỗi tương ứng
//        }
        return "thanh-toan/checkout";
    }




    @PostMapping("/thanh-toan/{idHoaDon}")
    private String datHang(Model model,
                           @PathVariable(name = "idHoaDon") Integer idHoaDon,
                           @RequestParam(name = "sdt") String sdt,
                           @RequestParam(name = "diaChi") String diaChi,
                           @RequestParam(name = "tenNguoiNhan") String tenNguoiNhan,
                           @RequestParam(name = "sdtNguoiNhan") String sdtNguoiNhan,
                           @RequestParam(name = "tongTien") BigDecimal tongTien,
                           HttpSession session) {

        BigDecimal totalPrice = (BigDecimal) session.getAttribute("totalPrice");
        BigDecimal discountAmount = (BigDecimal) session.getAttribute("discountAmount");

        HoaDon hoaDon = iHoaDonRepository.findById(idHoaDon).orElse(null);


        hoaDon.setSdt(sdt);
        hoaDon.setDiaChi(diaChi);
        hoaDon.setTenNguoiNhan(tenNguoiNhan);
        hoaDon.setSdtNguoiNhan(sdtNguoiNhan);

        // Xác định giá trị mặc định cho discountAmount nếu nó là null
        BigDecimal discountAmountOrDefault = (discountAmount != null) ? discountAmount : BigDecimal.ZERO;
        // Thực hiện phép trừ
        hoaDon.setTongTien(tongTien.subtract(discountAmountOrDefault));
        iHoaDonRepository.save(hoaDon);

        AppUser appUser = appUserRepository.findById(hoaDon.getUserId().getUserId()).orElse(null);
        GioHang gioHang = gioHangRepository.findGioHangByUserId(appUser);
        List<GioHangChiTiet> gioHangChiTiet = gioHangChiTietRepository.findByIdGioHang(gioHang);
        gioHangChiTietRepository.deleteAll(gioHangChiTiet);
        model.addAttribute("successMessage", "Bạn đã đặt hàng thành công đơn hàng sẽ đến trong vài ngày nữa.");
        model.addAttribute("appUser", appUser);

        return "thanh-toan/thanh-cong";
    }



    @GetMapping("/detail/{id}/{idUser}")
    private String detail(Model model,
                          @PathVariable(name = "id") Integer id,
                          @PathVariable(name = "idUser") Long idUser,
                          @RequestParam(required = false, name = "mauSacId") Integer mauSacId,
                          @RequestParam(required = false, name = "sanPhamId") Integer sanPhamId
    ) {
        ChitietSanPham chiTietSanPham; // Sử dụng kiểu dữ liệu Object để chứa cả 2 kiểu dữ liệu có thể

        AppUser appUser = appUserRepository.findById(idUser).orElse(null);

            // Nếu không có mauSacId hoặc sanPhamId, tìm chi tiết sản phẩm bằng id
        chiTietSanPham = serviceChiTiet.findChitietSanPhamById(id);


        List<MauSac> listMS = repositoryMauSac.findAll();
        List<KichCo> listKichCo = repositoryKichCo.findAll();

        model.addAttribute("appUser", appUser);
        model.addAttribute("chiTietSP", chiTietSanPham);
        model.addAttribute("listMS", listMS);
        model.addAttribute("listKichCo", listKichCo);

        return "ban-hang/detail";
    }








}
