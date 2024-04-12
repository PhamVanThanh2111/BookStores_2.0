package entity;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
	@Id
	@Column(name = "maKhachHang", columnDefinition = "nvarchar(7)")
	private String maKhachHang;

	@Column(name = "tenKhachHang", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenKhachHang;

	@Column(name = "gioiTinh", columnDefinition = "nvarchar(5)")
	private String gioiTinh;

	@Column(name = "soDienThoai", columnDefinition = "nvarchar(10)", nullable = false)
	private String soDienThoai;

	@Column(name = "diaChi", columnDefinition = "nvarchar(110)")
	private String diaChi;

	@OneToMany(mappedBy = "khachHang")
	private Set<HoaDon> hoaDons;

	@OneToMany(mappedBy = "khachHang")
	private Set<PhieuDatHang> phieuDatHangs;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String gioiTinh, String soDienThoai, String diaChi) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Set<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public Set<PhieuDatHang> getPhieuDatHangs() {
		return phieuDatHangs;
	}

	public void setHoaDons(Set<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public void setPhieuDatHangs(Set<PhieuDatHang> phieuDatHangs) {
		this.phieuDatHangs = phieuDatHangs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(soDienThoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(soDienThoai, other.soDienThoai);
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + "]";
	}

}
