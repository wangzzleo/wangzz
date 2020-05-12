package com.wangzz.mybatisLearn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

    public Blog(String name, String title, int page, int status) {
        this.name = name;
        this.title = title;
        this.page = page;
        this.status = status;
    }

    private int id;
    private String name;
    private String title;
    private int page;
    private int status;

}
