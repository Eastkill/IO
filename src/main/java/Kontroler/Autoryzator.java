package Kontroler;

import Model.IModel;

public class Autoryzator {
	private IModel model;
	private Sesja sesja;

	public Sesja autorize(int mode) {
		sesja = new Sesja();
		sesja.setRola(mode);
		return sesja;
	}
}