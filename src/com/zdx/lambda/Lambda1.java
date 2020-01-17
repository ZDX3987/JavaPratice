package com.zdx.lambda;

/**
 * Lambda学习
 * @author ZDX
 * @date 2020/01/16 10:02
 */
public class Lambda1 {

    public static void main(String[] args) {
        String s1 = toUpperString(s -> s.toUpperCase(), "abcdefg");
        System.out.println(s1);
    }

    public static String toUpperString(MyFunc<String> myFunc, String s) {
        return myFunc.getValue(s);
    }
}
