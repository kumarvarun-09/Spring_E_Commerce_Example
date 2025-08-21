package com.example.demo.service;

import com.example.demo.model.Image;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
//        product.setImageName(image.getOriginalFilename());
//        product.setImageType(image.getContentType());
//        product.setImageData(image.getBytes());
        product.setImage(new Image(image.getOriginalFilename(),
                image.getContentType(), image.getBytes()));

        return productRepository.save(product);
//        return productRepository.findById(product.getId()).orElse(null);
    }

    public Image getProductImage(int id){
        Product product = productRepository.findById(id).orElse(null);
        return (product != null) ? product.getImage() : null;
    }

}
