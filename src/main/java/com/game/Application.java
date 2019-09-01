package com.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 应用程序启动类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:28
 **/
@SpringBootApplication(scanBasePackages = {"com.game", "com.fanglin"})
@MapperScan(basePackages = "com.game.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
