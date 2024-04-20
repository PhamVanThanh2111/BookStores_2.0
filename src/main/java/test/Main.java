package test;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import dao.ChiTietPhieuDatHang_DAO;
import dao.DungCuHocTap_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import dao.SanPham_DAO;
import dao.TaiKhoan_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import entity.TaiKhoan;
import entity.generateid.DungCuHocTapGeneratorId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) throws SQLException, RemoteException {
//		Sach_DAO sach_DAO = new Sach_DAO();
//		TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
//		DungCuHocTap_DAO dungCuHocTap_DAO = new DungCuHocTap_DAO();
//		NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
//		KhachHang_DAO khachHang_DAO = new KhachHang_DAO();
//		HoaDon_DAO hoaDon_DAO = new HoaDon_DAO();
//		SanPham_DAO sanPham_DAO = new SanPham_DAO();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStores MSSQL");
//		EntityManager em = emf.createEntityManager();
//		emf.close();
//		System.out.println(phatSinhMa_DAO.getMaSachXoa());
//		Sach sach = em.find(Sach.class, "XS0002");
//		System.out.println(sach.getTacGia());
//		System.out.println(sach_DAO.xoaSachVaoThungRac("S00012"));
//		System.out.println(dungCuHocTap_DAO.xoaDungCuHocTapVaoThungRac("DCHT00020"));
//		TaiKhoan taiKhoan = new TaiKhoan();
//		taiKhoan.setMatKhau(taiKhoan.getTaiKhoan());
//		taiKhoan_DAO.themTaiKhoan(taiKhoan);
//		System.out.println(taiKhoan.getTaiKhoan());
//		sach_DAO.xoaSachVaoThungRac("S00011");
//		sach_DAO.khoiPhucSach("XS00011");
		
//		ChiTietPhieuDatHang_DAO chiTietPhieuDatHang_DAO = new ChiTietPhieuDatHang_DAO();
//		chiTietPhieuDatHang_DAO.xoaChiTietPhieuDatHang("PD00002");
		
//		NhanVien nhanvien = em.find(NhanVien.class, "NV0001");
//		KhachHang khachHang = em.find(KhachHang.class, "KH00001");
//		HoaDon hoaDon = new HoaDon();
//		hoaDon.setKhachHang(khachHang);
//		hoaDon.setNhanVien(nhanvien);
//		hoaDon.setThanhTien(20000);
//		hoaDon.setNgayLap(java.sql.Date.valueOf(java.time.LocalDate.now()));
//		hoaDon_DAO.themHoaDon(hoaDon);
		
//		System.out.println(hoaDon_DAO.getSoLuongSanPhamBanDuocTheoNgay(new Date(new java.util.Date().getTime())));
//		Map<SanPham, Long> maps = sanPham_DAO.getSanPhamBanChay();
//		maps.forEach((k, v) -> System.out.println(k.getTenSanPham() + " - " + v));
//		System.out.println(nhanVien_DAO.getNhanVienTheoMaHoaDon("HD00010").getTenNhanVien());;
	}
}
