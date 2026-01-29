package Kontroler;


import Komunikacja.Widok;
import Model.*;
import java.util.Scanner;

public class Main {
	private static IModel model;
	private static Autoryzator autoryzator;
	private static KontrolerKierowcy kontrolerKierowcy;
	private static KontrolerKierownika kontrolerKierownika;
	private static KontrolerTablicy kontrolerTablicy;
	private static KontrolerZarzadcy kontrolerZarzadcy;
	private static Sesja sesja;

	public static void main(String[] args) {
		Widok.ustawGadatliwosc(Widok.Gadatliwosc.PELNA);
		IDAO dao = new DAO();
		Inwentarz inwentarz = new Inwentarz(dao);
		model = new Model(inwentarz,dao);
		Widok.pokaż("Main","main",true,"INICJALIZACJA");
//		Scanner input = new Scanner(System.in);
//
//		autoryzator = new Autoryzator();
//		System.out.println("Podaj Login");
//		String login = input.nextLine();
//		System.out.println("Podaj Hasło");
//		String password = input.nextLine();
//		sesja = autoryzator.autorize(login, password);
//		switch (sesja.getRola()) {
//			case 1:
//				kontrolerKierowcy = new KontrolerKierowcy();
//				break;
//			case 2:
//				kontrolerKierownika= new KontrolerKierownika();
//				break;
//			case 3:
//				kontrolerTablicy = new KontrolerTablicy();
//				break;
//			case 4:
//				kontrolerZarzadcy = new KontrolerZarzadcy();
//				break;
//		}
		kontrolerKierownika = new KontrolerKierownika();
		kontrolerZarzadcy = new KontrolerZarzadcy(model);

		dao.pokazTrasy();
		kontrolerZarzadcy.dodajTrase("10;wroclawianka;1;2;6");
		dao.pokazTrasy();

		kontrolerKierowcy = new KontrolerKierowcy(model);
		kontrolerKierowcy.przyjmijKurs(1);
	}
}