package Model;

public class Rozklad {
	private String nazwa;
	private int nr;
	private boolean weekendowy;
	private java.util.Vector<Kurs[]> kursy = null;

	public Rozklad(String nazwa, int nr, boolean weekendowy) {
		this.nazwa=nazwa;
		this.nr=nr;
		this.weekendowy=weekendowy;
	}

	public String dajNazwa() {
		return nazwa;
	}

	public int dajNr() {
		return nr;
	}

	public boolean czyWeekendowy() {
		return weekendowy;
	}

	public Kurs[] dajKursy() {
		throw new UnsupportedOperationException();
	}

	public Kurs dajKurs(int nrKursu) {
		throw new UnsupportedOperationException();
	}
}