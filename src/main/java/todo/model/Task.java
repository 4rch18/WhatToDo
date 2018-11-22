package todo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Task {

    @Id
    private long id;

    private String title;

    private String content;
}
