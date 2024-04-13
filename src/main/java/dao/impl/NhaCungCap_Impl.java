package dao.impl;

import entity.NhaCungCap;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface NhaCungCap_Impl extends Remote {
    List<NhaCungCap> getAllNhaCungCap() throws RemoteException;
    
	List<NhaCungCap> getNhaCungCapTheoTenList(List<String> tenNhaCungCapList) throws RemoteException;
	
	List<NhaCungCap> getNhaCungCapTheoDiaChi(String diaChi) throws RemoteException;

	List<NhaCungCap> getNhaCungCapTheoSoDienThoai(String soDienThoai) throws RemoteException;
    
    NhaCungCap getNhaCCTheoMa(String maNCC) throws RemoteException;

    NhaCungCap getNhaCungCapTheoTen(String tenNhaCC) throws RemoteException;
    
    boolean themNhaCC(NhaCungCap nhaCC) throws RemoteException;

    boolean xoaNhaCungCapTheoMa(String maNCC) throws RemoteException;

    boolean suaNhaCungCapTheoMa(NhaCungCap nhaCC) throws RemoteException;


	
}
