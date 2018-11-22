package todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}
