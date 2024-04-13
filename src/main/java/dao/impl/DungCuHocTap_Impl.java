package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import entity.DungCuHocTap;

public interface DungCuHocTap_Impl extends Remote {
	public List<DungCuHocTap> getAllDungCuHocTap() throws RemoteException;

	public List<DungCuHocTap> getDungCuHocTapTheoTen(String tenDungCuHocTap) throws RemoteException;

	public boolean xoaDungCuHocTapTheoMa(String maDungCuHocTap) throws RemoteException;

	public List<DungCuHocTap> getAllDungCuHocTapXoa() throws RemoteException;

	public boolean xoaDungCuHocTapVaoThungRac(String maDungCuHocTap) throws RemoteException, SQLException;

	public boolean khoiPhucDungCuHocTap(String maDungCuHocTapXoa) throws RemoteException, SQLException;
	
	public boolean themDungCuHocTap(DungCuHocTap dungCuHocTap) throws RemoteException;
	
	public boolean suaDungCuHocTap(DungCuHocTap dungCuHocTap) throws RemoteException;
	
    public List<DungCuHocTap> getDungCuHocTapGanHetHang() throws RemoteException;
}
