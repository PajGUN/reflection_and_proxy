package ru.sunbrothers.reflection_and_proxy.main.java.reflection;

public class PowerUser extends User implements Cloneable{
    private String password;

    public PowerUser() {
    }

    public PowerUser(String name, int age, boolean sex) {
        super(name, age, sex);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
