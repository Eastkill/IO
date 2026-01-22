package Model;

public interface IModel {

	public void zarejestrowanieZdarzenia(String zdarzenie);

	public void dodaniePracownika(String pracownik);

	public void dodaniePojazdu(String pojazd);

	public void dodaniePrzystanku(String przystanek);

	public void dodanieTrasy(String trasa);

	public void dodanieRozkladu(String rozklad);

	public void modyfikacjaPracownika(String pracownik);

	public void modyfikacjaPojazdu(String pojazd);

	public void modyfikacjaPrzystanku(String przystankek);

	public void modyfikacjaTrasy(int id, String trasa);

	public void modyfikacjaRozkladu(String rozklad);

	public void usuwaniePracownika(int nrPracownika);

	public void usuwaniePojazdu(int nrPojazdu);

	public void usuwaniePrzystanku(int nrPrzystanku);

	public void usuwanieTrasy(int nrTrasy);

	public void usuwanieRozkladu(int nrRozkladu);

	public String znalezienieRozkladu(int nrRozkladu);

	public void utworzenieIncydentu(String incydent);

	public void modifikacjaKursu(String kurs);

	public String dajKurs(int nrKursu);

	public String[] dajPrzystanki(int nrKursu);

	public String dajTrase(int id);

}