package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietPhieuDatKey {
	private static final long serialVersionUID = 1L;

	@Column(name = "maPhieuDatHang", columnDefinition = "nvarchar(7)", nullable = false)
	private String maPhieuDatHang;

	@Column(name = "maSanPham", columnDefinition = "nvarchar(9)", nullable = false)
	private String maSanPham;

	public ChiTietPhieuDatKey() {
		super();
	}

	public ChiTietPhieuDatKey(String maPhieuDatHang, String maSanPham) {
		super();
		this.maPhieuDatHang = maPhieuDatHang;
		this.maSanPham = maSanPham;
	}

	public String getMaPhieuDatHang() {
		return maPhieuDatHang;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaPhieuDatHang(String maPhieuDatHang) {
		this.maPhieuDatHang = maPhieuDatHang;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatHang, maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieuDatKey other = (ChiTietPhieuDatKey) obj;
		return Objects.equals(maPhieuDatHang, other.maPhieuDatHang) && Objects.equals(maSanPham, other.maSanPham);
	}

}
