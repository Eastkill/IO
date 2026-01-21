package Model;

import Komunikacja.CSV;

public class Incydent {
	private int nr;
	private String godzina;
	private String miejsce;
	private Kierowca kierowca;

	public Incydent(int nr, String godzina, String miejsce, Kierowca kierowca) {
		this.nr=nr;
		this.godzina=godzina;
		this.miejsce=miejsce;
		this.kierowca=kierowca;
	}

	public String opisz() {
		CSV csv = new CSV();
		return csv.utwórzCsvIncydentu(this.nr,this.godzina,this.miejsce,this.kierowca.dajNr());
	}
}