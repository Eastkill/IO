package Kontroler;

import Model.IModel;

public class KontrolerKierowcy implements IKontrolerKierowcy {
	private IModel model;
	private ObslugaKursu obslugaKursu= null;
	private boolean aktywny = true;
	public KontrolerKierowcy(IModel model) {
		this.model = model;
	}

	private void sprawdzCzas(int idKierowcy) {
		throw new UnsupportedOperationException();
	}

	public void przyjmijKurs(int numerKursu) {
		if (obslugaKursu != null) throw new UnsupportedOperationException();
		obslugaKursu = new ObslugaKursu(numerKursu, model);
	}
	public int dlugoscKursu(){
		return obslugaKursu.dlugosc();
	}
	public boolean osiagnijPrzystanek() {
		return obslugaKursu.osiagnijPrzystanek();
	}

	public void zglosIncydent(String text, boolean isEnding) {
		obslugaKursu.zglosIndydent(text, isEnding);

	}

	public ObslugaKursu getObslugaKursu() {
		return obslugaKursu;
	}
}