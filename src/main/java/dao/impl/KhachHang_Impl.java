package dao.impl;

import entity.KhachHang;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface KhachHang_Impl {
    List<KhachHang> getAllKhachHang() throws Exception;

     KhachHang getKhachHangTheoSoDienThoai(String soDienThoai) throws Exception;

     KhachHang getKhachHangTheoMa(String maKhachHang) throws Exception;

     boolean xoaKhachHangTheoMa(String maKH) throws Exception ;

     boolean suaKhachHangTheoMa(KhachHang khachHang) throws Exception;

     boolean themKhachHang(KhachHang khachHang) throws Exception ;
}
