package pl.edu.pg.eti.ksg.po.lab1.transformacje;
import java.lang.Math;
public class Obrot implements Transformacja{
    private final double alfa;
    public Obrot(double a) {
        this.alfa = a;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(-alfa);
    }

    @Override
    public Punkt transformuj(Punkt p) {
        return new Punkt(p.getX() * Math.cos(this.alfa) - p.getY() * Math.sin(this.alfa), p.getX() * Math.sin(this.alfa) + p.getY() * Math.cos(this.alfa));
    }
    public double getAlfa() {
        return alfa;
    }
    @Override
    public String toString() {
        return "Obrot {" + "alfa=" + alfa + '}';
    }

}
