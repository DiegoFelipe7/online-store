package co.com.sofka.onlinestore.services;

import co.com.sofka.onlinestore.domain.Products;
import co.com.sofka.onlinestore.repositorys.ProductRepository;
import co.com.sofka.onlinestore.services.interfaces.Iproducts;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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
}
