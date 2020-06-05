package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2019-11-16 20:12
 */
@SpringBootApplication
public class HelloWorld {
    public static void main(String[] args){
        //Spring 应用启动
        SpringApplication.run(HelloWorld.class, args);
    }
}
