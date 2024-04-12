package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DungCuHocTap;
import entity.Sach;
import entity.SanPham;

public interface SanPham_Iplm extends Remote {
	public List<Sach> getAllSach() throws RemoteException;

	public SanPham getTenSachTheoTenSanPham(String tenSanPham) throws RemoteException;

	public boolean xoaSachTheoMa(String maSach) throws RemoteException;

	public boolean suaMaSach(SanPham sanPham) throws RemoteException;

	public boolean khoiPhucSanPham01(SanPham sanPham) throws RemoteException;

	public List<SanPham> getAllDungCuHocTap() throws RemoteException;

	public SanPham getSanPhamTheoTenSanPham(String tenSanPham) throws RemoteException;

	public SanPham getSanPhamTheoMaSanPham(String maSanPham) throws RemoteException;

	public boolean themSanPham(SanPham sanPham) throws RemoteException;

	public boolean suaSanPhamTheoMa(SanPham sanPham) throws RemoteException;

	public boolean banSanPham(String maSanPham, int soLuong) throws RemoteException;

	public boolean suaMaDCHT(SanPham sanPham) throws RemoteException;

	public boolean khoiPhucSanPham(SanPham sanPham) throws RemoteException;

	public List<DungCuHocTap> getAllDCHTXoa() throws RemoteException;

	public List<Sach> getAllSachXoa() throws RemoteException;

	public List<SanPham> getSanPhamGanHetHang() throws RemoteException;
}
