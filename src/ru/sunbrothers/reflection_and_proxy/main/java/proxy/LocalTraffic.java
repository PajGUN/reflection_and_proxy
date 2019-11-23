package ru.sunbrothers.reflection_and_proxy.main.java.proxy;

public class LocalTraffic implements Traffic {
    private Long id;
    private byte[] data;

    public LocalTraffic(Long id, byte[] data) {
        this.id = id;
        this.data = data;
    }

    @Override
    @CompanyArea(type = TrafficType.OFFICE)
    public void printGraph() {
        System.out.println("рисуем график...");
    }

    @Override
    @CompanyArea(type = TrafficType.REMOTE_OFFICE)
    public int getRate() {
        return 5;
    }

    @Override
    @CompanyArea(type = TrafficType.OFFICE)
    public void setRate(Integer rate) {
        System.out.println("присваиваем рейтинг - " + rate);
    }
}
