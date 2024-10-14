package com.cxd.repository;

import com.cxd.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository; //提供父接口JpaRepository
import org.springframework.stereotype.Repository; //提供@Repository注解

@Repository //虽然是用了接口定义，但JPA 会在项目启动时自动为 ArticlesRepository接口生成一个实现类
public interface ArticlesRepository extends JpaRepository<Articles, Long> {
	/*
	  1、内部代码为空，因为它继承了 JpaRepository 接口，自动拥有了 CRUD（创建、读取、更新、删除）操作方法
	  	save(T entity)：保存或更新一个实体。
		findById(ID id)：根据主键查找一个实体。
		findAll()：查找所有实体。
		delete(T entity)：删除一个实体。
	  2、<Articles, Long> 是泛型参数，这里有两个泛型参数：
		第一个参数 Articles：表示实体类的类型
		第二个参数 Long：表示实体类的主键类型
	 */
}
