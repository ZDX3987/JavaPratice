package com.zdx.list;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author ZDX
 * @date 2020/01/14 11:02
 */
public class MyListTest {

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>(8);
        map.put("Aa", 2112);
        map.put("BB", 2112);

        Class<? extends HashMap> aClass = map.getClass();
        System.out.println("map内数据个数："+map.size());
        Field table = aClass.getDeclaredField("table");
        table.setAccessible(true);
        System.out.println("map数组容量："+table.get(map).toString());
    }
}
