package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DungCuHocTap")
public class DungCuHocTap extends SanPham {
	@Column(name = "mucTieuSuDung", columnDefinition = "nvarchar(100)")
	private String mucTieuSuDung;

	@ManyToOne
	@JoinColumn(name = "maNhaCungCap", columnDefinition = "nvarchar(7)", nullable = false)
	private NhaCungCap nhaCungCap;

	public DungCuHocTap() {
		super();
	}

	public DungCuHocTap(String mucTieuSuDung) {
		super();
		this.mucTieuSuDung = mucTieuSuDung;
	}

	public String getMucTieuSuDung() {
		return mucTieuSuDung;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setMucTieuSuDung(String mucTieuSuDung) {
		this.mucTieuSuDung = mucTieuSuDung;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

}
