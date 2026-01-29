package Model;

import java.util.ArrayList;

public interface IDAO {

	public void dodajWpisDoRejestru(String zdarzenie);

	public int dodajPracownika(String pracownik);

	public void edytujPracownika(String pracownik);

	public void usunPracownika(int nrPracownika);

	public String znajdzPracownika(int nrPracownika);

	public int dodajPojazd(String pojazd);

	public void edytujPojazd(String pojazd);

	public void usunPojazd(int nrPojazdu);

	public String znajdzPojazd(int nrPojazdu);

	public int dodajPrzystanek(String przystanek);

	public void edytujPrzystanek(String przystanek);

	public void usunPrzystanek(int nrPrzystanku);

	public String znajdzPrzystanek(int nrPrzystanku);

	public int dodajTrase(String trasa);

	public void edytujTrase(int id, String trasa);

	public void usunTrase(int nrTrasy);

	public String znajdzTrase(int nrTrasy);

	public int dodajRozklad(String rozklad);

	public void edytujRozklad(String rozklad);

	public void usunRozklad(int nrRozkladu);

	public String znajdzRozklad(int nrRozkladu);

	public int dodajKurs(String kurs);

	public void edytujKurs(String kurs);

	public String znajdzKurs(int nrKursu);

	public void usunKurs(Object nrKursu);

	public int dodajIncydent(String incydent);

	public String znajdzIncydent(int nrIncydentu);
	public void pokazTrasy();
	public ArrayList<String> dajPrzystanki();
	public String dajTrase(int id);
	public ArrayList<String> dajTrasy();
	}