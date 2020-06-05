package com.example.springboot06;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.SQLException;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootTest
class Springboot06DataJdbcApplicationTests {
    @Autowired
    HikariDataSource hikariDataSource;
    @Test
    void contextLoads() throws SQLException {
        //org.apache.tomcat.jdbc.pool.DataSource
        System.out.println(hikariDataSource.getClass());

        Connection connection = hikariDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
