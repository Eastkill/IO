package Model;
import Komunikacja.CSV;

public class Przystanek {
	private String nazwa;
	private String adres;
	private int nr;
	private boolean szynowy;

	public Przystanek(String nazwa, String adres, int nr, boolean szynowy) {
		this.nazwa=nazwa;
		this.adres=adres;
		this.nr=nr;
		this.szynowy=szynowy;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public boolean isSzynowy() {
		return szynowy;
	}

	public void setSzynowy(boolean szynowy) {
		this.szynowy = szynowy;
	}

	public String opisz() {
		CSV csv = new CSV();
		return csv.utwórzCsvPrzystanku(this.nr,this.nazwa,this.adres,this.szynowy);
	}
}