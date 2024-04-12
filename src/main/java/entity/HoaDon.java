package entity;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
	@Id
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
