package com.csvtask.demo.service;

import com.csvtask.demo.entities.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getProductList(Map<String, Object> map);

    Product getProductByCode(String code);

    void deleteAllBy();
}
