package ServiceMongoCRUD.controller;

import ServiceMongoCRUD.mapper.ArticleMapper;
import ServiceMongoCRUD.mapper.DataItem;
import ServiceMongoCRUD.mapper.Response;
import ServiceMongoCRUD.model.Article;
import ServiceMongoCRUD.service.ServiceCRUD;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CRUD {

    @Autowired
    ServiceCRUD serviceCRUD;

    @GetMapping("/readall")
    public List<Article> readAll(){
        return serviceCRUD.findAll();
    }

    @GetMapping("/read/{id}")
    public List<Article> read(@PathVariable String id){
        return serviceCRUD.findArticleById(id);
    }

    @PostMapping("/create")
    public String create(@RequestBody Response response) {

        List<DataItem> list = response.getData();

//        List<DataItem> lists = Collections.synchronizedList(list);
//        迭代數據時發生丟失可考慮使用 synchronizedList 或 ConcurrentHashMap


        list.parallelStream().forEach(dataItem -> {
            String id = dataItem.getId();
            String note = dataItem.getNote();
            String date = dataItem.getDate();
            String time = dataItem.getTime();
            serviceCRUD.create(id, note, date, time);
        });

//        希望按照原來Stream的數據順序，那可以調用forEachOrdered
//        list.parallelStream().forEachOrdered(out::println);


        return "create OK !";
    }

    @PutMapping("/update")
    public String update(@RequestBody ArticleMapper articleMapper){
        String id = articleMapper.getId();
        String note = articleMapper.getNote();
        String date = articleMapper.getDate();
        String time = articleMapper.getTime();

        serviceCRUD.update(id, note, date, time);
        return "update OK !";
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable String id){
        serviceCRUD.delete(id);
        return "delete OK !";
    }


}
