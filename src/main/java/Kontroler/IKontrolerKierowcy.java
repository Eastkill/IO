package Kontroler;

public interface IKontrolerKierowcy {

	public void przyjmijKurs(int numerKursu);

	public boolean osiagnijPrzystanek();

	public ObslugaKursu getObslugaKursu();
	public void zglosIncydent(String text, boolean isEnding);
}