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

    @GetMapping(path = "/api/products")
    public Flux<Products> listProduct() {
        return productServices.listProducts();
    }


    @PostMapping(path = "/api/product")
    public Mono<Products> saveProduct(@RequestBody Mono<Products> productsMono) {
        return productServices.saveProducts(productsMono);
    }

    @GetMapping(path = "/api/product/{name}")
    public Flux<Products> listProductName(@PathVariable("name") String name) {
        return productServices.listProductName(name);
    }

    @GetMapping(path = "/api/products/sum")
    public Mono<Double> sumProduct() {
        return productServices.sumPrice();
    }

    @GetMapping(path = "/api/products/cont")
    public Mono<Long> contProduct() {
        return productServices.contProduct();
    }

    @GetMapping(path = "/api/products/productsColorInterleaved")
    public Flux<Products> InterleavedColorProduct() {
        return productServices.productColorInterleaved();
    }

    @GetMapping(path = "/api/products/productsSequentialColor")
    public Flux<Products> SequentialColorProduct() {
        return productServices.productSequentialColor();
    }

    @GetMapping(path = "/api/products/different")
    public Flux<Products> productDistinct(){
        return productServices.differentProducts();
    }

    @GetMapping(path = "/api/products/take/{n}")
    public Flux<Products> ListProductsTake(@PathVariable("n") Long n){
        return productServices.listOfProducts(n);
    }

    @GetMapping(path = "api/products/skip/{n}")
    public Flux<Products> listProductsSkip(@PathVariable("n") Long n){
        return productServices.skipProducts(n);
    }
}
