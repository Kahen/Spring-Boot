package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {
  /*  @Autowired
    private DataSource dataSource;*/

  @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        Map<String, Object> map =  jdbcTemplate.queryForMap("select * from lims_user where ucode=1");
        System.out.println(map);
    }
    @Test
    void contextLoads2() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from lims_user");
        System.out.println(list);
    }

}
