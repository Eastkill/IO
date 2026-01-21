import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@Suite
@SelectClasses({
        SuiteKontrolerTest.class,
        SuiteModelTest.class
})
@SuiteDisplayName("Wszystkie dostępne testy")
public class SuitAllTest {
}