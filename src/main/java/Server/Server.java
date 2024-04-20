package Server;

import dao.*;
import dao.impl.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

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
		
		System.setProperty("java.rmi.server.hostname", "PhamVanThanh");

		System.out.println("Server is running...");
	}
}
