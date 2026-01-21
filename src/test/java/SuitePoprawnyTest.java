import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Zestaw testów zakończonych sukcesem")
@SelectPackages({"Kontroler", "Model"})
@IncludeTags("poprawny")
@ExcludeTags("niepoprawny")
public class SuitePoprawnyTest {
}