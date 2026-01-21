package Model;
import Komunikacja.CSV;

public class Kurs extends Trasa {
	private String godzina;
	private boolean aktywny;
	private Trasa trasa;
	private int nr;

	public Kurs(int nr, Trasa trasa, String godzina, boolean aktywny) {
		this.nr=nr;
		this.trasa = trasa;
		this.godzina = godzina;
		this.aktywny = aktywny;
	}

	public String opisz() {
		CSV csv = new CSV();
		return csv.utwórzCsvKursu(this.nr,this.godzina,1,this.aktywny, this.trasa.czyTramwajowa());
	}


}