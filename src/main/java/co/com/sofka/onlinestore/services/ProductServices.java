package co.com.sofka.onlinestore.services;

import co.com.sofka.onlinestore.domain.Products;
import co.com.sofka.onlinestore.repositorys.ProductRepository;
import co.com.sofka.onlinestore.services.interfaces.Iproducts;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
@Data
public class ProductServices implements Iproducts {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Mono<Products> listProducts() {
        return null;
    }

    @Override
    public Mono<Products> saveProducts(Mono<Products> productsMono) {
        return null;
    }
}
