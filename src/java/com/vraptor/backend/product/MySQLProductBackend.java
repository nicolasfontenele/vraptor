package com.vraptor.backend.product;

import com.vraptor.model.Product;
import com.vraptor.utils.BackendException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author nicolas
 */
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Product object) throws BackendException {
        
        Transaction tx = session.beginTransaction();
        session.save(object);
        tx.commit();        
        
    }

    @Override
    public void remove(Product object) throws BackendException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product read(Long id) throws BackendException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
