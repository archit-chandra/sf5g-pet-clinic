package com.example.springcoreadvance.services.mapservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springcoreadvance.commands.ProductForm;
import com.example.springcoreadvance.converters.ProductFormToProduct;
import com.example.springcoreadvance.domain.DomainObject;
import com.example.springcoreadvance.domain.Product;
import com.example.springcoreadvance.services.ProductService;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    private ProductFormToProduct productFormToProduct;

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

}
