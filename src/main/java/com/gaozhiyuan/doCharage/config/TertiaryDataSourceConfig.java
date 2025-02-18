package com.gaozhiyuan.doCharage.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.gaozhiyuan.doCharage.mapper.tertiary", sqlSessionFactoryRef = "tertiarySqlSessionFactory")
public class TertiaryDataSourceConfig {

    @Bean(name = "tertiaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tertiary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tertiarySqlSessionFactory")
    public SqlSessionFactory tertiarySqlSessionFactory(@Qualifier("tertiaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/tertiary/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "tertiaryTransactionManager")
    public DataSourceTransactionManager tertiaryTransactionManager(@Qualifier("tertiaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
