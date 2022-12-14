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
    public Mono<Products> getProductId(String id) {
        return productRepository.findAll()
                .filter(ele->ele.getId().equalsIgnoreCase(id))
                .next();
    }

    @Override
    public Mono<Products> saveProducts(Mono<Products> productsMono) {
        return productsMono.flatMap(e ->{
            e.setTotal(e.getPrice()*e.getQuantity());
          return productRepository.save(e);
        });
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
    public Flux<Products> productColorInterleaved() {
        Flux<Products> listGreen =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("VERDE"));
                //.concatWith(Flux.error(new RuntimeException("error")));
        Flux<Products> listRed =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("ROJO"));
        return Flux.zip(listGreen,listRed,(productGreen,productRed)->Flux.just(productGreen,productRed))
                .flatMap(product->product);

    }

    @Override
    public Flux<Products> productSequentialColor() {
        Flux<Products> listGreen =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("VERDE"));
        Flux<Products> listRed =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("ROJO"));
        return listGreen.mergeWith(listRed);
    }

    @Override
    public Flux<Products> differentProducts() {
        return productRepository.findAll()
                .distinct(Products::getColor);
    }

    @Override
    public Flux<Products> listOfProducts(Long n) {
        return productRepository.findAll().take(n);
    }

    @Override
    public Flux<Products> skipProducts(Long n) {
        return productRepository.findAll().skip(n);
    }
    public Flux<Products> errorReturn() {
        Flux<Products> listGreen =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("VERDE"))
                .concatWith(Flux.error(new RuntimeException("Este es el error return")));
        Flux<Products> listRed =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("ROJO"));
        return Flux.merge(listGreen,listRed)
                .onErrorReturn(new Products("error", "Este es el error return","error","error",0,0.0,0.0));
    }

    public Flux<Products> errorResume() {
        Flux<Products> listGreen =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("VERDE"))
                .concatWith(Flux.error(new RuntimeException("Este es el error resume ")));
        Flux<Products> listRed =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("ROJO"));
        return Flux.merge(listGreen,listRed)
                .onErrorResume(e-> Mono.just(new Products("",e.getMessage(),"error","error",0,0.0,0.0)));
    }

    public Flux<Products> errorMap() {
        Flux<Products> listGreen =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("VERDE"))
                .concatWith(Flux.error(new RuntimeException("Este es el error map")));
        Flux<Products> listRed =  productRepository.findAll()
                .filter(products -> products.getColor().equalsIgnoreCase("ROJO"));
        return Flux.merge(listGreen,listRed).onErrorMap(e-> new InterruptedException(e.getMessage()));
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return productRepository.findById(id).then();
    }


}
