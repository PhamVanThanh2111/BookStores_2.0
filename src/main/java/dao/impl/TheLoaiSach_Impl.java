package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TheLoaiSach;

public interface TheLoaiSach_Impl extends Remote {
	// get all loai sách //lấy
	public List<TheLoaiSach> getAllTheLoaiSach() throws RemoteException;

	// get TheLoaiSach theo ma
	public TheLoaiSach getTheLoaiSachTheoMa(String maTheLoaiSach) throws RemoteException;

	// get TheLoaiSach theo tên
	public TheLoaiSach getTheLoaiSachTheoTen(String tenTheLoaiSach) throws RemoteException;

	// Thêm thể loại sách
	public boolean themTheLoaiSach(TheLoaiSach theLoaiSach) throws RemoteException;

	// xoa thể loại sách
	public boolean xoaTheLoaiSachTheoMa(String maTheLoaiSach) throws RemoteException;

	// sửa thể loại sách theo mã
	public boolean suaTheLoaiSach(TheLoaiSach theLoaiSach) throws RemoteException;
}
