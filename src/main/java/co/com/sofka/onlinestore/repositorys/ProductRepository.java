package co.com.sofka.onlinestore.repositorys;

import co.com.sofka.onlinestore.domain.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Products,String> {

}
