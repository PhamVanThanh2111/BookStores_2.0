package dao.impl;

import entity.ChiTietHoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTietHoaDon_Impl extends Remote {
     boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException;

     List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException;
}
