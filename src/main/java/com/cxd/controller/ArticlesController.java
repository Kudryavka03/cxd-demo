package com.cxd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController 
public class ArticlesController {
	@GetMapping("/articles/1")
	public Map<String, Object> getData() { //返回文章1的json对象
		Map<String, Object> data = new HashMap<>(); //多态创建一个集合对象（代表文章1）：左边是Map父类，右边是HashMap子类
		data.put("id", 1); //向data集合里放一个键值对（属性和属性值）
		data.put("title", "9月29日我们三班在国庆晚上有神秘嘉宾");
		return data; //不再是返回简单的字符串或数字，而是返回一个对象
	}	
}
