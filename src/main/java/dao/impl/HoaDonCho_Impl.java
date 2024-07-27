package dao.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HoaDonCho;

public interface HoaDonCho_Impl extends Remote {
	// lay hoa tat ca hoa don
    public List<HoaDonCho> getAllHoaDonCho() throws RemoteException;
    // lay hoa don theo ma
    public HoaDonCho getHoaDonChoTheoMa(String maHoaDonCho) throws RemoteException;
    // them hoa don cho
    public HoaDonCho themHoaDonCho(HoaDonCho hoaDonCho) throws RemoteException;
    // xoa hoa don cho
    public boolean xoaHoaDonCho(String maHoaDonCho) throws RemoteException;
}
