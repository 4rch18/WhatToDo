package todo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Task {

    @Id
    private long id;

    private String title;

    private String content;

    private String username;
}