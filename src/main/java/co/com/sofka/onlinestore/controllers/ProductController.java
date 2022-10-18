package co.com.sofka.onlinestore.controllers;

import co.com.sofka.onlinestore.domain.Products;
import co.com.sofka.onlinestore.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductServices productServices;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/products")
    public Flux<Products> listProduct() {
        return productServices.listProducts();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/api/product")
    public Mono<Products> saveProduct(@RequestBody Mono<Products> productsMono) {
        return productServices.saveProducts(productsMono);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/products/{id}")
    public Mono<Products> getProduct(@PathVariable("id") String id){
        return productServices.getProductId(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/product/{name}")
    public Flux<Products> listProductName(@PathVariable("name") String name) {
        return productServices.listProductName(name);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/products/sum")
    public Mono<Double> sumProduct() {
        return productServices.sumPrice();
    }

    @GetMapping(path = "/api/products/cont")
    public Mono<Long> contProduct() {
        return productServices.contProduct();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/products/different")
    public Flux<Products> productDistinct(){
        return productServices.differentProducts();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/products/take/{n}")
    public Flux<Products> ListProductsTake(@PathVariable("n") Long n){
        return productServices.listOfProducts(n);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "api/products/skip/{n}")
    public Flux<Products> listProductsSkip(@PathVariable("n") Long n){
        return productServices.skipProducts(n);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/api/products/productsColorInterleaved")
    public Flux<Products> InterleavedColorProduct() {
        return productServices.productColorInterleaved();
    }

    @GetMapping(path = "/api/products/productsSequentialColor")
    public Flux<Products> SequentialColorProduct() {
        return productServices.productSequentialColor();
    }

    @GetMapping(path = "/api/products/errorReturn")
    public Flux<Products> ErrorReturnMethod() {
        return productServices.errorReturn();
    }

    @GetMapping(path = "/api/products/errorResume")
    public Flux<Products> ErrorResumeMethod() {
        return productServices.errorResume();
    }

    @GetMapping(path = "/api/products/errorMap")
    public Flux<Products> ErrorMapMethod() {
        return productServices.errorMap();
    }

    @DeleteMapping(path = "api/del/product/{id}")
    public Mono<Void> removeProduct(@PathVariable("id") String id){
        return productServices.deleteProduct(id);
    }

}
