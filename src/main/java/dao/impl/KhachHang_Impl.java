package dao.impl;

import entity.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface KhachHang_Impl extends Remote {
	List<KhachHang> getAllKhachHang() throws RemoteException;

	KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) throws RemoteException;

	KhachHang getKhachHangTheoMa(String maKhachHang) throws RemoteException;

	boolean xoaKhachHangTheoMa(String maKH) throws RemoteException;

	boolean suaKhachHangTheoMa(KhachHang khachHang) throws RemoteException;

	boolean themKhachHang(KhachHang khachHang) throws RemoteException;

	Map<KhachHang,Double> getKhachHangMuaNhieuTienNhat() throws RemoteException;

	Map<KhachHang,Double> getDanhSachMuoiKhachHangMuaNhieuNhat() throws RemoteException;
}
