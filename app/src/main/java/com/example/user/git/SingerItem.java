package com.example.user.git;

/**
 * Created by user on 2016-07-04.
 */
public class SingerItem {//데이터 보관용 클래스

    String name;
    String age;

    public SingerItem(){
    }

    public SingerItem(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
