package test;

import dao.DungCuHocTap_DAO;
import dao.impl.DungCuHocTap_Impl;
import entity.DungCuHocTap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDcht {
    private DungCuHocTap_Impl dungCuHocTap_impl;

    @BeforeAll
    void TestDcht() throws RemoteException {
        dungCuHocTap_impl = new DungCuHocTap_DAO();
    }

    @AfterAll
    void close() {
        dungCuHocTap_impl = null;
    }

    @Test
    void themDungCuHocTap() throws RemoteException {
        DungCuHocTap dungCuHocTap = dungCuHocTap_impl.getDungCuHocTapTheoMa("DCHT00009");
//       if(dungCuHocTap!=null){
           DungCuHocTap dungCuHocTap_temp = new DungCuHocTap();
           dungCuHocTap_temp.setTenSanPham(dungCuHocTap.getTenSanPham());
           dungCuHocTap_temp.setXuatXu(dungCuHocTap.getXuatXu());
           dungCuHocTap_temp.setGiaNhap(dungCuHocTap.getGiaNhap());
           dungCuHocTap_temp.setGiaBan(dungCuHocTap.getGiaBan());
           dungCuHocTap_temp.setSoLuongTon(dungCuHocTap.getSoLuongTon());
           dungCuHocTap_temp.setMucTieuSuDung(dungCuHocTap.getMucTieuSuDung());
           dungCuHocTap_temp.setNhaCungCap(dungCuHocTap.getNhaCungCap());
           dungCuHocTap_temp.setHinhAnh(dungCuHocTap.getHinhAnh());
           dungCuHocTap_impl.themDungCuHocTap(dungCuHocTap_temp);
           System.out.println(dungCuHocTap_temp.getMaSanPham());
//       }
    }
}
