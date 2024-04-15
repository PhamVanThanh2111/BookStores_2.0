package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuDatHang;

public interface ChiTietPhieuDatHangImpl extends Remote {
	public boolean themChiTietPhieuDatHang(ChiTietPhieuDatHang chiTietPhieuDatHang) throws RemoteException;

	public List<ChiTietPhieuDatHang> getAllChiTietPhieuDatHangTheoMa(String maPhieuDatHang)
			throws RemoteException;

	public boolean xoaChiTietPhieuDatHang(String maPhieuDatHang) throws RemoteException;
}
