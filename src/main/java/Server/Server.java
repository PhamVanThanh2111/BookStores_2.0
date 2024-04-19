package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.Ca_DAO;
import dao.ChiTietHoaDon_DAO;
import dao.ChiTietPhieuDatHang_DAO;
import dao.DungCuHocTap_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhaCungCap_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatHang_DAO;
import dao.Sach_DAO;
import dao.SanPham_DAO;
import dao.TaiKhoan_DAO;
import dao.TheLoaiSach_DAO;
import dao.impl.Ca_Impl;
import dao.impl.ChiTietHoaDon_Impl;
import dao.impl.ChiTietPhieuDatHangImpl;
import dao.impl.DungCuHocTap_Impl;
import dao.impl.HoaDon_Impl;
import dao.impl.KhachHang_Impl;
import dao.impl.NhaCungCap_Impl;
import dao.impl.NhaXuatBan_Impl;
import dao.impl.NhanVien_Impl;
import dao.impl.PhieuDatHang_Impl;
import dao.impl.Sach_Impl;
import dao.impl.SanPham_Impl;
import dao.impl.TaiKhoan_Impl;
import dao.impl.TheLoaiSach_Impl;

public class Server {
	
	private static final String URL = "rmi://PhamVanThanh:9891/";
	public static void main(String[] args) throws RemoteException, NamingException {
		Context context = new InitialContext();

		Ca_Impl caDAO = new Ca_DAO();
		ChiTietHoaDon_Impl chiTietHoaDonDAO = new ChiTietHoaDon_DAO();
		ChiTietPhieuDatHangImpl chiTietPhieuDatHangDAO = new ChiTietPhieuDatHang_DAO();
		DungCuHocTap_Impl dungCuHocTapDAO = new DungCuHocTap_DAO();
		HoaDon_Impl hoaDonDAO = new HoaDon_DAO();
		KhachHang_Impl khachHangDAO = new KhachHang_DAO();
		NhaCungCap_Impl nhaCungCapDAO = new NhaCungCap_DAO();
		NhanVien_Impl nhanVienDAO = new NhanVien_DAO();
		NhaXuatBan_Impl nhaXuatBanDAO = new NhaXuatBan_DAO();
		PhieuDatHang_Impl phieuDatHangDAO = new PhieuDatHang_DAO();
		Sach_Impl sachDAO = new Sach_DAO();
		SanPham_Impl sanPhamDAO = new SanPham_DAO();
		TaiKhoan_Impl taiKhoanDAO = new TaiKhoan_DAO();
		TheLoaiSach_Impl theLoaiSachDAO = new TheLoaiSach_DAO();
		
		LocateRegistry.createRegistry(9891);

		context.bind(URL + "caDAO", caDAO);
		context.bind(URL + "chiTietHoaDonDAO", chiTietHoaDonDAO);
		context.bind(URL + "chiTietPhieuDatHangDAO", chiTietPhieuDatHangDAO);
		context.bind(URL + "dungCuHocTapDAO", dungCuHocTapDAO);
		context.bind(URL + "hoaDonDAO", hoaDonDAO);
		context.bind(URL + "khachHangDAO", khachHangDAO);
		context.bind(URL + "nhaCungCapDAO", nhaCungCapDAO);
		context.bind(URL + "nhanVienDAO", nhanVienDAO);
		context.bind(URL + "nhaXuatBanDAO", nhaXuatBanDAO);
		context.bind(URL + "phieuDatHangDAO", phieuDatHangDAO);
		context.bind(URL + "sachDAO", sachDAO);
		context.bind(URL + "sanPhamDAO", sanPhamDAO);
		context.bind(URL + "taiKhoanDAO", taiKhoanDAO);
		context.bind(URL + "theLoaiSachDAO", theLoaiSachDAO);

		System.out.println("Server is running...");
	}
}
