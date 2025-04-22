package Spring.Security.restful.api.repository;

import Spring.Security.restful.api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
