package entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "NhaXuatBan")
@NamedQueries({ @NamedQuery(name = "getAllNhaXuatBan", query = "SELECT nxb FROM NhaXuatBan nxb"),
		@NamedQuery(name = "getNhaXuatBanTheoTen", query = "SELECT nxb FROM NhaXuatBan nxb WHERE nxb.tenNhaXuatBan LIKE :tenNhaXuatBan"),
		@NamedQuery(name = "getNhaXuatBanTheoDiaChi", query = "SELECT nxb FROM NhaXuatBan nxb WHERE nxb.diaChi LIKE :diaChi"),
		@NamedQuery(name = "getNhaXuatBanTheoSoDienThoai", query = "SELECT nxb FROM NhaXuatBan nxb WHERE nxb.soDienThoai = :soDienThoai") })
public class NhaXuatBan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "nhaXuatBanGenerator", strategy = "entity.generateid.NhaXuatBanGeneratorId")
	@GeneratedValue(generator = "nhaXuatBanGenerator")
	@Column(name = "maNhaXuatBan", columnDefinition = "nvarchar(7)")
	private String maNhaXuatBan;

	@Column(name = "tenNhaXuatBan", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenNhaXuatBan;

	@Column(name = "diaChi", columnDefinition = "nvarchar(120)")
	private String diaChi;

	@Column(name = "soDienThoai", columnDefinition = "nvarchar(10)", nullable = false)
	private String soDienThoai;

	@Column(name = "email", columnDefinition = "nvarchar(50)")
	private String email;

	@OneToMany(mappedBy = "nhaXuatBan")
	private Set<Sach> sachs;

	public NhaXuatBan() {
		super();
	}

	public NhaXuatBan(String maNhaXuatBan) {
		super();
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public NhaXuatBan(String maNhaXuatBan, String tenNhaXuatBan, String diaChi, String soDienThoai, String email) {
		super();
		this.maNhaXuatBan = maNhaXuatBan;
		this.tenNhaXuatBan = tenNhaXuatBan;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getMaNhaXuatBan() {
		return maNhaXuatBan;
	}

	public void setMaNhaXuatBan(String maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
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

	public Set<Sach> getSachs() {
		return sachs;
	}

	public void setSachs(Set<Sach> sachs) {
		this.sachs = sachs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhaXuatBan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaXuatBan other = (NhaXuatBan) obj;
		return Objects.equals(maNhaXuatBan, other.maNhaXuatBan);
	}

	@Override
	public String toString() {
		return "NhaXuatBan [maNhaXuatBan=" + maNhaXuatBan + ", tenNhaXuatBan=" + tenNhaXuatBan + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}

}
