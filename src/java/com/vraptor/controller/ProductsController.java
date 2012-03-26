package com.vraptor.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import com.vraptor.backend.product.MySQLProductBackend;
import com.vraptor.model.Product;
import com.vraptor.utils.BackendException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas
 */

@Resource
public class ProductsController {
    
    private final MySQLProductBackend backend;
    private final Result result;
    
    
    public ProductsController(MySQLProductBackend backend,Result result) {
        this.backend = backend;
        this.result = result;
    }
    
    public List<Product> listProducts()
    {
        return backend.list();
    }
    
    public void remove(Long id)
    {
        Product toRemove = null;
        try {
            toRemove = backend.read(id);
            backend.remove(toRemove);
        } catch (BackendException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, "problem on update", ex);
        }    
        
        // just for test, thats not ok!
        result.redirectTo(ProductsController.class).listProducts();
    }
    
    
    public Product update(Long id) 
    {
        try {
            return backend.read(id);
        } catch (BackendException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, "problem on read id", ex);
        }
        
        //thats not ok! just for test update!
        return null;
     }
    
    //this variable product should matches with the jsp element-name.
    public void add(Product product)  
    {
        try {
            backend.create(product);
        } catch (BackendException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, "problem on creation", ex);
        }
        //                                                          - use forward on get method.
        //redirect to the method listProducts,after show the result - use on methods post.
        result.redirectTo(ProductsController.class).listProducts();
        
        //result.of redirect to the page,without passing by the method
    }
    
    public void updateit(Product product)
    {
        try {
            backend.update(product);
        } catch (BackendException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, "product not update", ex);
        }
        
        result.redirectTo(this).listProducts();
    }
    
    public void formAdd()
    {
        
    }
    
}
