package Kontroler;

import Model.IModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Testy klasy KontrolerTras")
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
//    @BeforeEach
//    void setUp() {
//        System.out.println(" -> Przygotowanie pojedynczego testu");
//    }
//    @AfterEach
//    void tearDown() {
//        System.out.println(" -> Czyszczenie po teście");
//    }

    @Test
    @Tag("poprawny")
    @Order(1)
    @DisplayName("Poprawnie dodaje trasę")
    void testPoprawnegoDodajTrase() {
        //  Jeśli
        int id = 1;
        String trasa = "1;Testowa;10;20;30";

        //  Gdy
        kontrolerTras.dodajTrase(id, trasa);

        //  Wtedy
        InOrder inOrder = Mockito.inOrder(modelMock);
        inOrder.verify(modelMock).dodanieTrasy(trasa);
        verify(modelMock, times(1)).dodanieTrasy(trasa);
    }

    @Test
    @Tag("niepoprawny")
    @Order(2)
    @DisplayName("Rzuca błąd przy dodawaniu trasy")
    void niePowinienDodacTrasyGdyModelZglosiBlad() {
        //  Jeśli
        int id = 1;
        String blednaTrasa = "To nie jest poprawny format";

        //  Gdy
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            kontrolerTras.dodajTrase(id, blednaTrasa);
        });

        //  Wtedy
//        InOrder inOrder = Mockito.inOrder(modelMock);
//        inOrder.verify(modelMock).dodanieTrasy(blednaTrasa);
        verifyNoInteractions(modelMock);
    }
    @Test
    @Order(3)
    @DisplayName("weryfikacja edycji trasy - brak interakcji")
    void testEdytujTrase() {
        //  Gdy
        kontrolerTras.edytujTrase(5, "Edycja");

        //  Wtedy
        verifyNoInteractions(modelMock);
    }
}
