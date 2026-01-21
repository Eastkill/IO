package Kontroler;

import Model.IModel;

public class KontrolerKierowcy implements IKontrolerKierowcy {
	private IModel model;
	private ObslugaKursu obslugaKursu= null;

	private void sprawdzCzas(int idKierowcy) {
		throw new UnsupportedOperationException();
	}

	public void przyjmijKurs(int numerKursu) {
		obslugaKursu = new ObslugaKursu(numerKursu, model);
		throw new UnsupportedOperationException();
	}

	public void osiagnijPrzystanek() {
		obslugaKursu.osiagnijPrzystanek();
		throw new UnsupportedOperationException();
	}

	public void zglosIncydent(String text, boolean isEnding) {
		obslugaKursu.zglosIndydent(text, isEnding);
		throw new UnsupportedOperationException();
	}

}