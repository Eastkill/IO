package Model;

import Komunikacja.Widok;

public class Model implements IModel {
	private IDAO dao;
	private Inwentarz inwentarz;

	public Model(Inwentarz inwentarz, IDAO dao) {
		this.inwentarz = inwentarz;
		this.dao = dao;
	}

	public void zarejestrowanieZdarzenia(String zdarzenie) {
		this.dao.dodajWpisDoRejestru(zdarzenie);
	}

	public void dodaniePracownika(String pracownik) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajPracownika",true, "Model wysłał dane o pracowniku do inwentarza");
		dao.dodajPracownika(pracownik);
	}

	public void dodaniePojazdu(String pojazd) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajPojazd",true, "Model wysłał dane o pojezdzie do inwentarza");
		dao.dodajPojazd(pojazd);
	}

	public void dodaniePrzystanku(String przystanek) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajPrzystanek",true, "Model wysłał dane o przystanku do inwentarza");
		dao.dodajPrzystanek(przystanek);
	}

	public void dodanieTrasy(String trasa) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajTrase",true, "Model wysłał dane o trasie do inwentarza");
		inwentarz.dodajTrase(trasa);
	}

	public void dodanieRozkladu(String rozklad) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajRozklad",true, "Model wysłał dane o rozkladzie do DAO");
		dao.dodajRozklad(rozklad);
	}

	public void modyfikacjaPracownika(String pracownik) {
		dao.edytujPracownika(pracownik);
	}

	public void modyfikacjaPojazdu(String pojazd) {
		dao.edytujPojazd(pojazd);
	}

	public void modyfikacjaPrzystanku(String przystankek) {
		dao.edytujPrzystanek(przystankek);
	}

	public void modyfikacjaTrasy(int id,String trasa) {
		dao.edytujTrase(id,trasa);
	}

	public void modyfikacjaRozkladu(String rozklad) {
		dao.edytujRozklad(rozklad);
	}

	public void usuwaniePracownika(int nrPracownika) {
		throw new UnsupportedOperationException();
	}

	public void usuwaniePojazdu(int nrPojazdu) {
		throw new UnsupportedOperationException();
	}

	public void usuwaniePrzystanku(int nrPrzystanku) {
		throw new UnsupportedOperationException();
	}

	public void usuwanieTrasy(int nrTrasy) {
		throw new UnsupportedOperationException();
	}

	public void usuwanieRozkladu(int nrRozkladu) {
		throw new UnsupportedOperationException();
	}

	public String znalezienieRozkladu(int nrRozkladu) {
		throw new UnsupportedOperationException();
	}

	public void utworzenieIncydentu(String incydent) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajIncydent",true, "Model wysłał dane o incydencie do DAO");
		dao.dodajIncydent(incydent);
	}

	public void modifikacjaKursu(String kurs) {
		dao.edytujKurs(kurs);
	}

	public String dajKurs(int nrKursu) {
		throw new UnsupportedOperationException();
	}

	public String[] dajPrzystanki(int nrKursu) {
		throw new UnsupportedOperationException();
	}

}