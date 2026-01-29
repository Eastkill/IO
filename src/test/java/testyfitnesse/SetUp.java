package testyfitnesse;

import Model.*;
import Kontroler.*;
import fit.Fixture;

/**
 * Klasa SetUp dla testów FitNesse
 * Przygotowuje środowisko testowe - tworzy i łączy wszystkie komponenty systemu
 */
public class SetUp extends Fixture {
    // Statyczne instancje komponentów systemu dostępne dla wszystkich testów
    public static IDAO dao;
    public static Inwentarz inwentarz;
    public static IModel model;
    public static KontrolerZarzadcy kontrolerZarzadcy;
    public static KontrolerKierowcy kontrolerKierowcy;

    /**
     * Konstruktor SetUp - inicjalizuje wszystkie komponenty systemu
     */
    public SetUp() {
        try {
            // Tworzenie DAO
            dao = new DAO();

            // Tworzenie Inwentarza z DAO
            inwentarz = new Inwentarz(dao);

            // Tworzenie Modelu z Inwentarzem i DAO
            model = new Model(inwentarz, dao);

            // Tworzenie kontrolerów
            kontrolerZarzadcy = new KontrolerZarzadcy(model);
            kontrolerKierowcy = new KontrolerKierowcy(model);

            System.out.println("SetUp: Wszystkie komponenty zainicjalizowane pomyślnie");
        } catch (Exception e) {
            System.err.println("Błąd podczas inicjalizacji SetUp: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
