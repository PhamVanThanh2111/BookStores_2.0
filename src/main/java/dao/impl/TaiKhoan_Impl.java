package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.TaiKhoan;

public interface TaiKhoan_Impl extends Remote {
	public boolean themTaiKhoan(TaiKhoan tk) throws RemoteException;

	public boolean xoaTaiKhoan(String maTaiKhoan) throws RemoteException;

	public boolean suaTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;

	public ArrayList<TaiKhoan_Impl> getDanhSachTaiKhoan() throws RemoteException;

	public TaiKhoan getTaiKhoanTheoMaTaiKhoan(String maTK) throws RemoteException;

	public String getMatKhauTheoMaNhanVien(String ma) throws RemoteException;
}
