package Kontroler;

import Model.IModel;

public class ObslugaKursu {
	private int numerKursu;
	private String[] trasa = null;
	private int obecny;
	private StrategiaZakonczeniaKursu zakonczenieKursu;
	private IModel model;

	public ObslugaKursu(int numerKursu, IModel model) {
		this.numerKursu = numerKursu;
		this.model = model;
		this.trasa = model.dajPrzystanki(numerKursu);
	}

	public int getTrasa() {
		throw new UnsupportedOperationException();
	}

	public int getNumerKursu() {
		return this.numerKursu;
	}

	public void osiagnijPrzystanek() {
		if (this.obecny < this.trasa.length)
			this.obecny++;
		else {
			this.zakonczenieKursu = new ZakonczenieKursu(model, this.numerKursu);
		}
	}

	public void zglosIndydent(String text, boolean czyKonczy) {
		if (czyKonczy){
			zakonczenieKursu = new ZgloszenieIncydentu(model,numerKursu);
		}
		else {
			new ZgloszenieIncydentu(model,numerKursu).zglosInydent(text);
		}
	}
}