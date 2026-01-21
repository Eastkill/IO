package Kontroler;

public interface IKontrolerZarzadcy {

	public void dodajTrase(String text);

	public void edytujTrase(String text, int nr);

	public void usunTrase(int[] idTrasy);
}