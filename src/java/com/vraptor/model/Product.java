package com.vraptor.model;

import br.com.caelum.vraptor.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author nicolas
 */
@Resource
@Entity
public class Product implements Serializable {
    @Id @GeneratedValue
    private Long id;
    
    private String name;
    private String description;
    private Double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String testeResource()
    {
        System.out.println("teste resource");
        return "primeiro teste usando jsp e vraptor";
    }
    
    public List<String> testeList()
    {
        List<String> names = new ArrayList<String>();
        names.add("nome1");
        names.add("nome2");
        names.add("nome3");
        names.add("nome4");
        
        return names;
    }
    
    public int testeInt()            
    {
        return 10;
    }
    
    public Product testeProduct()
    {
        Product product = new Product();
        product.setDescription("descricao");
        product.setName("nome");
        product.setPrice(10.0);
        return product;
    }
    
    
}
