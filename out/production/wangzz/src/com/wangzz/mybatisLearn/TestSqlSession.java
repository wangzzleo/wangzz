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
import java.util.List;
import java.util.Optional;

public class TestSqlSession {
    public static void main(String[] args) throws Exception {
        //从各种类加载器的路径下找文件
        InputStream res = Resources.getResourceAsStream("resources/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(res);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//            List<Blog> blogs = mapper.selectAllBlog();
//            System.out.println(blogs);
//            System.out.println(blogs.size());
//            Blog blog = mapper.selectBlog(1).orElseThrow(() -> new IllegalArgumentException("不存在！"));
//            System.out.println(blog);

//            System.out.println("====================================================================================================100%");
//            for (int i = 1000000; i < 2000000; i++) {
//                Blog blog = new Blog();
//                blog.setName("blog"+i);
//                blog.setPage(i);
//                blog.setStatus(i%2);
//                mapper.insert(blog);
//                if (i%10000==0) {
//                    System.out.print("=");
//                }
//            }
//            Blog blog = new Blog();
//            blog.setName("blog123123");
//            blog.setPage(1223);
//            blog.setStatus(1);
//            mapper.insert(blog);
//
//            sqlSession.commit();

            List<Blog> blogs = mapper.selectAllBlog();
            System.out.println(blogs);
        } finally {
            sqlSession.close();
        }
    }

    public static void main(String args) throws Exception {
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
