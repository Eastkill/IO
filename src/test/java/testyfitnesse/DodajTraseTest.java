package testyfitnesse;

import fit.ColumnFixture;

/**
 * Klasa testująca przypadek użycia: Dodanie Trasy
 * Rozszerza ColumnFixture zgodnie z wymaganiami FitNesse
 */
public class DodajTraseTest extends ColumnFixture {
    // Dane wejściowe - pobierane przez FitNesse ze strony testu
    public String tekstTrasy;

    /**
     * Operacja testująca realizację przypadku użycia dodania trasy
     * 
     * @return true jeśli operacja się powiodła, false w przeciwnym razie
     */
    public boolean dodajTrase() {
        try {
            int liczbaTrasPoprzednio = SetUp.inwentarz.getLiczbaTras();
            SetUp.kontrolerZarzadcy.dodajTrase(tekstTrasy);
            return SetUp.inwentarz.getLiczbaTras() == liczbaTrasPoprzednio + 1;
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
     * Sprawdza czy trasa została dodana poprawnie
     * 
     * @return true jeśli ostatnia trasa nie jest null
     */
    public boolean czyTrasaDodana() {
        return SetUp.inwentarz.getOstatniaTrasa() != null;
    }
}
