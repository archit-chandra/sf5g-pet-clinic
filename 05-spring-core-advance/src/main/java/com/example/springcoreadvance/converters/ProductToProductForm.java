package com.example.springcoreadvance.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.springcoreadvance.commands.ProductForm;
import com.example.springcoreadvance.domain.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setVersion(product.getVersion());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}
