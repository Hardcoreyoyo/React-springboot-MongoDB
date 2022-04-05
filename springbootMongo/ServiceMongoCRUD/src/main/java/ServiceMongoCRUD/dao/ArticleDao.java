package ServiceMongoCRUD.dao;



import ServiceMongoCRUD.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleDao  extends MongoRepository<Article, String> {

    List<Article> findArticleById(String id);
}

