package com.example.petfeeder.service;

import com.example.petfeeder.exception.ResourceNotFoundException;
import com.example.petfeeder.entity.Product;
import com.example.petfeeder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void updateProduct(int productId, Product product) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(()  -> new ResourceNotFoundException("Product", "id", productId));
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getBreakfast() != 0) {
            existingProduct.setBreakfast(product.getBreakfast());
        }
        if (product.getLunch() != 0) {
            existingProduct.setLunch(product.getLunch());
        }
        if (product.getDinner() != 0) {
            existingProduct.setDinner(product.getDinner());
        }
        if (product.getFeed1() != 0) {
            existingProduct.setFeed1(product.getFeed1());
        }
        if (product.getFeed2() != 0) {
            existingProduct.setFeed2(product.getFeed2());
        }
        productRepository.save(existingProduct);
    }

    public void deleteProduct(int productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
        productRepository.delete(existingProduct);
    }
}