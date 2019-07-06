package com.example.springcoreadvance.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springcoreadvance.commands.ProductForm;
import com.example.springcoreadvance.converters.ProductFormToProduct;
import com.example.springcoreadvance.domain.Product;
import com.example.springcoreadvance.repositories.ProductRepository;
import com.example.springcoreadvance.services.ProductService;
import com.example.springcoreadvance.services.SendTextMessageService;

@Service
@Profile({"springdatajpa", "jpadao"})
public class ProductServiceRepoImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;
    private SendTextMessageService sendTextMessageService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    @Autowired
    public void setSendTextMessageService(SendTextMessageService sendTextMessageService) {
        this.sendTextMessageService = sendTextMessageService;
    }

    @Override
    public List<?> listAll() {
        sendTextMessageService.sendTextMessage("Listing Products");

        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Integer id) {
        sendTextMessageService.sendTextMessage("Requested Product ID: " + id);
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return productRepository.save(domainObject);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
