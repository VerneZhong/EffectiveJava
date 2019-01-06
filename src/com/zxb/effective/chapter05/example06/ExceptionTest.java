package com.zxb.effective.chapter05.example06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation type with a parameter                         带参数的注释类型
 * Marker annotation type declaration                       标记注释类型声明
 * Indicates that the annotated method is a test method.    表示带注释的方法是一种测试方法。
 * Use only on parameterless static methods.                仅用于无参数静态方法。
 * @author Mr.zxb
 * @date 2019-01-06 21:32:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {

    Class<? extends Exception> value();
}
