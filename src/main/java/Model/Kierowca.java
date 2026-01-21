package Model;

public class Kierowca extends Pracownik {
	private boolean szynowy;


	public Kierowca(String imie, String nazwisko, int nr, String haslo, boolean szynowy) {
		super(imie, nazwisko, nr, haslo);
		this.szynowy = szynowy;
	}


	public String opisz() {
		throw new UnsupportedOperationException();
	}

	public String dajImie() {
		throw new UnsupportedOperationException();
	}

	public String dajNazwisko() {
		throw new UnsupportedOperationException();
	}

	public int dajNr() {
		throw new UnsupportedOperationException();
	}

	public void dajHaslo() {
		throw new UnsupportedOperationException();
	}
}