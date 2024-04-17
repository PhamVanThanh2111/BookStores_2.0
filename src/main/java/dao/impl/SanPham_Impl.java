package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.SanPham;

public interface SanPham_Impl extends Remote {
	public SanPham getSanPhamTheoMa(String maSanPham) throws RemoteException;
	
	public SanPham getSanPhamTheoTen(String tenSanPham) throws RemoteException;
	
	public boolean banSanPham(String maSanPham, int soLuongBan) throws RemoteException;
	
	public List<SanPham> getSanPhamGanHetHang() throws RemoteException;

	public boolean xoaSanPhamTheoMa(String maSanPham) throws RemoteException;

	public Map<SanPham, Long> getSanPhamBanChay() throws RemoteException;
}
