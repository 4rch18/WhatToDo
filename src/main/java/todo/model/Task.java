package todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private String id;
    /**
     * Why not long?
     * https://stackoverflow.com/questions/29651147/spring-boot-mongo-e11000-duplicate-key
     */

    private String title;

    private String content;

    private String username;
}
