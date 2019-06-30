package com.example.springcoreadvance.services;

import com.example.springcoreadvance.commands.ProductForm;
import com.example.springcoreadvance.domain.Product;

public interface ProductService extends CRUDService<Product> {

    Product saveOrUpdateProductForm(ProductForm productForm);
}