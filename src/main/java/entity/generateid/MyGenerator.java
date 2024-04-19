package entity.generateid;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;
public class MyGenerator
        implements IdentifierGenerator, Configurable {

    private String prefix;
    private String numberFormat;

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
            throws HibernateException {
//        System.out.println("MyGenerator.generate()");
        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        List<?> ids = session.createQuery(query).getResultList();

        Long max = ids.stream().map(o -> o.toString().replace(prefix, ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return prefix +String.format(numberFormat,  (max + 1));
    }

    @Override
    public void configure(Type type, Properties properties,
                          ServiceRegistry serviceRegistry) throws MappingException {
        prefix = properties.getProperty("prefix");
        numberFormat = properties.getProperty("numberFormat");
    }
}
