package com.hy.demo.demo.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 *  配置连接多个数据库
 *      配置两个jdbc数据源
 */

@Configuration
public class DataSourceConfiguration  {

    @Bean("otherDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource otherDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean("defaultDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource defalutDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean("defaultJdbcTemplate")
    public JdbcTemplate getDefaultJdbcTemplate(@Qualifier("defaultDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean("otherJdbcTemplate")
    public JdbcTemplate getOtherJdbcTemplate(@Qualifier("otherDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



}
