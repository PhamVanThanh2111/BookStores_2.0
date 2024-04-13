package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuDatHang;

public interface ChiTietPhieuDatHangImpl extends Remote {
	// them nhan vien
	public boolean themChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws RemoteException;

	// get all chi tiet hoa don theo ma hoa don
	public List<ChiTietPhieuDatHang> getAllChiTietPhieuDatHangTheoMaPhieuDatHang(String maPhieuDatHang)
			throws RemoteException;

	// xóa
	public boolean xoaChiTietPhieuDatHang(String maPhieuDatHang) throws RemoteException;
}
