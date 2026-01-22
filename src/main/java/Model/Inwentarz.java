package Model;

import Komunikacja.CSV;
import Komunikacja.Widok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Inwentarz {
	private IDAO dao;
	private Map<Integer,Rozklad> rozklady = new HashMap<>();
	private Map<Integer,Pojazd> pojazdy = new HashMap<>();
	private Map<Integer,Kurs> kursy = new HashMap<>();
	private Map<Integer,Trasa> trasy= new HashMap<>();
	private Map<Integer,Przystanek> przystanki = new HashMap<>();
	private Map<Integer, Incydent> incydenty = new HashMap<>();
	private Map<Integer, IPracownik> pracownicy = new HashMap<>();
	public Inwentarz(IDAO dao) {
		this.dao = dao;
		CSV csv = new CSV();
		for (String przystanek : dao.dajPrzystanki()){
			przystanki.put(csv.znajdźNumerPrzystanku(przystanek),new Przystanek(csv.znajdźNazwęPrzystanku(przystanek),csv.znajdźLokalizację(przystanek),csv.znajdźNumerPrzystanku(przystanek),csv.znajdźSzynowy(przystanek)));
		}
		System.out.println(przystanki);
		Widok.pokaż(getClass().getCanonicalName(),"Inwentarz",true,"Zainicjalizowano Inwentarz");
	}

	public IPojazd dajPojazd(int nrPojazdu) {
		throw new UnsupportedOperationException();
	}

	public Przystanek dajPrzystanek(int nrPrzystanku) {
		throw new UnsupportedOperationException();
	}

	public String dajTrase(int nrTrasy) {
		return dao.dajTrase(nrTrasy);
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

	public void zaktualizujTrase(int id, String text){
		dao.edytujTrase(id, text);

		CSV csv = new CSV();
		String nazwa = csv.znajdźNazwęTrasy(text);

		Vector<Przystanek> listaPrzystankow = new Vector<>();
		for (int idPrzystanku : csv.znajdźPrzystankiTrasy(text)) {
			listaPrzystankow.add(this.przystanki.get(idPrzystanku));
		}
		Trasa zmodyfikowanaTrasa = new Trasa(id, nazwa, listaPrzystankow);
		trasy.put(id, zmodyfikowanaTrasa);

		Widok.pokaż(getClass().getCanonicalName(), "edytujTrase", true, "Zaktualizowano trasę ID " + id + " w Inwentarzu");
	}
	public void dodajTrase(String Text){
		dao.dodajTrase(Text);
		CSV csv = new CSV();
		int numer= csv.znajdźNrTrasy(Text);
		String nazwa = csv.znajdźNazwęTrasy(Text);
		Vector<Przystanek> przystanki = new Vector<>();
		for (int i : csv.znajdźPrzystankiTrasy(Text)){
			System.out.println(i);
			przystanki.add(this.przystanki.get(i));
		}
		trasy.put(numer,new Trasa(numer,nazwa,przystanki));
		Widok.pokaż(getClass().getCanonicalName(),"dodajTrase",true,"Trasa została dodana do lokalnego inwentarza i przekazana do DAO");
	}
}