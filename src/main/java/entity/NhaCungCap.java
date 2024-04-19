package entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import  org.hibernate.annotations.Parameter;
@Entity
@Table(name = "NhaCungCap")
@NamedQueries({ @NamedQuery(name = "getAllNhaCungCap", query = "SELECT ncc FROM NhaCungCap ncc"),
		@NamedQuery(name = "getNhaCungCapTheoTen", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.tenNhaCungCap LIKE :tenNhaCungCap"),
		@NamedQuery(name = "getNhaCungCapTheoDiaChi", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.diaChi LIKE :diaChi"),
		@NamedQuery(name = "getNhaCungCapTheoSoDienThoai", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.soDienThoai = :soDienThoai"), 
		@NamedQuery(name = "getNhaCungCapTheoTenList", query = "SELECT ncc FROM NhaCungCap ncc WHERE ncc.tenNhaCungCap IN :tenNhaCungCapList"), 
})
public class NhaCungCap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "NCC-generator")
	@GenericGenerator(name = "NCC-generator", parameters = {
			@Parameter(name = "prefix", value = "NCC"),
			@Parameter(name = "numberFormat", value = "%04d")},
			strategy = "entity.generateid.MyGenerator")
	@Column(name = "maNhaCungCap", columnDefinition = "nvarchar(7)")
	private String maNhaCungCap;

	@Column(name = "tenNhaCungCap", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenNhaCungCap;

	@Column(name = "diaChi", columnDefinition = "nvarchar(120)", nullable = false)
	private String diaChi;

	@Column(name = "soDienThoai", columnDefinition = "nvarchar(10)", nullable = false)
	private String soDienThoai;

	@Column(name = "email", columnDefinition = "nvarchar(50)", nullable = false)
	private String email;

	@OneToMany(mappedBy = "nhaCungCap")
	private Set<DungCuHocTap> dungCuHocTaps;

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(String maNCC) {
		super();
		this.maNhaCungCap = maNCC;
	}

	public NhaCungCap(String maNCC, String tenNCC, String diaChi, String soDienThoai, String email) {
		super();
		this.maNhaCungCap = maNCC;
		this.tenNhaCungCap = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getMaNCC() {
		return maNhaCungCap;
	}

	public void setMaNCC(String maNCC) {
		this.maNhaCungCap = maNCC;
	}

	public String getTenNCC() {
		return tenNhaCungCap;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNhaCungCap = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<DungCuHocTap> getDungCuHocTaps() {
		return dungCuHocTaps;
	}

	public void setDungCuHocTaps(Set<DungCuHocTap> dungCuHocTaps) {
		this.dungCuHocTaps = dungCuHocTaps;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhaCungCap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(maNhaCungCap, other.maNhaCungCap);
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNhaCungCap + ", tenNCC=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}
}
