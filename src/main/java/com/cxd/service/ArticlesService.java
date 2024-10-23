package com.cxd.service;

import com.cxd.model.Articles;
import com.cxd.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired; //提供@Autowired注解
import org.springframework.stereotype.Service; //提供@Service注解

import java.util.List;

@Service  //表明ArticlesService类为服务层类
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    @Autowired //标记构造函数为自动注入点。Spring 会自动将 DAO层的实例对象注入进来
    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public List<Articles> getAllArticles() {
    	//调用对象articlesRepository的返回所有文章方法findAll()
        return (List<Articles>) articlesRepository.findAll();
    }
}
