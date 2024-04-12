package dao.iplm;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.PhieuDatHang;

public interface PhieuDatHang_Impl extends Remote {
	// get all hoa don
	public List<PhieuDatHang> getAllPhieuDatHang() throws RemoteException;

	// get hoa don theo ma
	public PhieuDatHang getPhieuDatHangTheoMa(String maPhieuDatHang) throws RemoteException;
	
	// them hoa don
	public boolean lapPhieuDatHang(PhieuDatHang phieuDatHang) throws RemoteException;

	// xoa phieu dat hang
	public boolean xoaPhieuDatHangTheoMa(String maPhieuDatHang) throws RemoteException;
}
