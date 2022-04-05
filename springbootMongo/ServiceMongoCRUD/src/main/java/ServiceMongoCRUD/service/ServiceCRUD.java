package ServiceMongoCRUD.service;


import ServiceMongoCRUD.model.Article;

import java.util.List;

public interface ServiceCRUD {

    List<Article> findArticleById(String id);

    List<Article> findAll();

    void create(String id, String title, String text, String view);

    void update(String id, String title, String content, String view);

    void delete(String id);

}
