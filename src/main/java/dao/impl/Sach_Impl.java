package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Sach;

public interface Sach_Impl extends Remote {

	public List<Sach> getAllSach() throws RemoteException;

	public List<Sach> getTenSachTheoTenSanPham(String tenSanPham) throws RemoteException;

	public boolean xoaSachTheoMa(String maSach) throws RemoteException;

	public boolean suaMaSach(Sach sach) throws RemoteException;

	public boolean khoiPhucSanPham01(Sach sach) throws RemoteException;
}
