package test;

import dao.HoaDon_DAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestHoaDonDao {
    private HoaDon_DAO hoaDonDao;
    @BeforeAll
    void TestHoaDonDao() throws Exception {
        hoaDonDao = new HoaDon_DAO();
    }
    @AfterAll
    void tearDownAfterClass() throws Exception {
        hoaDonDao = null;
    }
    @Test
    void testFindHoaDonByMaNhanVienVaNgay(){
        try {
            hoaDonDao.getHoaDonTheoNhanVienNgayHienTai("NV0001").forEach(hoaDon -> {
                System.out.println(hoaDon.getMaHoaDon());
            });
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
