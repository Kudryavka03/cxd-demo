package com.cxd.model;

import javax.persistence.*; //导入JPA提供的所有注解和类，例如@Entity
import java.time.LocalDateTime;

@Entity  //Articles 类是一个实体类，意味着它可以映射到数据库表
@Table(name = "articles") //该实体类对应的数据库表名是articles
public class Articles {
    @Id //主键标注
    @GeneratedValue(strategy = GenerationType.IDENTITY) //值是由数据库自动增长生成的。
    @Column(name="id") //@Column用于设置本属性和数据表字段的映射关系，如果两者名称一致，可不写
    private Long id;

    @Column(nullable = false) //和表的字段设置一致，不允许值为空
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(length = 255, nullable = false)
    private String slug;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String description;

    @Lob  //注解表示该字段映射到一个大对象类型，如 BLOB 或 CLOB，这里用于存储文章正文，因为正文可能很长。
    private String body;

    @Column(nullable = false)
    private Long authorId;

    // 根据 JPA 规范，每个实体类都必须有一个无参构造函数且函数体为空。
    public Articles() {}

    // 构造函数，参数均为前面@Column注解中不允许为空的属性
    public Articles(String slug, String title, String description, String body, Long authorId) {
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.body = body;
        this.authorId = authorId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // JPA会通过反射机制调用 getter 和 setter 方法来访问和修改属性值，不写这些方法则导致获取数据失败
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
