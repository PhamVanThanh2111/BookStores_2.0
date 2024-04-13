package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.SanPham;

public interface SanPham_Impl extends Remote {
	public SanPham getSanPhamTheoMa(String maSanPham) throws RemoteException;
	
	public SanPham getSanPhamTheoTen(String tenSanPham) throws RemoteException;
	
	public boolean banSanPham(String maSanPham, int soLuongBan) throws RemoteException;
}
