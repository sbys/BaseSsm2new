package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by 12917 on 2017/7/11.
 */
@Configuration
@ComponentScan(basePackages = {"model","dao","service"})

public class SpringMyBatis {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
    {
        PropertyPlaceholderConfigurer ret = new PropertyPlaceholderConfigurer();
        ret.setLocation(new ClassPathResource("jdbc.properties"));
        return ret;
    }

    @Bean(destroyMethod = "close")
    public DataSource BasicDataSource(
            @Value("${jdbc.driver}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password)
    {
        BasicDataSource ret = new BasicDataSource();
        ret.setDriverClassName(driver);
        ret.setUrl(url);
        ret.setUsername(username);
        ret.setPassword(password);
        return ret;
    }

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource)
    {
        SqlSessionFactoryBean ret = new SqlSessionFactoryBean();
        ret.setDataSource(dataSource);
        ret.setMapperLocations(new Resource[]{new ClassPathResource("mapper/UserinfoMapper.xml"),new ClassPathResource("mapper/UserMapper.xml"),new ClassPathResource("mapper/UserpermissionMapper.xml")});
        return ret;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer()
    {
        MapperScannerConfigurer ret = new MapperScannerConfigurer();
        ret.setBasePackage("model");
        ret.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return ret;
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        DataSourceTransactionManager ret = new DataSourceTransactionManager();
        ret.setDataSource(dataSource);
        return ret;
    }
}
