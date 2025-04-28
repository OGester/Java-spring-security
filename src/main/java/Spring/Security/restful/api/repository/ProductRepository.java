package Spring.Security.restful.api.repository;

import Spring.Security.restful.api.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
