package com.zxb.effective.chapter05.example05;

/**
 * Emulated extensible enum using an interface
 * 使用接口模拟可扩展枚举
 * @author Mr.zxb
 * @date 2019-01-06 21:32:19
 */
public interface Operation<T extends Number> {

    T apply(T x, T y);
}
