package dao.iplm;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVien_Impl extends Remote {
	// get all nhan vien
	public List<NhanVien> getAllNhanVien() throws RemoteException;

	// get nhan vien theo ten
	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) throws RemoteException;

	// get nhan vien theo ma
	public NhanVien getNhanVienTheoMa(String maNhanVien) throws RemoteException;

	// get nhan vien theo SDT
	public NhanVien getNhanVienTheoSDT(String sdtNV) throws RemoteException;

	// get nhan vien theo cccd
	public NhanVien getNhanVienTheoCCCD(String cccdNV) throws RemoteException;

	// get nhan vien theo tai khoan
	public NhanVien getNhanVienTheoTaiKhoan(String maTK) throws RemoteException;

	// them nhan vien
	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException;

	// xoa nhan vien
	public boolean xoaNhanVienTheoMa(String maNV) throws RemoteException;

	// sửa nhân viên
	public boolean suaNhanVien(NhanVien nhanVien) throws RemoteException;
}
