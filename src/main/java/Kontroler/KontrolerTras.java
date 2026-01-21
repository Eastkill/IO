package Kontroler;

import Model.IModel;

public class KontrolerTras {
	private IModel model;

	public void dodajTrase(int id, String text) {
		model.dodanieTrasy(text);
	}

	public void edytujTrase(int id, String text) {
	}

	public void usunTrase(int[] idTrasy) {
		throw new UnsupportedOperationException();
	}
}