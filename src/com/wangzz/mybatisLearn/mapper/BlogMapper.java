package com.wangzz.mybatisLearn.mapper;

import com.wangzz.mybatisLearn.bean.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogMapper {
    Optional<Blog> selectBlog(int id);

    List<Blog> selectAllBlog();

    int insert(Blog blog);
}
