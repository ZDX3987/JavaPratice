package com.zdx.lambda;

/**
 * 只包含一个抽象方法的接口称为函数式接口
 * 自定义函数式接口
 * @author ZDX
 * @date 2020/01/16 10:32
 */
@FunctionalInterface
public interface MyFunc<T> {
    /**
     * 函数式接口唯一抽象方法
     * @param t
     * @return
     */
    T getValue(T t);
}
