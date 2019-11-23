package ru.sunbrothers.reflection_and_proxy.main.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static ru.sunbrothers.reflection_and_proxy.main.java.proxy.ProxyMain.logger;

public class TrafficHandler implements InvocationHandler {
    private Object target;

    public TrafficHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?>[] arguments = null;
        if (args != null) {
            arguments = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                arguments[i] = args[i].getClass();
            }
        }
        Method targetMethod = target.getClass().getMethod(method.getName(), arguments);
        CompanyArea companyArea = targetMethod.getAnnotation(CompanyArea.class);
        if (companyArea != null){
            try {
                if (companyArea.type() == AreaContext.getArea()){
                    logger.info("Вызываем метод: " + method.getName());
                    if (arguments != null){
                        logger.info("Аргументы метода: ");
                        for (int i = 0; i < arguments.length; i++) {
                            logger.info("type: " + arguments[i].getSimpleName() +
                                    ", value: " + args[i]);
                        }
                    }
                    return method.invoke(target,args);
                } else {
                    throw new SecuredException();
                }
            } catch (SecuredException e) {
                logger.warning("Вызов метода из запрещённой зоны! Вызываем СБ)");
            }
        }
        return method.invoke(target,args);
    }
}
