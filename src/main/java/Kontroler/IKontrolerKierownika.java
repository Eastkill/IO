package Kontroler;

public interface IKontrolerKierownika extends IKontrolerZarzadcy {

	public void dodajPracownika(int id, String text);

	public void edytujPracownika(int id, String text);

	public void usunPracownika(int id);

	public void edytujPrzystanek(int id, String text);

	public void dodajPrzystanek(int id, String text);

	public void usunPrzystanek(int id);

	public void dodajPojazd(int id, String text);

	public void edytujPojazd(int id, String text);

	public void usunPojazd(int id);
}