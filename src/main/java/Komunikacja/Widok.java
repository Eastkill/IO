package Komunikacja;


import java.util.ArrayList;

// Autor dr. Paweł Głuchowski, zaimplementowane jako wzór
public class Widok {

    public static enum Gadatliwosc {
        BRAK,
        MALA,
        DUZA,
        PELNA
    }

    private static Gadatliwosc gadatliwosc = Gadatliwosc.BRAK;

    public static void ustawGadatliwosc(Gadatliwosc poziom) {
        gadatliwosc = poziom;
    }

    private static boolean czyRaport(String klasa, String operacja) {
        if (gadatliwosc == Gadatliwosc.BRAK) return false;


        ArrayList<String> operacje = new ArrayList<String>();
        if (gadatliwosc == Gadatliwosc.MALA) {
            operacje.add("j");
        if (!operacje.contains(klasa + "." + operacja + "()")) return false;
        }
        if (gadatliwosc == Gadatliwosc.DUZA) {
            operacje.add("j");
        if (!operacje.contains(klasa + "." + operacja + "()")) return false;
        }
        if (gadatliwosc == Gadatliwosc.PELNA) {
            return true;
        }
        return true;
    }

    private static String nagłówekRaportu(String klasa, String operacja, boolean sukces) {
        // sukces na niebiesko, porażka na czerwono
        String nagłówek = "\n\033[1;37m" + klasa + "\033[0;37m\n";
        if (sukces)
            nagłówek += "\033[0;34m  ✓" + operacja + "():\033[0;37m";
        else
            nagłówek += "\033[0;31m  ✗" + operacja + "():\033[0;37m";
        return nagłówek;
    }

    public static void pokaż(String klasa, String operacja, Boolean sukces, String treść) {
        if (czyRaport(klasa, operacja)) {
            String raport = nagłówekRaportu(klasa, operacja, sukces);
            raport += "\n--- " + treść;
            System.out.println(raport);
        }
    }

    public static void pokaż(String klasa, String operacja, Boolean sukces, ArrayList<String> treść) {
        if (czyRaport(klasa, operacja)) {
            String raport = nagłówekRaportu(klasa, operacja, sukces);
            for (String linia : treść)
                raport += "\n--- " + linia;
            System.out.println(raport);
        }
    }
}
