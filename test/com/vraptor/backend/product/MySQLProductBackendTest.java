package com.vraptor.backend.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.vraptor.model.Product;
import com.vraptor.utils.BackendException;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class MySQLProductBackendTest {
    
    MySQLProductBackend backend;
    
    private SessionFactory factory;
    private Session session;
    private AnnotationConfiguration conf;
    
    
    public MySQLProductBackendTest() {
    }

      
    @Before
    public void setUp() {
        
        backend = new MySQLProductBackend();
        conf = new AnnotationConfiguration();
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    }
    
    @Test
    public void testThatProductCanBeCreatedOnMysqlByHibernateBackend() throws BackendException
    {
        Product toAdd = new Product();        
        
        toAdd.setDescription("frutas");
        toAdd.setName("product1");
        toAdd.setPrice(10.0);
        
        backend.create(toAdd);
        
        
        
        
    }
    
    @After
    public void tearDown() {
    }
}
