package com.teracloud.platform.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Order
public class DataSourceConfig {

    @Bean(name = "teracloudDS")
    @Primary
    @ConfigurationProperties(prefix="spring.teracloud.datasource")
    public DataSource teracloudDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "teracloudTemplate")
    public JdbcTemplate teracloudTemplate(
            @Qualifier("teracloudDS") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

//    @Bean(name = "dogtunnelDS")
//    @ConfigurationProperties(prefix="spring.dogtunnel.datasource")
//    public DataSource dogtunnelDataSource(){
//    	DataSource source = DataSourceBuilder.create().build();
//        return source;
//    }



//    @Bean(name = "dogtunnelTemplate")
//    public JdbcTemplate dogtunnelTemplate(
//            @Qualifier("dogtunnelDS") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
    
}
