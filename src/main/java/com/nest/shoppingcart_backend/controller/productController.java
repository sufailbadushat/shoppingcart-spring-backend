package com.nest.shoppingcart_backend.controller;


import com.nest.shoppingcart_backend.dao.ProductDao;
import com.nest.shoppingcart_backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class productController {

    @Autowired
    ProductDao productDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", produces = "application/json", consumes = "application/json")
    public Map<String,String> addProduct(@RequestBody Product p){

        productDao.save(p);
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Product> viewProduct(){
        return (List<Product>) productDao.findAll();
    }
}
