import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Zestaw testów zakończonych błędem")
@SelectPackages({"Kontroler", "Model"})
@IncludeTags("niepoprawny")
@ExcludeTags("poprawny")
public class SuiteNiepopranyTest {
}
