package ru.sunbrothers.reflection_and_proxy.main.java.proxy;

import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class ProxyMain {
    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        LocalTraffic localTraffic = new LocalTraffic(47L, new byte[]{1,0,0,1});
        Object proxy = Proxy.newProxyInstance(
                ProxyMain.class.getClassLoader(),
                new Class[]{Traffic.class},
                new TrafficHandler(localTraffic));
        ((Traffic)proxy).setRate(5);
        ((Traffic)proxy).getRate();
        ((Traffic)proxy).printGraph();
    }
}
