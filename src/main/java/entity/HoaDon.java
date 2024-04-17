package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "HoaDon")
@NamedQueries({
		@NamedQuery(name = "getAllHoaDon", query = "select hd from HoaDon hd"),
		@NamedQuery(name = "getHoaDonTheoMaNhanVienVaNgayHienTai", query = "select hd from HoaDon hd where hd.nhanVien.id = :maNhanVien and hd.ngayLap = :ngayHienTai"),
        @NamedQuery(name = "getHoaDonTheoNgay", query = "select hd from HoaDon hd where hd.ngayLap=:ngaylap"),
		@NamedQuery(name = "getHoaDonsNhieuTienNhat", query = "select hd from HoaDon hd where hd.thanhTien = (select max(hd.thanhTien) from HoaDon hd)"),
		@NamedQuery(name = "getDoanhThuTheoNgay", query = "select sum(hd.thanhTien) from HoaDon hd where hd.ngayLap = :ngaylap"),
		@NamedQuery(name = "getSoLuongSanPhamBanTheoNgay", query = "select sum(cthd.soLuong) from ChiTietHoaDon cthd where cthd.hoaDon.ngayLap = :ngaylap"),
})
public class HoaDon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "generator", strategy = "entity.generateid.HoaDonGeneratorId")
	@GeneratedValue(generator = "generator")
	@Column(name = "maHoaDon", columnDefinition = "nvarchar(7)")
	private String maHoaDon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maNhanVien", columnDefinition = "nvarchar(6)", nullable = false)
	private NhanVien nhanVien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKhachHang", columnDefinition = "nvarchar(7)")
	private KhachHang khachHang;

	@Column(name = "ngayLap", nullable = false)
	private java.sql.Date ngayLap;

	@Column(name = "thanhTien", nullable = false)
	private float thanhTien;

	@OneToMany(mappedBy = "hoaDon")
	private Set<ChiTietHoaDon> chiTietHoaDons;

	public HoaDon() {
		super();
	}

	public HoaDon(String maHoaDon, Date ngayLap, float thanhTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public java.sql.Date getNgayLap() {
		return ngayLap;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public Set<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public void setNgayLap(java.sql.Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public void setChiTietHoaDons(Set<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

//	@Override
//	public String toString() {
//		return "HoaDon [maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", maKhachHang=" + maKhachHang
//				+ ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + "]";
//	}

}
