package co.com.sofka.onlinestore.services.interfaces;

import co.com.sofka.onlinestore.domain.Products;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Iproducts {

    Flux<Products> listProducts();

    Mono<Products> getProductId(String id);
    Mono<Products> saveProducts(Mono<Products> productsMono);

    Flux<Products> listProductName(String name);

    Mono<Double> sumPrice();

    Mono<Long> contProduct();
    Flux<Products> productColorInterleaved();
    Flux<Products> productSequentialColor();

    Flux<Products> differentProducts();

    Flux<Products> listOfProducts(Long n);

    Flux<Products>  skipProducts(Long n);

    Mono<Void> deleteProduct(String id);
}
