package com.hy.demo.demo.dao;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Resource(name = "defaultJdbcTemplate")
    private JdbcTemplate defaultJdbcTemplate;

    @Resource(name = "otherJdbcTemplate")
    private JdbcTemplate otherJdbcTemplate;

    public void getAll(){
        System.out.println("default datasource");
        String sql ="select * from user";
        List<Map<String,Object>> results = defaultJdbcTemplate.queryForList(sql);
        System.out.println(JSON.toJSON(results));

        System.out.println("===================================");
        System.out.println("other datasource");
        List<Map<String,Object>> otherResults = otherJdbcTemplate.queryForList(sql);
        System.out.println(JSON.toJSON(otherResults));
    }
}
