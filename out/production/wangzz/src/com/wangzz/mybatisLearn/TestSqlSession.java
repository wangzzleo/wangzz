package com.wangzz.mybatisLearn;

import com.wangzz.mybatisLearn.bean.Blog;
import com.wangzz.mybatisLearn.mapper.BlogMapper;
import com.wangzz.mybatisLearn.mapper.GithubCompanyInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.InputStream;

public class TestSqlSession {
    public static void main(String args) throws Exception {
        //从各种类加载器的路径下找文件
//        InputStream res = Resources.getResourceAsStream("resources/mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(res);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try {
//            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//            Blog blog = mapper.selectBlog(1).orElseThrow(() -> new IllegalArgumentException("不存在！"));
//            System.out.println(blog);
//        } finally {
//            sqlSession.close();
//        }
    }

    public static void main(String[] args) throws Exception {
        //从各种类加载器的路径下找文件
        InputStream res = Resources.getResourceAsStream("resources/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(res);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            GithubCompanyInfoMapper mapper = sqlSession.getMapper(GithubCompanyInfoMapper.class);
            String basePath = "E:\\GitHub\\Enterprise-Registration-Data-of-Chinese-Mainland\\Enterprise-Registration-Data\\csv";
            File baseFile = new File(basePath);
            File[] yearFiles = baseFile.listFiles();
            if (yearFiles != null) {
                for (File yearFile : yearFiles) {
                    System.out.println(yearFile.getName());
                    File[] provinces = yearFile.listFiles();
                    if (provinces == null) {
                        continue;
                    }
                    for (File province : provinces) {
                        if (province == null) {
                            continue;
                        }
                        System.out.println(province);
                        long start = System.nanoTime()/1000000L;
                        mapper.loadData(province.getAbsolutePath());
                        System.out.printf("耗时：%dms\n", System.nanoTime()/1000000L - start);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }





}
