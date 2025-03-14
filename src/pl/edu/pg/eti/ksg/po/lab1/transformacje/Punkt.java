package pl.edu.pg.eti.ksg.po.lab1.transformacje;
public class Punkt {
    private final double x,y;
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    @Override
    public boolean equals(Object obj) {
        if  (obj instanceof Punkt) {
            return ((Punkt) obj).getX() ==  this.getX() && ((Punkt) obj).getY() == this.getY();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return ((int)this.x  * 100 + (int)this.y);
    }
    @Override
    public String toString() {
        return "Punkt(" + this.x + ", " + this.y + ")";
    }

    /**
     * Początek układu współrzędnych.
     * W tym miejscu słowo kluczowe final oznacza, że statyczne
     * pole klasy Punkt nie może zostać zmienione.
     * Dotyczy to jednak samej referencji, a nie obiektu, na który
     * wskazuje.
     */
    public static final Punkt O = new Punkt(0, 0);
    /**
     * Punkt (1,0) w układzie współrzędnych
     */
    public static final Punkt E_X = new Punkt(1, 0);

    /**
     * Punkt (0,1) w układzie współrzędnych
     */
    public static final Punkt E_Y = new Punkt(0, 1);
}
