package Model;

public class PojazdNaprawa implements IPojazd {
	private String dataKoncaNaprawy;
	private IPojazd pojazd;

	public PojazdNaprawa(IPojazd pojazd, String dataKoncaNaprawy) {
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