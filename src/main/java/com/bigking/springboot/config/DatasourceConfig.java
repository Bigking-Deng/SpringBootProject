package com.bigking.springboot.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.bigking.springboot.dao", sqlSessionFactoryRef = "druidSqlSessionFactory")
public class DatasourceConfig {


    @ConfigurationProperties(prefix = "spring.datasource.master")
    @Bean("druidDatasource")
    public DataSource DruidDatasource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("druidTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(
            @Qualifier("druidDatasource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("druidSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("druidDatasource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        //在配置文件中指定mapper-location方式二选一
        Resource[] resource=  new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml");
        factoryBean.setMapperLocations(resource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        factoryBean.setConfiguration(configuration);

        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("druidSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
