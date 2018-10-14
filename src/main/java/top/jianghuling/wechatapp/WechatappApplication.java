package top.jianghuling.wechatapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ServletComponentScan
@ComponentScan(basePackages={"top.jianghuling.wechatapp","top.jianghuling.wechatapp.dao"})
@MapperScan("top.jianghuling.wechatapp")
public class WechatappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatappApplication.class, args);
    }
}