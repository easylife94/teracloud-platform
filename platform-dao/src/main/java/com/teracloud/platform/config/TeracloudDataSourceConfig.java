package com.teracloud.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryTeracloud",
        transactionManagerRef="teracloudTX",
        basePackages= { "com.teracloud.platform.dao.teracloud" }) //设置Repository所在位置
public class TeracloudDataSourceConfig {
	
	@Autowired
	@Qualifier("teracloudDS")
	private DataSource teracloudDS;
	
	@Autowired
	private JpaProperties jpaProperties;
	
    @Primary
    @Bean(name = "entityManagerTeracloud")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryTeracloud(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryTeracloud")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTeracloud (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(teracloudDS)
                .properties(getVendorProperties(teracloudDS))
                .packages("com.teracloud.platform.entity.teracloud") //设置实体类所在位置
                .persistenceUnit("teracloudPersistenceUnit")
                .build();
    }
    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }
    
    @Bean(name = "teracloudTX")  
    PlatformTransactionManager transactionManagerTeracloud(EntityManagerFactoryBuilder builder) {  
        return new JpaTransactionManager(entityManagerFactoryTeracloud(builder).getObject());  
    }  
	
}
