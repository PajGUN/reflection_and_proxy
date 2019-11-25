package ru.sunbrothers.reflection_and_proxy.main.java.extra;

public class User {

    private static Long count = 0L;

    private final Long id;
    private String name;
    private int age;
    private boolean sex;

    public User() {
        id = count++;
    }

    public User(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        id = count++;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
