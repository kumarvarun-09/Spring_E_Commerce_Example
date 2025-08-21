package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
//    @RequestMapping("/getProducts")
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();
//    }

    @GetMapping("/getProduct/byId/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        Product product = productService.getProductById(id);
        HttpStatus httpStatus = (product != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(product, httpStatus);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<?> getProductImage(@PathVariable(name = "id") int id) {
        Image productImage = productService.getProductImage(id);
        return new ResponseEntity<>(productImage, (productImage != null) ?
                HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile image){
        try {
            Product addedProduct = productService.addProduct(product, image);
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
