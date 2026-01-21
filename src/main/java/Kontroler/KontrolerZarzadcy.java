package Kontroler;

import Komunikacja.Widok;
import Model.IModel;

public class KontrolerZarzadcy implements IKontrolerZarzadcy {
	private IModel model;
	public KontrolerZarzadcy(IModel model){
		this.model = model;
		Widok.pokaż(getClass().getCanonicalName(),"KontrolerZarzadcy",true,"Zaincicjalizowano kontroler");
	}
	public void dodajTrase(String text) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajTrase",true, "Kontroler zainicjował dodanie Trasy (PU Dodanie Trasy)");
		model.dodanieTrasy(text);

	}

	public void edytujTrase(String text, int nr) {
		Widok.pokaż(this.getClass().getCanonicalName(), "dodajTrase",true, "Kontroler zainicjował dodanie Trasy (PU Dodanie Trasy)");
		model.modyfikacjaTrasy(nr,text);
	}

	public void usunTrase(int[] idTrasy) {
		throw new UnsupportedOperationException();
	}
}