package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entity.DungCuHocTap;
import entity.Sach;
import entity.SanPham;

public interface SanPham_Iplm extends Remote {
	public List<Sach> getAllSach() throws RemoteException;

	public List<Sach> getTenSachTheoTenSanPham(String tenSanPham) throws RemoteException;

	public boolean xoaSachTheoMa(String maSach) throws RemoteException;

	public boolean suaMaSach(SanPham sanPham) throws RemoteException;

	public boolean khoiPhucSanPham01(SanPham sanPham) throws RemoteException;

	public List<DungCuHocTap> getAllDungCuHocTap() throws RemoteException;

	public List<DungCuHocTap> getSanPhamTheoTenSanPham(String tenSanPham) throws RemoteException;

	public DungCuHocTap getSanPhamTheoMaSanPham(String maSanPham) throws RemoteException;

	public boolean themSanPham(SanPham sanPham) throws RemoteException;

	public boolean suaSanPhamTheoMa(SanPham sanPham) throws RemoteException;

	public boolean banSanPham(String maSanPham, int soLuong) throws RemoteException;

	public boolean suaMaDCHT(SanPham sanPham) throws RemoteException;

	public boolean khoiPhucSanPham(SanPham sanPham) throws RemoteException;

	public ArrayList<DungCuHocTap> getAllDCHTXoa() throws RemoteException;

	public ArrayList<Sach> getAllSachXoa() throws RemoteException;

	public ArrayList<SanPham> getSanPhamGanHetHang() throws RemoteException;
}
