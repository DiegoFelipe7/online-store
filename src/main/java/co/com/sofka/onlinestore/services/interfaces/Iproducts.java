package co.com.sofka.onlinestore.services.interfaces;

import co.com.sofka.onlinestore.domain.Products;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Iproducts {

    Flux<Products> listProducts();
    Mono<Products> saveProducts(Mono<Products> productsMono);

}
