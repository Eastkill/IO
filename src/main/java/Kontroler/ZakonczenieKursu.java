package Kontroler;

import Model.IModel;

public class ZakonczenieKursu extends StrategiaZakonczeniaKursu {
	protected IModel model;
	int nrKursu;

	public ZakonczenieKursu(IModel model, int nrKursu){
		this.nrKursu=nrKursu;
	};

	public void zakonczKurs() {
		String kurs = model.dajKurs(nrKursu);
		model.modifikacjaKursu(kurs);
	}
}