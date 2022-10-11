package co.com.sofka.onlinestore.services;

import co.com.sofka.onlinestore.domain.Products;
import co.com.sofka.onlinestore.repositorys.ProductRepository;
import co.com.sofka.onlinestore.services.interfaces.Iproducts;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ProductServices implements Iproducts {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Products> listProducts() {
        return productRepository.findAll().map(products ->{
            products.setName(products.getName().toUpperCase());
            return products;
        });
    }

    @Override
    public Mono<Products> saveProducts(Mono<Products> productsMono) {
        return productsMono.flatMap(e -> productRepository.save(e));
    }

    @Override
    public Flux<Products> listProductName(String name) {
        return productRepository.findAll()
                .filter(data->data.getName().contains(name));
    }

    @Override
    public Mono<Double> sumPrice() {
        return productRepository.findAll()
                .map(Products::getPrice)
                .reduce(Double::sum);
    }

    @Override
    public Mono<Long> contProduct() {
        return productRepository.findAll().count();
    }

    @Override
    public Flux<Products> productFilter() {
        Flux<Products> data1 =  productRepository.findAll().filter(products -> products.getQuantity()%2==0);
        Flux<Products> data2 =  productRepository.findAll().filter(products -> products.getQuantity()%2!=0);
       return Flux.zip(data1,data2,(p1,p2)->{
           return Flux.just(p1,p2);
        }).flatMap(ele->ele);



    }


}
