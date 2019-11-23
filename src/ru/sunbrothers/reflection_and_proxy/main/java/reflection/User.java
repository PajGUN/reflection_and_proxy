package ru.sunbrothers.reflection_and_proxy.main.java.reflection;

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

    public static Long getCount() {
        return count;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

}
