package co.com.sofka.onlinestore.services.interfaces;

import co.com.sofka.onlinestore.domain.Products;
import reactor.core.publisher.Mono;

public interface Iproducts {

    Mono<Products> listProducts();
    Mono<Products> saveProducts(Mono<Products> productsMono);

}
