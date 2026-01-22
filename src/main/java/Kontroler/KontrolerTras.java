package Kontroler;

import Model.IModel;

public class KontrolerTras {
	private IModel model;

	public void dodajTrase(int id, String text) {
		model.dodanieTrasy(text);
	}

	public void edytujTrase(int id, String text) {
		if (model.dajTrase(id) == null){
			throw new NullPointerException("Trasa nie istnieje");
		}
		model.modyfikacjaTrasy(id, text);
	}

	public void usunTrase(int[] idTrasy) {
		for (int i : idTrasy){
			if (model.dajTrase(i) == null) throw new NullPointerException("Trasa nie istnieje");
			model.usuwanieTrasy(i);
		}
	}
}