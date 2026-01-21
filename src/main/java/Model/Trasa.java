package Model;

import Komunikacja.Widok;

import java.util.Vector;

public class Trasa {
	protected Vector<Przystanek> przystanki;
	protected int czas;
	protected String nazwa;
	protected int numer;

	public Trasa(int numer, String nazwa, Vector<Przystanek> przystanki) {
		this.numer = numer;
		this.nazwa = nazwa;
		this.przystanki = przystanki;
	}

	public Przystanek[] dajPrzystanki() {
		throw new UnsupportedOperationException();
	}

	public boolean czyTramwajowa() {
		if (przystanki.size() != 0) {
		return przystanki.get(0).isSzynowy();
		}
		throw new NullPointerException("Trasa nie zawiera żadnych przystanków");
	}

	public String opisz() {
		throw new UnsupportedOperationException();
	}
	public void dodajPrzystanek(Przystanek przystanek, int czas) {
		if (przystanki.isEmpty() || przystanek.isSzynowy() == przystanki.get(0).isSzynowy()) {
			przystanki.add(przystanek);
			this.czas += czas;
			return;
		}
		throw new UnsupportedOperationException("Typ przystanku nie pasuje do trasy");
	}
	public Trasa() {
		przystanki = null;
		czas = 0;
		nazwa = null;
		numer = -1;
	}
}