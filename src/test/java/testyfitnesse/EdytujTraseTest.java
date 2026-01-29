package testyfitnesse;

import fit.ColumnFixture;

/**
 * Klasa testująca przypadek użycia: Edycja Trasy
 * Rozszerza ColumnFixture zgodnie z wymaganiami FitNesse
 */
public class EdytujTraseTest extends ColumnFixture {
    // Dane wejściowe - pobierane przez FitNesse ze strony testu
    public String tekstTrasy;
    public int numerTrasy;

    /**
     * Operacja testująca realizację przypadku użycia edycji trasy
     * 
     * @return true jeśli operacja się powiodła, false w przeciwnym razie
     */
    public boolean edytujTrase() {
        try {
            SetUp.kontrolerZarzadcy.edytujTrase(tekstTrasy, numerTrasy);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Sprawdza liczbę tras w systemie (stan warstwy encji)
     * 
     * @return liczba tras w inwentarzu
     */
    public int liczbaTras() {
        return SetUp.inwentarz.getLiczbaTras();
    }

    /**
     * Sprawdza czy edycja trasy została wykonana
     * 
     * @return true jeśli operacja nie rzuciła wyjątku
     */
    public boolean czyOperacjaUdana() {
        try {
            SetUp.kontrolerZarzadcy.edytujTrase(tekstTrasy, numerTrasy);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
