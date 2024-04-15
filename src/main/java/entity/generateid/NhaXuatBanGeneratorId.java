package entity.generateid;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class NhaXuatBanGeneratorId implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
	    String prefix = "NXB";
	    EntityManager entityManager = null;
	    try {
	        entityManager = Persistence.createEntityManagerFactory("BookStores MSSQL").createEntityManager();
	        Long count = (Long) entityManager.createQuery("select count(maNhaXuatBan) from NhaXuatBan")
	                                        .getSingleResult();
	        String ma = prefix + String.format("%04d", count + 1);
	        return ma;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        if (entityManager != null && entityManager.isOpen()) {
	            entityManager.close();
	        }
	    }
	}
}
