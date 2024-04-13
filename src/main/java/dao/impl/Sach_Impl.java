package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import entity.Sach;

public interface Sach_Impl extends Remote {
	public List<Sach> getAllSach() throws RemoteException;
	
	public List<Sach> getSachTheoTen(String tenSach) throws RemoteException;
	
	public boolean xoaSachTheoMaSach(String maSach) throws RemoteException;
	
	public List<Sach> getAllSachXoa() throws RemoteException;
	
	public boolean xoaSachVaoThungRac(String maSach) throws RemoteException, SQLException;
	
	public boolean khoiPhucSach(String maSachXoa) throws RemoteException, SQLException;
	
	public boolean themSach(Sach sach) throws RemoteException;
	
	public boolean suaSach(Sach sach) throws RemoteException;

	public Sach getSachTheoMa(String maSach) throws RemoteException;
}
