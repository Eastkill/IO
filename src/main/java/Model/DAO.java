package Model;

import Komunikacja.CSV;
import Komunikacja.Widok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DAO implements IDAO {
	private Map<Integer,String> bazaRozklad = new HashMap<>();
	private Map<Integer,String> bazaPojazd = new HashMap<>();
	private Map<Integer,String> bazaKurs = new HashMap<>();
	private Map<Integer,String> bazaTrasa= new HashMap<>();
	private Map<Integer,String> bazaPrzystanek = new HashMap<>();
	private int ostatniNumerRozkladu;
	private int ostatniNumerPojazdu;
	private int ostatniNumerKursu;
	private int ostatniNumerTrasy;
	private int ostatniNumerPrzystanku;
	public void pokazTrasy()
	{
		CSV csv = new CSV();
		ArrayList<String> trasy = new ArrayList<>();
		for(String trasa : this.bazaTrasa.values()){
			trasy.add(csv.opiszTrasę(trasa));
		}
		Widok.pokaż(this.getClass().getCanonicalName(), "Pokaż bazę tras",true,trasy);
	}
	public DAO() {
		bazaRozklad.put(1,"Nocnik;1;False;[1,2,3,4,5,6]");
		bazaPojazd.put(1, "1;False");
		bazaKurs.put(1,"1;1200;True");
		bazaTrasa.put(1,"1;dy;1;2;3");
		bazaPrzystanek.put(1,"1;Wasza;Włodkowicza;False");
		bazaPrzystanek.put(2,"2;Nasza;Uliczna;False");
		bazaPrzystanek.put(3,"3;Asia;Techniczna;False");
		bazaPrzystanek.put(4,"4;Kasia;Poznańska;False");
		ostatniNumerRozkladu =1;
		ostatniNumerKursu=1;
		ostatniNumerPojazdu=1;
		ostatniNumerPrzystanku=4;
		ostatniNumerTrasy=1;
		Widok.pokaż(getClass().getCanonicalName(),"DAO",true,"Zainicjalizowano DAO");
	}

	public void dodajWpisDoRejestru(String zdarzenie) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajWpisDoRejestru", true, "Do bazy danych dodano zdarzenie: " + zdarzenie);
	}

	public int dodajPracownika(String pracownik) {
		throw new UnsupportedOperationException();
	}

	public void edytujPracownika(String pracownik) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajPracownika",true, "DAO zmodyfikuje pracownika w bazie danych");
	}

	public void usunPracownika(int nrPracownika) {
		throw new UnsupportedOperationException();
	}

	public String znajdzPracownika(int nrPracownika) {
		throw new UnsupportedOperationException();
	}

	public int dodajPojazd(String pojazd) {
		throw new UnsupportedOperationException();
	}

	public void edytujPojazd(String pojazd) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajPojazd",true, "DAO zmodyfikuje pojazd w bazie danych");
	}

	public void usunPojazd(int nrPojazdu) {
		throw new UnsupportedOperationException();
	}

	public String znajdzPojazd(int nrPojazdu) {
		throw new UnsupportedOperationException();
	}

	public int dodajPrzystanek(String przystanek) {
		throw new UnsupportedOperationException();
	}

	public void edytujPrzystanek(String przystanek) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajPrzystanek",true, "DAO zmodyfikuje przystanek w bazie danych");
	}

	public void usunPrzystanek(int nrPrzystanku) {
		throw new UnsupportedOperationException();
	}

	public String znajdzPrzystanek(int nrPrzystanku) {
		throw new UnsupportedOperationException();
	}

	public int dodajTrase(String trasa) {
		CSV csv = new CSV();
		if (!csv.czyPoprawnyFormatTrasy(trasa)) {
			throw new IllegalArgumentException("Błąd DAO: Niepoprawny format danych trasy CSV.");
		}
		int numer = csv.znajdźNrTrasy(trasa);
		if (bazaTrasa.containsKey(numer)) {
			throw new IllegalArgumentException("Błąd DAO: Trasa o ID " + numer + " już istnieje w bazie.");
		}
		String nazwa = csv.znajdźNazwęTrasy(trasa);
		ArrayList<Integer> przystankki = csv.znajdźPrzystankiTrasy(trasa);
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajTrase",true, "DAO zapisze trasę w bazie danych");
		ostatniNumerTrasy++;
		String opis = csv.utwórzCsvTrasy(numer,nazwa,przystankki);
		bazaTrasa.put(ostatniNumerTrasy,opis);
		return 0;
	}

	public void edytujTrase(int id, String trasa) {
		CSV csv = new CSV();
		if (!csv.czyPoprawnyFormatTrasy(trasa)) {
			throw new IllegalArgumentException("Błąd DAO: Niepoprawny format danych trasy CSV.");
		}
		if (!bazaTrasa.containsKey(id)) {
			throw new IllegalArgumentException("Błąd DAO: Nie można edytować - Trasa o ID " + id + " nie istnieje.");
		}
		Widok.pokaż(this.getClass().getCanonicalName(), "edytujTrase", true, "DAO aktualizuje trasę nr " + id);
		bazaTrasa.put(id, trasa);
	}

	public void usunTrase(int nrTrasy) {
		throw new UnsupportedOperationException();
	}

	public String znajdzTrase(int nrTrasy) {
		throw new UnsupportedOperationException();
	}

	public int dodajRozklad(String rozklad) {
		throw new UnsupportedOperationException();
	}

	public void edytujRozklad(String rozklad) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajRozklad",true, "DAO zmodyfikuje rozklad w bazie danych");
	}

	public void usunRozklad(int nrRozkladu) {
		throw new UnsupportedOperationException();
	}

	public String znajdzRozklad(int nrRozkladu) {
		throw new UnsupportedOperationException();
	}

	public int dodajKurs(String kurs) {
		throw new UnsupportedOperationException();
	}

	public void edytujKurs(String kurs) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajKurs",true, "DAO zmodyfikuje kurs w bazie danych");
	}

	public String znajdzKurs(int nrKursu) {
		throw new UnsupportedOperationException();
	}

	public void usunKurs(Object nrKursu) {
		throw new UnsupportedOperationException();
	}

	public int dodajIncydent(String incydent) {
		return 0;
	}

	public String znajdzIncydent(int nrIncydentu) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<String> dajPrzystanki(){
        return new ArrayList<String>(bazaPrzystanek.values());
	}
	public ArrayList<String> dajTrasy(){
		return new ArrayList<String>(bazaTrasa.values());
	}

	@Override
	public String dajTrase(int id) {
		try {
			return bazaTrasa.get(id);
		} catch (Exception e) {
			return null;
		}
	}
}