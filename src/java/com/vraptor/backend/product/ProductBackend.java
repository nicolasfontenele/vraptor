package com.vraptor.backend.product;

import com.vraptor.backend.CRUDBackend;
import com.vraptor.model.Product;
import java.util.List;

/**
 *
 * @author nicolas
 */
public interface ProductBackend extends CRUDBackend<Product> {
    List<Product> list();
}
