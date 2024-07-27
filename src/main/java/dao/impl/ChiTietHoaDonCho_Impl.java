package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietHoaDonCho;
import entity.ChiTietHoaDonChoKey;

public interface ChiTietHoaDonCho_Impl extends Remote {
	boolean themChiTietHoaDonCho(ChiTietHoaDonCho chiTietHoaDonCho) throws RemoteException;

    List<ChiTietHoaDonCho> getAllChiTietHoaDonChoTheoMaHoaDonCho(String maHoaDonCho) throws RemoteException;
    
    boolean xoaChiTietHoaDonCho(ChiTietHoaDonChoKey chiTietHoaDonChoKey) throws RemoteException;
}
