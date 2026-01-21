package Model;

import Model.Pracownik;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Testy klasy Pracownik")
class TestPracownik {

    private Pracownik pracownik;

    @BeforeAll
    static void setUpBeforeClass() {
        // jeśli – przygotowanie zasobów globalnych
        System.out.println("Start testów klasy Pracownik");
    }

    @AfterAll
    static void tearDownAfterClass() {
        // wtedy – sprzątanie globalne
        System.out.println("Koniec testów klasy Pracownik");
    }

    @BeforeEach
    void setUp() {
        // jeśli – przygotowanie danych
        pracownik = new Pracownik("Jan", "Kowalski", 1, "haslo123");
    }

    @AfterEach
    void tearDown() {
        // wtedy – sprzątanie po teście
        pracownik = null;
    }

    @Test
    @Order(1)
    @DisplayName("Sprawdzenie getImie()")
    void testGetImie() {
        // gdy
        String imie = pracownik.getImie();

        // wtedy
        assertEquals("Jan", imie);
        assertNotNull(imie);
    }

    @Test
    @Order(2)
    @DisplayName("Sprawdzenie setNr()")
    void testSetNr() {
        // gdy
        pracownik.setNr(10);

        // wtedy
        assertEquals(10, pracownik.getNr());
        assertNotEquals(1, pracownik.getNr());
    }

    @Test
    @Order(3)
    @DisplayName("Sprawdzenie toString()")
    void testToString() {
        // gdy
        String wynik = pracownik.toString();

        // wtedy
        assertTrue(wynik.contains("Jan"));
        assertTrue(wynik.contains("Kowalski"));
    }

    // ================= PARAMETRYZACJA =================

    @ParameterizedTest
    @ValueSource(strings = {"Adam", "Ewa", "Piotr"})
    @Order(4)
    @DisplayName("Test setImie() – różne wartości")
    void testSetImieParametry(String imie) {
        // gdy
        pracownik.setImie(imie);

        // wtedy
        assertEquals(imie, pracownik.getImie());
    }

    @ParameterizedTest
    @CsvSource({
            "Nowak, 5",
            "Wiśniewski, 10",
            "Mazur, 20"
    })
    @Order(5)
    @DisplayName("Test wielu parametrów")
    void testWieleParametrow(String nazwisko, int nr) {
        // gdy
        pracownik.setNazwisko(nazwisko);
        pracownik.setNr(nr);

        // wtedy
        assertEquals(nazwisko, pracownik.getNazwisko());
        assertEquals(nr, pracownik.getNr());
    }
}