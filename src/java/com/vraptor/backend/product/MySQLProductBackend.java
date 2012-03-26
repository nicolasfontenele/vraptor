package com.vraptor.backend.product;

import br.com.caelum.vraptor.ioc.Component;
import com.vraptor.model.Product;
import com.vraptor.utils.BackendException;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author nicolas
 */
@Component
public class MySQLProductBackend  implements ProductBackend {

    private SessionFactory factory;
    private Session session;
    
    public MySQLProductBackend() {
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    
    }
    
    @Override
    public Product update(Product object) throws BackendException {
        validate(object);
        Transaction tx = session.beginTransaction();
        Product updatedOne = (Product) session.merge(object);
        tx.commit();            
        return updatedOne;
        
    }

    @Override
    public void create(Product object) throws BackendException {
        
        validate(object);
        Transaction tx = session.beginTransaction();
        session.save(object);
        tx.commit();        
        
    }

    @Override
    public void remove(Product object) throws BackendException {
        validate(object);
        Transaction tx = session.beginTransaction();
        session.delete(object);
        tx.commit();
        
    }

    @Override
    public Product read(Long id) throws BackendException {
        Transaction tx = session.beginTransaction();
        Product reloaded = (Product) session.get(Product.class, id);
        tx.commit();
        return reloaded;
        
    }

    @Override
    public List<Product> list() {
        Transaction tx = session.beginTransaction();
        List<Product> list = session.createCriteria(Product.class).list();
        tx.commit();
        return list;
    }
    
    
    protected void validate(Product product) throws BackendException
    {
        if (product == null)
        {
            throw new BackendException("entity null",new NullPointerException());
        }
    }
    
    
}
