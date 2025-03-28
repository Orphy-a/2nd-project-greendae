package com.greenuniv.greenuniv.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(datasource);
    sqlSessionFactoryBean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
    return sqlSessionFactoryBean.getObject();
  }
}
