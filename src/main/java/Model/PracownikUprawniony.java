package Model;

public class PracownikUprawniony extends Pracownik {
	private boolean czyKierownik;

	public PracownikUprawniony(String imie, String nazwisko, int nr, String haslo) {
		super(imie, nazwisko, nr, haslo);
		czyKierownik = false;
	}

	public PracownikUprawniony(String imie, String nazwisko, int nr, String haslo, boolean czyKierownik) {
		super(imie, nazwisko, nr, haslo);
		this.czyKierownik = czyKierownik;
	}

	@Override
	public String getImie() {
		return super.getImie();
	}

	@Override
	public void setImie(String imie) {
		super.setImie(imie);
	}

	@Override
	public String getNazwisko() {
		return super.getNazwisko();
	}

	@Override
	public void setNazwisko(String nazwisko) {
		super.setNazwisko(nazwisko);
	}

	@Override
	public int getNr() {
		return super.getNr();
	}

	@Override
	public void setNr(int nr) {
		super.setNr(nr);
	}

	@Override
	public String getHaslo() {
		return super.getHaslo();
	}

	@Override
	public void setHaslo(String haslo) {
		super.setHaslo(haslo);
	}

	public boolean isCzyKierownik() {
		return czyKierownik;
	}

	public void setCzyKierownik(boolean czyKierownik) {
		this.czyKierownik = czyKierownik;
	}

	@Override
	public String toString() {
		return getImie() + " " + getNazwisko() + " " + getNr() + " " + (czyKierownik?"Kierownik" : "Nie Kierownik");
	}
}