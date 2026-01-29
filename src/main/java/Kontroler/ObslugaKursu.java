package Kontroler;

import Model.IModel;
import com.sun.jdi.ClassType;

public class ObslugaKursu {
	private int numerKursu;
	private String[] trasa = null;
	private int obecny;
	private StrategiaZakonczeniaKursu zakonczenieKursu = null;
	private IModel model;

	public ObslugaKursu(int numerKursu, IModel model) {
		if (numerKursu<0)throw new RuntimeException("Bład");
		this.numerKursu = numerKursu;
		this.model = model;
		this.trasa = model.dajPrzystanki(numerKursu);
	}
	public int dlugosc(){
		return trasa.length;
	}
	public int getNumerKursu() {
		return this.numerKursu;
	}

	public boolean osiagnijPrzystanek() {
		if (this.obecny < this.trasa.length) {
			this.obecny++;
			return true;
		}
		else {
			this.zakonczenieKursu = new ZakonczenieKursu(model, this.numerKursu);
		return false;
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
	public boolean czyKonczy(){
		return zakonczenieKursu != null;
	}
}