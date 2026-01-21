package Kontroler;

import Komunikacja.Widok;
import Model.IModel;

public class KontrolerKierownika implements IKontrolerKierownika {
	private IModel model;
	public KontrolerKierownika(){
		Widok.pokaż(getClass().getCanonicalName(),"KontrolerKierownika",true,"Zaincicjalizowano kontroler");
	}
	public void dodajPracownika(int id, String text) {
		throw new UnsupportedOperationException();
	}

	public void edytujPracownika(int id, String text) {
		throw new UnsupportedOperationException();
	}

	public void usunPracownika(int id) {
		throw new UnsupportedOperationException();
	}

	public void dodajPrzystanek(int id, String text) {
		throw new UnsupportedOperationException();
	}

	public void edytujPrzystanek(int id, String text) {
		throw new UnsupportedOperationException();
	}

	public void usunPrzystanek(int id) {
		throw new UnsupportedOperationException();
	}

	public void dodajPojazd(int id, String text) {
		throw new UnsupportedOperationException();
	}

	public void edytujPojazd(int id, String text) {
		throw new UnsupportedOperationException();
	}

	public void usunPojazd(int id) {
		throw new UnsupportedOperationException();
	}

	public void dodajTrase(String text) {
		throw new UnsupportedOperationException();
	}

	public void edytujTrase(String text, int nr) {
		throw new UnsupportedOperationException();
	}

	public void usunTrase(int[] idTrasy) {
		throw new UnsupportedOperationException();
	}
}