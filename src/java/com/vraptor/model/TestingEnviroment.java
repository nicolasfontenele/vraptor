package com.vraptor.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 *
 * @author nicolas
 */
public class TestingEnviroment {
    
    
    public static void main(String[] args)
    {
    
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
    
        Product product = new Product();
   
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
    }

}
