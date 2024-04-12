package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PhieuDatHang")
@NamedQueries({
	@NamedQuery(name = "getAllPhieuDatHang", query = "SELECT pdh FROM PhieuDatHang pdh"),
})
public class PhieuDatHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maPhieuDatHang", columnDefinition = "nvarchar(7)")
	private String maPhieuDatHang;

	@ManyToOne
	@JoinColumn(name = "maNhanVien", columnDefinition = "nvarchar(6)", nullable = false)
	private NhanVien nhanVien;

	@ManyToOne
	@JoinColumn(name = "maKhachHang", columnDefinition = "nvarchar(7)", nullable = false)
	private KhachHang khachHang;

	@Column(name = "ngayLap", nullable = false)
	private java.sql.Date ngayLap;

	@Column(name = "thanhTien", nullable = false)
	private float thanhTien;

	@OneToMany(mappedBy = "phieuDatHang")
	private Set<ChiTietPhieuDatHang> chiTietPhieuDatHangs;

	public PhieuDatHang() {
		super();
	}

	public PhieuDatHang(String maPhieuDatHang, Date ngayLap, float thanhTien) {
		super();
		this.maPhieuDatHang = maPhieuDatHang;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
	}

	public String getMaPhieuDatHang() {
		return maPhieuDatHang;
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

	public Set<ChiTietPhieuDatHang> getChiTietPhieuDatHangs() {
		return chiTietPhieuDatHangs;
	}

	public void setMaPhieuDatHang(String maPhieuDatHang) {
		this.maPhieuDatHang = maPhieuDatHang;
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

	public void setChiTietPhieuDatHangs(Set<ChiTietPhieuDatHang> chiTietPhieuDatHangs) {
		this.chiTietPhieuDatHangs = chiTietPhieuDatHangs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatHang other = (PhieuDatHang) obj;
		return Objects.equals(maPhieuDatHang, other.maPhieuDatHang);
	}

//	@Override
//	public String toString() {
//		return "PhieuDatHang [maPhieuDatHang=" + maPhieuDatHang + ", maNhanVien=" + maNhanVien + ", maKhachHang="
//				+ maKhachHang + ", ngayLap=" + ngayLap + ", thanhTien=" + thanhTien + "]";
//	}

}
