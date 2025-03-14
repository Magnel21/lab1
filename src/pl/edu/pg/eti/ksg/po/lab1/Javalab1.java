package pl.edu.pg.eti.ksg.po.lab1;

import pl.edu.pg.eti.ksg.po.lab1.transformacje.Punkt;

public class Javalab1 {
    public static void main(String[] args)
    {
        Punkt p1 = new Punkt(5, 6);
        System.out.println(p1.toString());
        System.out.println(p1.hashCode());
    }
}