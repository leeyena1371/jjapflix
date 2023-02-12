package co.study.common.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"co.study.jjapflix.repository"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    //--------------------------------- SQL TransactionManager -------------------------------------
    @Bean(name = "jjapflix")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    //--------------------------------- SQL SessionTemplate -------------------------------------
    @Bean(name = "sessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

//@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = "co.dear.admin.common.repository.dontalkadmin", sqlSessionFactoryRef = "dontalkadminSqlSessionFactory")
//public class MybatisDontalkadminConfig {
//
//    //--------------------------------- SQL DataSource -------------------------------------
//    @Primary
//    @Bean(name="dontalkadminDataSource")
//    @ConfigurationProperties(prefix = "datasource")
//    public DataSource dontalkadminDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    //--------------------------------- SQL TransactionManager -------------------------------------
//    @Bean(name = "dontalkadminSqlSessionFactory")
//    public SqlSessionFactory dontalkadminSqlSesstionFactory(@Qualifier("dontalkadminDataSource") DataSource dontalkadminDataSource, ApplicationContext applicationContext) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dontalkadminDataSource);
//        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResource("classpath:/mapper/dontalkadmin/*Mapper.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    //--------------------------------- SQL SessionTemplate -------------------------------------
//    @Bean(name = "dontalkadminTranscationManager")
//    public SqlSessionTemplate dontalkadminSqlSessionTemplate(@Qualifier("dontalkadminSqlSessionFactory") SqlSessionFactory dontalkadminSqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(dontalkadminSqlSessionFactory);
//    }
//}
