package com.example.springboot04webrestfulcrud.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2020-01-06 11:26
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...web应用销毁");
    }
}
