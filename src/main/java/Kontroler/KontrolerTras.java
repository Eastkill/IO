package Kontroler;

import Model.IModel;

public class KontrolerTras {
	private IModel model;

	public void dodajTrase(int id, String text) {
		if (text == null || !text.matches("^\\d+;[^;]+(;\\d+)+$")) {
			throw new IllegalArgumentException("Błędny format danych tras");
		}
		model.dodanieTrasy(text);
	}

	public void edytujTrase(int id, String text) {
	}

	public void usunTrase(int[] idTrasy) {
		throw new UnsupportedOperationException();
	}
}