package ru.sunbrothers.reflection_and_proxy.main.java.extra.Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintAboutClass {

    public static void print(Class c){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя класса: ").append(c.getSimpleName()).append("\n");
        sb.append("Имя пакета: ").append(c.getPackageName()).append("\n");
        sb.append("Переменные класса:").append("\n");
        for (Field declaredField : c.getDeclaredFields()) {
            sb.append("\t").append(declaredField).append("\n");
        }

        sb.append("Конструкторы класса:").append("\n");
        for (Constructor constructor : c.getDeclaredConstructors()) {
            sb.append("\t").append(constructor).append("\n");
        }

        sb.append("Методы класса:").append("\n");
        for (Method method : c.getDeclaredMethods()) {
            sb.append("\t").append(method).append("\n");
        }

        sb.append("Интерфейсы класса:").append("\n");
        for (Class aClass : c.getInterfaces()) {
            sb.append("\t").append(aClass).append("\n");
        }
        System.out.println(sb.toString());
        if (c.getSuperclass() != null){
            System.out.println("\n\n<<<   NEXT SUPER CLASS   >>>\n");
            print(c.getSuperclass());
        }

    }
}
