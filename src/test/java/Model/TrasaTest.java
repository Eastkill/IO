package Model;

import Model.Trasa;
import Model.Przystanek;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.*;


import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Testy mockowane klasy Trasa")
class TestTrasaMock {

    @Mock
    private Przystanek przystanekSzynowy;

    @Mock
    private Przystanek przystanekNieszynowy;

    private Vector<Przystanek> przystanki;

    private Trasa trasa;




    @BeforeAll
    static void setUpBeforeClass() {
        // jeśli – przygotowanie środowiska testowego
        System.out.println("Start testów mockowanych Trasa");
    }

    @AfterAll
    static void tearDownAfterClass() {
        // wtedy – sprzątanie środowiska
        System.out.println("Koniec testów mockowanych Trasa");
    }

    @BeforeEach
    void setUp() {

        // jeśli – przygotowanie mocków i danych
        przystanki = new Vector<>();

        trasa = new Trasa(1, "Trasa testowa", przystanki);

        MockitoAnnotations.openMocks(this);
        when(przystanekSzynowy.isSzynowy()).thenReturn(true);
        when(przystanekNieszynowy.isSzynowy()).thenReturn(false);
    }

    @AfterEach
    void tearDown() {
        // wtedy – sprzątanie po teście
        przystanki.clear();
    }

    // ===================== TESTY =====================

    @Test
    @Order(1)
    @DisplayName("czyTramwajowa() – trasa tramwajowa")
    void testCzyTramwajowaTrue() {
        // jeśli
        przystanki.add(przystanekSzynowy);

        // gdy
        boolean wynik = trasa.czyTramwajowa();

        // wtedy
        assertTrue(wynik);
        verify(przystanekSzynowy, times(1)).isSzynowy();
    }

    @Test
    @Order(2)
    @DisplayName("czyTramwajowa() – brak przystanków → wyjątek")
    void testCzyTramwajowaException() {
        // gdy / wtedy
        assertThrows(NullPointerException.class, () -> trasa.czyTramwajowa());
    }

    @Test
    @Order(3)
    @DisplayName("dodajPrzystanek() – poprawny typ")
    void testDodajPrzystanekPoprawny() {
        // jeśli
        przystanki.add(przystanekSzynowy);

        // gdy
        trasa.dodajPrzystanek(przystanekSzynowy, 5);

        // wtedy
        assertEquals(2, przystanki.size());
        verify(przystanekSzynowy, atLeastOnce()).isSzynowy();
    }

    @Test
    @Order(4)
    @DisplayName("dodajPrzystanek() – niepoprawny typ → wyjątek")
    void testDodajPrzystanekZlyTyp() {
        // jeśli
        przystanki.add(przystanekSzynowy);

        // gdy / wtedy
        assertThrows(UnsupportedOperationException.class,
                () -> trasa.dodajPrzystanek(przystanekNieszynowy, 3));

        verify(przystanekNieszynowy, times(1)).isSzynowy();
    }

    // ================= PARAMETRYZACJA =================

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @Order(5)
    @DisplayName("dodajPrzystanek() – parametryzacja typu przystanku")
    void testParametryzowany(boolean czySzynowy) {
        // jeśli
        Przystanek mock = mock(Przystanek.class);
        when(mock.isSzynowy()).thenReturn(czySzynowy);

        przystanki.add(mock);

        // gdy
        trasa.dodajPrzystanek(mock, 2);

        // wtedy
        assertEquals(2, przystanki.size());
        verify(mock, atLeastOnce()).isSzynowy();
    }
}