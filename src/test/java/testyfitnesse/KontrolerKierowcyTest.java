package testyfitnesse;

import Kontroler.KontrolerKierowcy;
import fit.ColumnFixture;

/**
 * Klasa testująca przypadki użycia KontrolerKierowcy
 * Rozszerza ColumnFixture zgodnie z wymaganiami FitNesse
 */
public class KontrolerKierowcyTest extends ColumnFixture {
    // Dane wejściowe - pobierane przez FitNesse ze strony testu
    public int numerKursu;
    public String tekstIncydentu;
    public boolean czyKonczy;

    private Exception lastException = null;

    /**
     * Operacja testująca przyjęcie kursu
     * 
     * @return true jeśli operacja została wywołana (może rzucić
     *         UnsupportedOperationException)
     */
    public boolean przyjmijKurs() {
        try {
            SetUp.kontrolerKierowcy.przyjmijKurs(numerKursu);
            return true;
        } catch (Exception e) {
            lastException = e;
            return false;
        }
    }
    public int dlugoscKursu(){
        return SetUp.kontrolerKierowcy.dlugoscKursu();
    }

    /**
     * Operacja testująca osiągnięcie przystanku
     * 
     * @return true jeśli operacja została wywołana
     */
    public boolean osiagnijPrzystanek() {
            return SetUp.kontrolerKierowcy.osiagnijPrzystanek();
    }

    /**
     * Operacja testująca zgłoszenie incydentu
     * 
     * @return true jeśli operacja została wywołana
     */
    public boolean zglosIncydentKonczy() {

            SetUp.kontrolerKierowcy.zglosIncydent(tekstIncydentu, czyKonczy);
            return czyKonczy;
    }

}
