package Model;

public class PojazdKursujacy implements IPojazd {
	private Kurs kurs;
	private Kierowca kierowca;
	private IPojazd pojazd;

	public PojazdKursujacy(IPojazd pojazd, Kierowca kierowca, Trasa trasa) {
		throw new UnsupportedOperationException();
	}

	public int dajNr() {
		throw new UnsupportedOperationException();
	}

	public boolean czyTramwaj() {
		throw new UnsupportedOperationException();
	}

	public String dajDatePrzegladu() {
		throw new UnsupportedOperationException();
	}

	public String opisz() {
		throw new UnsupportedOperationException();
	}
}