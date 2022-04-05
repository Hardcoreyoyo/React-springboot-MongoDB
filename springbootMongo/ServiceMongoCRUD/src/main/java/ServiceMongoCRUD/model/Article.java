package ServiceMongoCRUD.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Article {

    @Id
    private String id;

    private String note;

    private String date;

    private String time;

}
