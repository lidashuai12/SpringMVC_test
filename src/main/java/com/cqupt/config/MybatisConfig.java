package com.cqupt.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        //这行代码替代的是sqlMapConfig.xml中的typeAlias那一行，起别名，以包扫描的方式指定 包名
        ssfb.setTypeAliasesPackage("com.cqupt.domain");
        //这行代码替代的是sqlMapConfig.xml中的配置DataSource，由于DatdSource已经创建好了，并且以@Bean的方式生成了第三方Bean，只需要
        //通过注入第三方Bean的方式，将注入对象写在形参中
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){//用来替代配置文件中的mapper项
        //会扫描包中的每个接口，把每个接口都创建一次getMapper方法，得到每个接口的Dao对象，把Dao对象放入容器。
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.cqupt.dao");
        return msc;
    }
}
