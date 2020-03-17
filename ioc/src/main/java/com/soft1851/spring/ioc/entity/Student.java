package com.soft1851.spring.ioc.entity;

import java.util.List;
import java.util.Map;

public class Student {
    private Integer id;
    private String name;
    private List<String> hobbies;
    private Map map;

    public Student(Integer id, String name, List<String> hobbies, Map map) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
        this.map = map;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", map=" + map +
                '}';
    }
}
