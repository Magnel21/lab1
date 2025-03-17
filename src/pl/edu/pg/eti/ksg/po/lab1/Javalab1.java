package pl.edu.pg.eti.ksg.po.lab1;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.*;

public class Javalab1 {
    public static void main(String[] args)
    {
        /*
         * Konstrukcja językowa try {} catch (...){} służy do
         * obsługi wyjątków. Kod w bloku try jest monitorowany
         * pod kątem wystąpienia wyjątku bądź wyjątków
         * wspomnianych na początku bloku/bloków catch.
         * Jeżeli gdzieś w bloku try wystąpi wyjątek, to sterowanie
         * zostanie natychmiast przeniesione do bloku catch.
         * Tam powinien znajdować się kod obsługujący wyjątek.
         * Może to być np. wypisanie stosu wywołań na wyjście błędów
         * lub zapisanie wyjątku w logach, lub wyrzucenie (zgłoszenie)
         * innego wyjątku lepiej opisującego sytuacje (można załączyć
         * wyjątek który zainicjował to zdarzenie patrz. Konstruktor
         * klasy java.lang.Exception)
         */
        try {
            Punkt p1 = new Punkt(1, 0);
            System.out.println("Punkt początkowy: " + p1);

            Transformacja obrot = new Obrot(2);


            Punkt p2 = obrot.transformuj(p1);
            System.out.println("Punkt po transformacji: " + p2);

            p2 =  obrot.getTransformacjaOdwrotna().transformuj(p2);
            System.out.println("Czy punkt końcowy jest równy początkowemu: " + p1.equals(p2));
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }

        try {
            Punkt p1 = new Punkt(1, 0);
            System.out.println("Punkt początkowy: " + p1);

            Transformacja obrot = new Obrot(90);
            Transformacja obrot2 = new Obrot(2);
            Transformacja skala = new Skalowanie(3, 2);

            Transformacja[] transformacje = {obrot, obrot2, skala};
            ZlozenieTransformacji zlozenie = new ZlozenieTransformacji(transformacje);

            System.out.println("Złożona transformacja: " + zlozenie);
            Punkt p2 = zlozenie.transformuj(p1);
            System.out.println("Punkt po złożonych transformacjach: " + p2);

            Transformacja odwrotna = zlozenie.getTransformacjaOdwrotna();
            System.out.println("Odwrotna transformacja: " + odwrotna);

            Punkt p3 = odwrotna.transformuj(p2);
            System.out.println("Punkt po odwrotnej transformacji: " + p3);

            System.out.println("Czy punkt końcowy jest równy początkowemu: " + p1.equals(p3));
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }

    }
}