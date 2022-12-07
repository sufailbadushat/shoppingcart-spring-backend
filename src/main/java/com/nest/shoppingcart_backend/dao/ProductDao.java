package com.nest.shoppingcart_backend.dao;

import com.nest.shoppingcart_backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
