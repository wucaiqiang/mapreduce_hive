package com.wu.hadoop.dto;

import lombok.Data;
import lombok.ToString;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/04/22
 **/
@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
