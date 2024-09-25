package com.cxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //  Springboot项目启动类，类名可自定义，但类定义前用@SpringBootApplication注解表明是项目启动类，负责启动项目
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" ); //原生输出
    	SpringApplication.run(App.class, args); //换成springboot控制下的路由输出
    }
}
