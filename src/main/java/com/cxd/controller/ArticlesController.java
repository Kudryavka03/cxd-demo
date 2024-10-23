package com.cxd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; //@RequestMapping注解，用于指定控制器的根路径。
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired; //提供@Autowired注解
import java.util.*;
import com.cxd.service.ArticlesService;
import com.cxd.model.Articles;

@RestController 
@RequestMapping("/api")  //指定这个控制器的根路径为 /api。所有该控制器下的方法的路径都会以 /api 开头。
public class ArticlesController {
	private final ArticlesService articlesService; 
	
	@Autowired //标记构造函数为自动注入点。Spring 会自动将 服务层的实例对象注入进来
	public ArticlesController(ArticlesService articlesService) {
		this.articlesService = articlesService;
	}
	
	@GetMapping("/articles") //处理新路由，记得前面会自动加上/api
	public List<Articles> getAllArticles() {
		return articlesService.getAllArticles();
	}
	
	@GetMapping("/articles/1")
	public Map<String, Object> getData() { //返回文章1的json对象
		Map<String, Object> data = new HashMap<>(); //多态创建一个集合对象（代表文章1）：左边是Map父类，右边是HashMap子类
		data.put("id", 1); //向data集合里放一个键值对（属性和属性值）
		data.put("title", "9月29日我们三班在国庆晚上有神秘嘉宾");
		return data; //不再是返回简单的字符串或数字，而是返回一个对象
	}	
}
