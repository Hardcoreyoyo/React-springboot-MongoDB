package ServiceMongoCRUD.service;

import ServiceMongoCRUD.dao.ArticleDao;
import ServiceMongoCRUD.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCRUDImpl implements ServiceCRUD{

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findArticleById(String id) {
        return articleDao.findArticleById(id);
    }

    @Override
    public List<Article> findAll() {
        Iterable<Article> iterable = articleDao.findAll();
        List<Article> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Override
    @Transactional
    public void create(String id, String note, String date, String time) {
        Article article = new Article();
        article.setId(id);
        article.setNote(note);
        article.setDate(date);
        article.setTime(time);
        articleDao.save(article);
    }

    @Override
    @Transactional
    public void update(String id, String note, String date, String time) {
        Article article = new Article();
        article.setId(id);
        article.setNote(note);
        article.setDate(date);
        article.setTime(time);
        articleDao.save(article);
    }

    @Override
    @Transactional
    public void delete(String id) {
        articleDao.deleteById(id);
    }

}
