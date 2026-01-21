package Kontroler;

import Model.IModel;

public class ZgloszenieIncydentu extends StrategiaZakonczeniaKursu {
	protected IModel model;
	int nrKursu;
	private String lokalizacja;
	public ZgloszenieIncydentu( IModel model, int numerKursu ) {
		this.model = model;
		this.nrKursu = numerKursu;
	}
	public void zglosInydent(String lokalizacja) {
		model.utworzenieIncydentu(lokalizacja + " Kurs: " +nrKursu);
	}

	public void zakonczKurs() {
		zglosInydent(lokalizacja);

		model.modifikacjaKursu(model.dajKurs(nrKursu));
	}
}