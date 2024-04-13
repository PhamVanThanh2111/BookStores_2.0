package dao.impl;

import entity.ChiTietHoaDon;

import java.util.List;

public interface ChiTietHoaDon_Impl {
     boolean themChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) throws Exception;

    // get all chi tiet hoa don theo ma hoa don
    List<ChiTietHoaDon> getAllChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws Exception;
}
