package ru.sunbrothers.reflection_and_proxy.main.java.reflection.Utils;

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
        if (c.getSuperclass() != null && !c.getSuperclass().getName().equals("class java.lang.Object")){
            Class superClass = c.getSuperclass();
            sb.append("\n");
            sb.append("Класс унаследован от: ").append(superClass.getSimpleName()).append("\n");

            sb.append("Имя пакета super класса: ").append(superClass.getPackageName()).append("\n");
            sb.append("Переменные super класса:").append("\n");
            for (Field declaredField : superClass.getDeclaredFields()) {
                sb.append("\t").append(declaredField).append("\n");
            }
            sb.append("Конструкторы super класса:").append("\n");
            for (Constructor constructor : superClass.getDeclaredConstructors()) {
                sb.append("\t").append(constructor).append("\n");
            }

            sb.append("Методы super класса:").append("\n");
            for (Method method : superClass.getDeclaredMethods()) {
                sb.append("\t").append(method).append("\n");
            }

            sb.append("Интерфейсы super класса:").append("\n");
            for (Class aClass : superClass.getInterfaces()) {
                sb.append("\t").append(aClass).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
