package Model;

public class FabrykaPojazdowKursujacych implements IFabrykaPojazdow {
	private IPojazd pojazd;
	private Kurs kurs;
	private Kierowca kierowca;

	public FabrykaPojazdowKursujacych(IPojazd pojazd, Kierowca kierowca, Trasa trasa) {
		throw new UnsupportedOperationException();
	}

	public IPojazd utworzPojazd(String opis) {
		throw new UnsupportedOperationException();
	}
}