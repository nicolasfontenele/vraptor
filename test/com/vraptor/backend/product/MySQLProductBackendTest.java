package com.vraptor.backend.product;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //we need mode create in the tests!
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
    
    @Test
    public void testThatProductsCreatedCanBeListedOnMysqlByHibernateBackend() throws BackendException
    {
        Product product1 = createDefaultProduct();
        Product product2 = createDefaultProduct();
        Product product3 = createDefaultProduct();
        
        backend.create(product1);
        backend.create(product2);
        backend.create(product3);
        
        List<Product> reloaded = backend.list();
    
        assertEquals(3,reloaded.size());
        
    }
    
    
    @Test
    public void testBackendExceptionOnNullPointer()
    {
        try {
            backend.validate(null);
            fail("should throw exception");
        } catch (BackendException ex) {
           assertTrue( ex.getCause() instanceof NullPointerException);
        }
        
        
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
        
    //drop database - look some code to delete it.
        
        
    }
}
