package Kontroler;

import Model.IModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Tag;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("controller")
@Tag("mock")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Testy mockowane klasy ObslugaKursu")
public class ObslugaKursuTest {

    @Mock
    private IModel model;

    private ObslugaKursu obsluga;

    private AutoCloseable mocks;

    @BeforeAll
    static void setUpBeforeClass() {
        // jeśli – start testów
        System.out.println("Start testów mockowanych ObslugaKursu");
    }

    @AfterAll
    static void tearDownAfterClass() {
        // wtedy – koniec testów
        System.out.println("Koniec testów mockowanych ObslugaKursu");
    }

    @BeforeEach
    void setUp() {
        // jeśli – przygotowanie mocków
        mocks = MockitoAnnotations.openMocks(this);

        when(model.dajPrzystanki(1))
                .thenReturn(new String[]{"A", "B", "C"});

        obsluga = new ObslugaKursu(1, model);
    }

    @AfterEach
    void tearDown() throws Exception {
        // wtedy – sprzątanie
        mocks.close();
        obsluga = null;
    }

    @Test
    @Tag("poprawny")
    @Order(1)
    @DisplayName("Poprawne ustawienie numeru kursu")
    void testGetNumerKursu() {
        // gdy
        int numer = obsluga.getNumerKursu();

        // wtedy
        assertEquals(1, numer);
        assertNotEquals(2, numer);
    }

    @Test
    @Order(2)
    @DisplayName("Pobranie trasy z modelu w konstruktorze")
    void testPobranieTrasyZModelu() {
        // wtedy
        verify(model, times(1)).dajPrzystanki(1);
    }

    @Test
    @Tag("poprawny")
    @Order(3)
    @DisplayName("Osiągnięcie przystanku – bez zakończenia kursu")
    void testOsiagnijPrzystanek() {
        // gdy
        obsluga.osiagnijPrzystanek();
        obsluga.osiagnijPrzystanek();

        // wtedy
        // brak wyjątku = poprawne działanie
        assertTrue(true);
    }

    @Test
    @Tag("poprawny")
    @Order(4)
    @DisplayName("Zgłoszenie incydentu niekończącego kursu")
    void testZglosIncydentNieKonczy() {
        // gdy
        assertDoesNotThrow(() ->
                obsluga.zglosIndydent("Opóźnienie", false)
        );

        // wtedy
        assertNotNull(obsluga);
    }


    @Test
    @Tag("poprawny")
    @Order(5)
    @DisplayName("Zgłoszenie incydentu kończącego kurs")
    void testZglosIncydentKonczy() {
        // gdy
        obsluga.zglosIndydent("Awaria", true);

        // wtedy
        assertNotNull(obsluga);
    }
}
