package com.zdx.lambda;

import java.util.Optional;

/**
 * Optional操作类
 * @author ZDX
 * @date 2020/01/16 12:28
 */
public class MyOptional {

    public static void main(String[] args) {
        Person p = new Person("张三", 23);
        Optional<Person> op = Optional.ofNullable(p);
        Optional<String> s = op.map(Person::getName);
        System.out.println(s.get());
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
