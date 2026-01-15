package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        Product savedProduct =  productRepository.save(product);
        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getCreatedAt(),
                savedProduct.getUpdatedAt()
        );
    }

    @Transactional
    public ProductResponse updateProduct(Long id, String newName) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(newName);
        Product savedProduct =  productRepository.save(product);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getCreatedAt(),
                savedProduct.getUpdatedAt()
        );

    }

    public ProductResponse getProduct(Long id) {
        Product product =  productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );

    }
}
