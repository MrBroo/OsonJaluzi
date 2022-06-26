package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.entity.product.ProductEntity;
import byfayzullayev.jaluzi.model.receive.product.ProductReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Handler;

@RestController
@RequestMapping("/api/yourjaluzi/category/shortProduct/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> addProduct(@RequestBody ProductReceiveModel productReceiveModel) {
        return ResponseEntity.ok(productService.addProduct(productReceiveModel));

    }

    @CrossOrigin
    @GetMapping("/list")
    public HttpEntity<?> getCourseList() {
        return ResponseEntity.ok(productService.getProductList());

    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductListById(@PathVariable("id") long id) {
        ApiResponse list = productService.getProductList(id);
        return ResponseEntity.ok(list);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PutMapping("/edit/{id}")
    public HttpEntity<?> updateCategory(@RequestBody ProductEntity productEntity, @PathVariable("id") long id) {
        return ResponseEntity.ok(productService.updateProduct(id, productEntity));
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable("id") long id) {
        ApiResponse delete = productService.deleteProduct(id);
        return ResponseEntity.ok(delete);

    }


}
