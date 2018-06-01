package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

//告诉spring检索这个类来获取里面的bean
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.example.demo.dao")
public class DataSourceConfiguration {
    //从配置文件引入变量
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")//dataSource作为bean的id，在ioc中注册一个bean名字叫datasource
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //数据库连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        //关闭连接后无自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
