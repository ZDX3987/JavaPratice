package com.zdx.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 内置函数式接口测试类
 * @author ZDX
 * @date 2020/01/16 11:02
 */
public class FunctionalInterfaceTest {

    /**
     * Predicate<T> 断言型接口：将满足条件的字符串放入集合
     * @param list
     * @param predicate
     * @return
     */
    public static List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    /**
     * Function<T, R> 函数型接口：处理字符串
     * @param str
     * @param function
     * @return
     */
    public static String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    /**
     * Supplier<T> 供给型接口 :产生指定个数的整数，并放入集合
     * @param num
     * @param supplier
     * @return
     */
    public static List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    /**
     * Consumer<T> 消费型接口 :修改参数
     * @param value
     * @param consumer
     */
    public static void modifyValue(Integer value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {
        // testPredicate
        List<String> list1 = Arrays.asList("hello", "java8", "function", "predicate");
        List<String> stringList = filterStr(list1, s -> s.length() > 5);
        System.out.println("过滤后的列表为："+stringList);

        System.out.println("=======================================");
        // testFunction
        String s1 = strHandler("测试函数式接口案例", s -> s.substring(2));
        System.out.println("处理后的字符串："+s1);

        System.out.println("=======================================");
        // testSupplier
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println("获得的数字列表："+numList);

        System.out.println("=======================================");
        // testConsumer
        modifyValue(15, s -> System.out.println("消费的数据并处理："+s * 3));

    }
}
