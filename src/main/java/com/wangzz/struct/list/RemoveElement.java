package com.wangzz.struct.list;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {

    static class Student {
        String gender;

        public String getGender() {
            return gender;
        }

        public Student(String gender) {
            this.gender = gender;
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("male"));
        list.add(new Student("male"));
        list.add(new Student("female"));
        list.add(new Student("female"));
        list.add(new Student("male"));

        //普通for循环遍历删除
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if ("male".equals(student.getGender())) {
                list.remove(i);//使用集合的删除方法删除
                i--;//★★★★★ 角标减一
            }
        }
    }
}
