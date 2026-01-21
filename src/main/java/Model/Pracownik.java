package Model;

public class Pracownik implements IPracownik {
	private String imie;
	private String nazwisko;
	private int nr;
	protected String haslo;

	public Pracownik(String imie, String nazwisko, int nr, String haslo) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nr = nr;
		this.haslo = haslo;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String toString(){
		return imie + " " + nazwisko + " " + nr;
	}
}