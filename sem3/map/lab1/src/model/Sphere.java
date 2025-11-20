package model;

public class Sfera implements Obiect {
    private final int radius;
    public double getVolume(){return 4*3.14*radius*radius*radius/3;}
    public Sfera(int radius){
        this.radius = radius;
    }
}
