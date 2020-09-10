package com.wangzz.annotest;

import javax.swing.plaf.SeparatorUI;
import java.lang.annotation.*;
import java.util.Arrays;

public class ClassAnnoTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    @interface HasInheritedAnno{
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    @interface HasInheritedAnno2 {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface NotInheritedAnno{
        String value();
    }

    @HasInheritedAnno("父类注解HasInheritedAnno")
    @HasInheritedAnno2("父类注解HasInheritedAnno2")
    @NotInheritedAnno("父类注解NotInheritedAnno")
    static class SuperClass {
    }


    @HasInheritedAnno2("子类注解HasInheritedAnno2")
    static class SubClass extends SuperClass {

    }

    public static void main(String[] args) {
        Annotation[] annotations = SubClass.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));
    }

}
