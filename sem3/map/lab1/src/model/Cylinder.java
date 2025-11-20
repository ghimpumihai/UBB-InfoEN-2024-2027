package model;

public class Cilindru implements Obiect {
    private final int r,h;
    public Cilindru(int r, int h) {
        this.r = r;
        this.h = h;
    }
    @Override
    public double getVolume() {
        return 3.14*r*r*h;
    }
}
