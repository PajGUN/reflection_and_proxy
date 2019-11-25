package ru.sunbrothers.reflection_and_proxy.main.java.extra;

import ru.sunbrothers.reflection_and_proxy.main.java.extra.Utils.PrintAboutClass;
import ru.sunbrothers.reflection_and_proxy.main.java.reflection.PowerUser;

import java.lang.reflect.Field;

public class Main {

    //Дополнительное третье задание
    public static void main(String[] args) {
        //Печать иерархии
        PrintAboutClass.print(PowerUser.class);
        System.out.println("\n\n");

        User user = new User("Nik",32,true);
        try {
            //Изменение приватного поля
            System.out.println(user);
            Field name = user.getClass().getDeclaredField("name");
            name.setAccessible(true);
            name.set(user,"Petya");
            System.out.println(user);


            //Изменение приватного final поля
            //Exception - Can not set final java.lang.Long field ....
            Field id = user.getClass().getDeclaredField("id");
            id.setAccessible(true);
            id.set(user,3);
            System.out.println(user);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
