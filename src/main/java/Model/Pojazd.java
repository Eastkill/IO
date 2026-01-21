package Model;
import Komunikacja.CSV;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pojazd implements IPojazd {
	private int nr;
	private String data_przegladu;
	private boolean szynowy;

	public Pojazd(int nr, boolean szynowy) {
		this.nr=nr;
		this.szynowy=szynowy;
		data_przegladu=LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public int dajNr() {
		return this.nr;
	}

	public boolean czyTramwaj() {
		return this.szynowy;
	}

	public String dajDatePrzegladu() {
		return this.data_przegladu;
	}

	public String opisz() {
		CSV csv = new CSV();
		return csv.utwórzCsvPojazdu(this.nr,this.szynowy,this.data_przegladu);
	}
}