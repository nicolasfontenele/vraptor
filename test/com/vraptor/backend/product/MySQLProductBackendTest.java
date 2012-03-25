package com.vraptor.backend.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.vraptor.model.Product;
import com.vraptor.utils.BackendException;
import java.util.Properties;
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
    private Properties forTest;
    
    public MySQLProductBackendTest() {
    }

      
    @Before
    public void setUp() {
        
        backend = new MySQLProductBackend();
        conf = new AnnotationConfiguration();
        
        forTest = new Properties();
        forTest.put("hibernate.hbm2ddl.auto", "create");
        
        conf.mergeProperties(forTest);
        
        conf.configure();
        factory = conf.buildSessionFactory();
        session = factory.openSession();
    }
    
    @Test
    public void testThatProductCanBeCreatedOnMysqlByHibernateBackend() throws BackendException
    {
        Product toAdd = createDefaultProduct();
        
        String productName = toAdd.getName();
        
        backend.create(toAdd);
        
        Product reloaded = (Product) session.get(Product.class, 1L);
        assertEquals(productName, reloaded.getName());
        
        
    }
    
    
    
    @Test
    public void testThatProductCanBeRemovedOnMysqlByHibernateBackend() throws BackendException
    {
        Product toRemove = createDefaultProduct();
               
        backend.create(toRemove);
        backend.remove(toRemove);        
        Product reloaded = (Product) session.get(Product.class, 1L);
        
        assertNull(reloaded);
    
    }
    
    @Test
    public void testThatACreatedProductCanBeReadOnMysqlByHibernateBackend() throws BackendException
    {
        
        Product toAdd = createDefaultProduct();
        String productName = toAdd.getName();
        backend.create(toAdd);    
        
        assertEquals(productName, backend.read(1L).getName());
        
    }
    
    @Test
    public void testThatACreatedProductCanAlsoBeUpdatedOnMysqlByHibernateBackend() throws BackendException
    {
        
        Product toAdd = createDefaultProduct();
        backend.create(toAdd);   
        
        String updatedName = "product" + Math.random();
        toAdd.setName(updatedName);
        backend.update(toAdd);
        
        assertEquals(updatedName, backend.read(1L).getName());
    
    }
 
    protected Product createDefaultProduct()
    {
        String name = "product " + Math.random();
        Product defaultOne = new Product();        
        
        defaultOne.setDescription("frutas");
        defaultOne.setName(name);
        defaultOne.setPrice(10.0);
        return defaultOne;
    }
    
    @After
    public void tearDown() {
        
    
        
        
    }
}
