package com.wangzz.mybatisLearn.mapper;

import com.wangzz.mybatisLearn.bean.Blog;

import java.util.Optional;

public interface BlogMapper {
    public Optional<Blog> selectBlog(int id);
}
