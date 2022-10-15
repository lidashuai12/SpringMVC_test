package com.cqupt;

import com.cqupt.dao.AccountDao;
import com.cqupt.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class App {
    public static void main(String[] args) throws Exception{
        //1.创建SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.加载SqlMapConfig.xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //3.创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //4.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //5.执行SqlSession对象 执行查询，获取结果User
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account ac = accountDao.findById(2);
        System.out.println(ac);

        //6.释放资源
        sqlSession.close();

    }
}
