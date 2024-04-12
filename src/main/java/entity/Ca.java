package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ca")
public class Ca {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maCa", columnDefinition = "nvarchar(3)")
	private String maCa;

	@Column(name = "tenCa", columnDefinition = "nvarchar(2)", nullable = false)
	private String tenCa;

	@Column(name = "thoiGian", columnDefinition = "nvarchar(10)", nullable = false)
	private String thoiGian;

	@OneToMany(mappedBy = "ca")
	private Set<NhanVien> nhanViens;

	public Ca() {
		super();
	}

	public Ca(String maCa) {
		super();
		this.maCa = maCa;
	}

	public Ca(String maCa, String tenCa, String thoiGian) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGian = thoiGian;
	}

	public String getMaCa() {
		return maCa;
	}

	public String getTenCa() {
		return tenCa;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public Set<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public void setNhanViens(Set<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

}
