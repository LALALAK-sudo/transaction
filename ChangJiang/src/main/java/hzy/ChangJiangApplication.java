package hzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"hzy.changJiang.dao"})
public class ChangJiangApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChangJiangApplication.class);
    }
}
