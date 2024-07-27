package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "HoaDonCho")
@NamedQueries({
	@NamedQuery(name = "getAllHoaDonCho", query = "select hdc from HoaDonCho hdc"),
})
public class HoaDonCho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "HDC-generator")
	@GenericGenerator(name = "HDC-generator", parameters = {
			@org.hibernate.annotations.Parameter(name = "prefix", value = "HDC"),
			@org.hibernate.annotations.Parameter(name = "numberFormat", value = "%05d")},
			strategy = "entity.generateid.MyGenerator")
	@Column(name = "maHoaDonCho", columnDefinition = "nvarchar(8)")
	private String maHoaDonCho;

	@ManyToOne()
	@JoinColumn(name = "maNhanVien", columnDefinition = "nvarchar(6)", nullable = false)
	private NhanVien nhanVien;

	@ManyToOne()
	@JoinColumn(name = "maKhachHang", columnDefinition = "nvarchar(7)")
	private KhachHang khachHang;

	@Column(name = "ngayLap", nullable = false)
	private java.sql.Date ngayLap;

	@Column(name = "thanhTien", nullable = false)
	private float thanhTien;

	@OneToMany(mappedBy = "hoaDonCho")
	private Set<ChiTietHoaDonCho> chiTietHoaDonChos;

	public HoaDonCho() {
		super();
	}

	public HoaDonCho(String maHoaDonCho, Date ngayLap, float thanhTien) {
		super();
		this.maHoaDonCho = maHoaDonCho;
		this.ngayLap = ngayLap;
		this.thanhTien = thanhTien;
	}

	public String getMaHoaDonCho() {
		return maHoaDonCho;
	}

	public void setMaHoaDonCho(String maHoaDonCho) {
		this.maHoaDonCho = maHoaDonCho;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public java.sql.Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(java.sql.Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Set<ChiTietHoaDonCho> getChiTietHoaDonChos() {
		return chiTietHoaDonChos;
	}

	public void setChiTietHoaDonChos(Set<ChiTietHoaDonCho> chiTietHoaDonChos) {
		this.chiTietHoaDonChos = chiTietHoaDonChos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDonCho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonCho other = (HoaDonCho) obj;
		return Objects.equals(maHoaDonCho, other.maHoaDonCho);
	}
}
