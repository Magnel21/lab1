package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class ZlozenieTransformacji implements Transformacja{
    private final Transformacja[] tab;

    public ZlozenieTransformacji(Transformacja[] tab) {
        this.tab = tab;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        for (Transformacja t : tab) {
            p = t.transformuj(p);
        }
        return p;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        Transformacja[] tempTab = new Transformacja[this.tab.length];
        for (int i = tab.length - 1; i >= 0; i--) {
            try {
                tempTab[tab.length - i - 1] = tab[i].getTransformacjaOdwrotna();
            } catch (BrakTransformacjiOdwrotnejException ex) {
                throw new BrakTransformacjiOdwrotnejException("Jedna z transformacji nie ma odwrotnej");
            }
        }

        return new ZlozenieTransformacji( tempTab);
    }

    @Override
    public String toString() {
        return "Zlozenie";
    }
}