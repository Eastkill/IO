package Model;

import Komunikacja.CSV;
import Komunikacja.Widok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Inwentarz {
	private IDAO dao;
	private Map<Integer, Rozklad> rozklady = new HashMap<>();
	private Map<Integer, Pojazd> pojazdy = new HashMap<>();
	private Map<Integer, Kurs> kursy = new HashMap<>();
	private Map<Integer, Trasa> trasy = new HashMap<>();
	private Map<Integer, Przystanek> przystanki = new HashMap<>();
	private Map<Integer, Incydent> incydenty = new HashMap<>();
	private Map<Integer, IPracownik> pracownicy = new HashMap<>();

	public Inwentarz(IDAO dao) {
		this.dao = dao;
		CSV csv = new CSV();
		for (String przystanek : dao.dajPrzystanki()) {
			przystanki.put(csv.znajdźNumerPrzystanku(przystanek),
					new Przystanek(csv.znajdźNazwęPrzystanku(przystanek), csv.znajdźLokalizację(przystanek),
							csv.znajdźNumerPrzystanku(przystanek), csv.znajdźSzynowy(przystanek)));
		}
		for (String trasa : dao.dajTrasy()){
			Vector<Przystanek> przystankit = new Vector<Przystanek>();
			przystankit.addAll(przystanki.values());
			trasy.put(csv.znajdźNrTrasy(trasa),new Trasa(csv.znajdźNrTrasy(trasa),csv.znajdźNazwęTrasy(trasa),przystankit));
		}
		System.out.println(przystanki);
		Widok.pokaż(getClass().getCanonicalName(), "Inwentarz", true, "Zainicjalizowano Inwentarz");
	}

	public IPojazd dajPojazd(int nrPojazdu) {
		throw new UnsupportedOperationException();
	}

	public Przystanek dajPrzystanek(int nrPrzystanku) {
		throw new UnsupportedOperationException();
	}

	public Trasa dajTrase(int nrTrasy) {
		throw new UnsupportedOperationException();
	}

	public Rozklad dajRozklad(int nrRozkladu) {
		throw new UnsupportedOperationException();
	}

	public Pracownik dajPracownika(int nrPracownika) {
		throw new UnsupportedOperationException();
	}

	public void usunRozklad(int nrRozkladu) {
		throw new UnsupportedOperationException();
	}

	public void usunPojazd(int nrPojazdu) {
		throw new UnsupportedOperationException();
	}

	public void usunPrzystanek(int nrPrzystanku) {
		throw new UnsupportedOperationException();
	}

	public void usunTrase(int nrTrasy) {
		throw new UnsupportedOperationException();
	}

	public String dajKurs(int nrKursu) {
		throw new UnsupportedOperationException();
	}

	public void zaktualizujTrase(int id, String trasa) {
	dao.edytujTrase(id,trasa);
	}

	public void dodajTrase(String Text) {
		CSV csv = new CSV();
		int numer = csv.znajdźNrTrasy(Text);
		String nazwa = csv.znajdźNazwęTrasy(Text);
		Vector<Przystanek> przystanki = new Vector<>();
		for (int i : csv.znajdźPrzystankiTrasy(Text)) {
			System.out.println(i);
			przystanki.add(this.przystanki.get(i));
		}
		trasy.put(numer, new Trasa(numer, nazwa, przystanki));
		Widok.pokaż(getClass().getCanonicalName(), "dodajTrase", true,
				"Trasa została dodana do lokalnego inwentarza i przekazana do DAO");
		dao.dodajTrase(Text);
	}

	// Metody do sprawdzania stanu dla testów FitNesse
	public int getLiczbaTras() {
		return trasy.size();
	}

	public Trasa getOstatniaTrasa() {
		if (trasy.isEmpty()) {
			return null;
		}
		int maxKey = trasy.keySet().stream().max(Integer::compare).orElse(-1);
		return trasy.get(maxKey);
	}

	public Map<Integer, Trasa> getTrasy() {
		return trasy;
	}
}