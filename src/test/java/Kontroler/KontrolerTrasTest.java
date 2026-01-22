package Kontroler;

import Model.IModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Testy klasy KontrolerTras")
@Tag("controller")
public class KontrolerTrasTest {

    @Mock
    private IModel modelMock;

    @InjectMocks
    private KontrolerTras kontrolerTras;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Start testów KontrolerTras");
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("Koniec testów KontrolerTras");
    }

    // ===================== DODAJ TRASĘ =====================

    @Test
    @Order(1)
    @Tag("poprawny")
    @DisplayName("Poprawnie dodaje trasę")
    void testPoprawnegoDodajTrase() {
        // jeśli
        int id = 1;
        String trasa = "1;Testowa;10;20;30";

        // gdy
        assertDoesNotThrow(() ->
                kontrolerTras.dodajTrase(id, trasa)
        );

        // wtedy
        verify(modelMock, times(1)).dodanieTrasy(trasa);
    }

    // ===================== EDYTUJ TRASĘ =====================

    @Test
    @Order(2)
    @Tag("poprawny")
    @DisplayName("Poprawnie edytuje istniejącą trasę")
    void testEdytujTrasePoprawnie() {
        // jeśli
        int id = 1;
        String trasa = "1;Edytowana;10;20;30";

        when(modelMock.dajTrase(id)).thenReturn("ISTNIEJE");

        // gdy
        assertDoesNotThrow(() ->
                kontrolerTras.edytujTrase(id, trasa)
        );

        // wtedy
        InOrder inOrder = inOrder(modelMock);
        inOrder.verify(modelMock).dajTrase(id);
        inOrder.verify(modelMock).modyfikacjaTrasy(id, trasa);
    }

    @Test
    @Order(3)
    @Tag("niepoprawny")
    @DisplayName("Rzuca wyjątek przy edycji nieistniejącej trasy")
    void testEdytujTraseNieIstnieje() {
        // jeśli
        int id = 99;
        String trasa = "Nowa";

        when(modelMock.dajTrase(id)).thenReturn(null);

        // gdy / wtedy
        assertThrows(NullPointerException.class, () ->
                kontrolerTras.edytujTrase(id, trasa)
        );

        verify(modelMock, never()).modyfikacjaTrasy(anyInt(), anyString());
    }

    // ===================== USUŃ TRASĘ =====================

    @Test
    @Order(4)
    @Tag("poprawny")
    @DisplayName("Poprawnie usuwa wiele tras")
    void testUsunTrasePoprawnie() {
        // jeśli
        int[] trasy = {1, 2, 3};

        when(modelMock.dajTrase(anyInt())).thenReturn("ISTNIEJE");

        // gdy
        assertDoesNotThrow(() ->
                kontrolerTras.usunTrase(trasy)
        );

        // wtedy
        verify(modelMock, times(3)).usuwanieTrasy(anyInt());
    }

    @Test
    @Order(5)
    @Tag("niepoprawny")
    @DisplayName("Rzuca wyjątek gdy jedna z tras nie istnieje")
    void testUsunTraseNieIstnieje() {
        // jeśli
        int[] trasy = {1, 2, 3};

        when(modelMock.dajTrase(1)).thenReturn("OK");
        when(modelMock.dajTrase(2)).thenReturn(null);

        // gdy / wtedy
        assertThrows(NullPointerException.class, () ->
                kontrolerTras.usunTrase(trasy)
        );

        verify(modelMock, never()).usuwanieTrasy(3);
    }
}
