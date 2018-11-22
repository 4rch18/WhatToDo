package todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todo.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String>{
    List<Task> findAllByUsername(String username);
    Task findTaskByTitle(String title);
}
