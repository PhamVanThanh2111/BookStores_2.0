package entity;

import java.io.Serializable;
import java.util.Objects;

import entity.generateid.StringPrefixedSequenceIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "NV-generator")
	@GenericGenerator(name = "NV-generator", parameters = {
			@Parameter(name = "prefix", value = "NV"),
			@Parameter(name = "numberFormat", value = "%04d")},
			strategy = "entity.generateid.MyGenerator")
	@Column(name = "taiKhoan", columnDefinition = "nvarchar(6)")
	private String taiKhoan;
	
	@Column(name = "matKhau", columnDefinition = "nvarchar(20)", nullable = false)
	private String matKhau;

	@OneToOne(mappedBy = "taiKhoan")
	private NhanVien nhanVien;

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(String taiKhoan, String matKhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public TaiKhoan(String matKhau) {
		super();
		this.matKhau = matKhau;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(taiKhoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(taiKhoan, other.taiKhoan);
	}

	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + "]";
	}

}
