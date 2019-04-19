package com.wangzz.mybatisLearn;

import com.wangzz.mybatisLearn.bean.Blog;
import com.wangzz.mybatisLearn.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

public class TestSqlSession {
    public static void main(String[] args) throws Exception {
        //从各种类加载器的路径下找文件
        InputStream res = Resources.getResourceAsStream("resources/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(res);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(2).orElseThrow(() -> new IllegalArgumentException("不存在！"));
            System.out.println(blog);
        } finally {
            sqlSession.close();
        }
    }
}
