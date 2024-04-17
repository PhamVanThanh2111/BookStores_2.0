package dao.impl;

import entity.ChiTietHoaDon;

import java.util.List;

public interface ChiTietHoaDon_Impl {
     boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) throws Exception;

     List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws Exception;
}
