package Komunikacja;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wyszukiwanie lub tworzenie żądanych fragmentów opisu danych w formacie csv dla systemu transportowego:
 * pracownik: (nr;imię;nazwisko;stanowisko;hasło)
 * pojazd: (nr;model;typ(;dataPrzeglądu)?)
 * przystanek: (nr;nazwa;lokalizacja(;czyNaŻądanie)?)
 * trasa: (nr;nazwa(;nrPrzystanku)*)
 */
public class CSV {

    public CSV() {
    }

    // ==========================================
    // SEKCJA: PRACOWNIK
    // ==========================================

    /**
     * Znalezienie numeru pracownika w csv pracownika.
     *
     * @param pracownik csv pracownika (nr;imię;nazwisko;stanowisko;hasło)
     * @return numer pracownika
     */
    public int znajdźNrPracownika(String pracownik) {
        int nr = 0;
        Pattern wzór = Pattern.compile("^\\d+");
        Matcher dopasowanie = wzór.matcher(pracownik);
        if (dopasowanie.find())
            nr = Integer.parseInt(dopasowanie.group());
        return nr;
    }

    /**
     * Znalezienie imienia pracownika w csv pracownika.
     *
     * @param pracownik csv pracownika
     * @return imię pracownika
     */
    public String znajdźImięPracownika(String pracownik) {
        String imię = "";
        // Szuka ciągu znaków po pierwszym średniku i cyfrach
        Pattern wzór = Pattern.compile("(?<=\\d;)[\\p{L} ]+(?=;)");
        Matcher dopasowanie = wzór.matcher(pracownik);
        if (dopasowanie.find())
            imię = dopasowanie.group();
        return imię;
    }

    /**
     * Znalezienie nazwiska pracownika w csv pracownika.
     *
     * @param pracownik csv pracownika
     * @return nazwisko pracownika
     */
    public String znajdźNazwiskoPracownika(String pracownik) {
        String nazwisko = "";
        // Szuka ciągu znaków po drugim średniku (zakładając, że przed nim jest imię)
        Pattern wzór = Pattern.compile("(?<=;[\\p{L} ]{1,50};)[\\p{L}-]+(?=;)");
        Matcher dopasowanie = wzór.matcher(pracownik);
        if (dopasowanie.find())
            nazwisko = dopasowanie.group();
        return nazwisko;
    }

    /**
     * Utworzenie csv pracownika.
     *
     * @param nr         numer pracownika
     * @param imię       imię
     * @param nazwisko   nazwisko
     * @param stanowisko stanowisko (np. Kierowca, Motorniczy)
     * @param hasło      hasło
     * @return csv pracownika
     */
    public String utwórzCsvPracownika(int nr, String imię, String nazwisko, String stanowisko, String hasło) {
        return nr + ";" + imię + ";" + nazwisko + ";" + stanowisko + ";" + hasło;
    }

    /**
     * Opisanie pracownika.
     *
     * @param pracownik csv pracownika
     * @return opis czytelny dla człowieka
     */
    public String opiszPracownika(String pracownik) {
        return "Pracownik nr " + znajdźNrPracownika(pracownik) + ": "
                + znajdźImięPracownika(pracownik) + " " + znajdźNazwiskoPracownika(pracownik);
    }

    // ==========================================
    // SEKCJA: POJAZD
    // ==========================================

    /**
     * Znalezienie numeru pojazdu.
     *
     * @param pojazd csv pojazdu (nr;model;typ;dataPrzeglądu)
     * @return numer pojazdu
     */
    public int znajdźNrPojazdu(String pojazd) {
        int nr = 0;
        Pattern wzór = Pattern.compile("^\\d+");
        Matcher dopasowanie = wzór.matcher(pojazd);
        if (dopasowanie.find())
            nr = Integer.parseInt(dopasowanie.group());
        return nr;
    }

    /**
     * Znalezienie daty przeglądu pojazdu.
     *
     * @param pojazd csv pojazdu
     * @return data przeglądu lub pusty ciąg
     */
    public String znajdźDatęPrzeglądu(String pojazd) {
        String data = "";
        Pattern wzór = Pattern.compile("(?<=;)\\d{4}-\\d{2}-\\d{2}$"); // Format RRRR-MM-DD na końcu
        Matcher dopasowanie = wzór.matcher(pojazd);
        if (dopasowanie.find())
            data = dopasowanie.group();
        return data;
    }

    /**
     * Utworzenie csv pojazdu.
     */
    public String utwórzCsvPojazdu(int nr, boolean typ, String dataPrzeglądu) {
        return nr + ";" + ";" + typ + ";" + dataPrzeglądu;
    }

    // ==========================================
    // SEKCJA: PRZYSTANEK
    // ==========================================

    /**
     * Utworzenie csv przystanku.
     *
     * @param nr          numer przystanku
     * @param nazwa       nazwa przystanku
     * @param lokalizacja adres/lokalizacja
     * @return csv przystanku
     */
    public String utwórzCsvPrzystanku(int nr, String nazwa, String lokalizacja, boolean szynowy) {
        return nr + ";" + nazwa + ";" + lokalizacja + ";" + (szynowy?"true":"false");
    }

    /**
     * Znalezienie nazwy przystanku.
     */
    public int znajdźNumerPrzystanku(String p) {
        return Integer.parseInt(p.split(";")[0]);
    }

    public String znajdźNazwęPrzystanku(String p) {
        return p.split(";")[1];
    }

    public String znajdźLokalizację(String p) {
        return p.split(";")[2];
    }

    public boolean znajdźSzynowy(String p) {
        return Boolean.parseBoolean(p.split(";")[3]);
    }

    // ==========================================
    // SEKCJA: TRASA (z listą przystanków)
    // ==========================================

    public boolean czyPoprawnyFormatTrasy(String trasa) {
        if (trasa == null || trasa.isEmpty()) {
            return false;
        }
        return trasa.matches("^\\d+;[^;]+(;\\d+)+$");
    }

    /**
     * Znalezienie numeru trasy.
     *
     * @param trasa csv trasy (nr;nazwa(;nrPrzystanku)*)
     * @return numer trasy
     */
    public int znajdźNrTrasy(String trasa) {
        return znajdźNrPojazdu(trasa); // Ta sama logika co dla pojazdu (pierwsza liczba)
    }

    /**
     * Znalezienie nazwy trasy.
     *
     * @param trasa csv trasy
     * @return nazwa trasy
     */
    public String znajdźNazwęTrasy(String trasa) {
        String nazwa = "";
        Pattern wzór = Pattern.compile("(?<=\\d;)[^;]+(?=;|$)"); // Nazwa po ID, kończy się średnikiem lub końcem linii
        Matcher dopasowanie = wzór.matcher(trasa);
        if (dopasowanie.find())
            nazwa = dopasowanie.group();
        return nazwa;
    }

    /**
     * Znalezienie numerów przystanków w trasie.
     *
     * @param trasa csv trasy (nr;nazwa;id1;id2;id3...)
     * @return lista numerów przystanków
     */
    public ArrayList<Integer> znajdźPrzystankiTrasy(String trasa) {
        ArrayList<Integer> przystanki = new ArrayList<>();
        // Pomijamy pierwsze dwa pola (nr trasy i nazwę), szukamy cyfr po drugim średniku
        Pattern wzór = Pattern.compile("(?<=;)\\d+");
        Matcher dopasowanie = wzór.matcher(trasa);

        int licznikPól = 0;
        while (dopasowanie.find()) {
            licznikPól++;
            // Pierwsze dopasowanie to nr trasy (już obsłużony), pomijamy go w tej liście jeśli regex złapał początek
            // Ale tutaj regex (?<=;) wymaga średnika przed, więc nr trasy na początku linii (bez średnika przed) nie wpadnie.
            // Jednak nazwa trasy jest tekstem.
            // Numery przystanków są po nazwie.
            przystanki.add(Integer.parseInt(dopasowanie.group()));
        }
        return przystanki;
    }

    /**
     * Utworzenie csv trasy.
     *
     * @param nr                numer trasy
     * @param nazwa             nazwa trasy
     * @param numeryPrzystanków lista numerów przystanków
     * @return csv trasy
     */
    public String utwórzCsvTrasy(int nr, String nazwa, ArrayList<Integer> numeryPrzystanków) {
        StringBuilder csv = new StringBuilder(nr + ";" + nazwa);
        for (Integer nrPrzystanku : numeryPrzystanków) {
            csv.append(";").append(nrPrzystanku);
        }
        return csv.toString();
    }

    /**
     * Opisanie trasy.
     *
     * @param trasa csv trasy
     * @return opis trasy (Trasa nr X - 'Nazwa'; liczba przystanków: Y)
     */
    public String opiszTrasę(String trasa) {
        ArrayList<Integer> przystanki = znajdźPrzystankiTrasy(trasa);
        StringBuilder s = new StringBuilder("Trasa nr " + znajdźNrTrasy(trasa) + " - '" + znajdźNazwęTrasy(trasa) + "'; Przystanki: " + znajdźPrzystankiTrasy(trasa));
        return s.toString();
    }

    // ==========================================
    // NARZĘDZIA OGÓLNE
    // ==========================================

    /**
     * Sprawdzenie, czy fragment csv jest numerem.
     *
     * @param fragment fragment csv
     * @return true jeśli jest numerem
     */
    public boolean czyNumer(String fragment) {
        Pattern wzór = Pattern.compile("^\\d+$");
        Matcher dopasowanie = wzór.matcher(fragment);
        return dopasowanie.find();
    }

    /**
     * Sprawdzenie, czy fragment csv jest datą (uproszczone RRRR-MM-DD).
     */
    public boolean czyData(String fragment) {
        Pattern wzór = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher dopasowanie = wzór.matcher(fragment);
        return dopasowanie.find();
    }
    // ==========================================
    // SEKCJA: INCYDENT
    // ==========================================

    /**
     * Znalezienie numeru incydentu.
     *
     * @param incydent csv incydentu (nr;godzina;miejsce;nrKierowcy;opis)
     * @return numer incydentu
     */
    public int znajdźNrIncydentu(String incydent) {
        int nr = 0;
        Pattern wzór = Pattern.compile("^\\d+");
        Matcher dopasowanie = wzór.matcher(incydent);
        if (dopasowanie.find())
            nr = Integer.parseInt(dopasowanie.group());
        return nr;
    }

    /**
     * Znalezienie godziny wystąpienia incydentu.
     *
     * @param incydent csv incydentu
     * @return godzina (np. 14:30)
     */
    public String znajdźGodzinęIncydentu(String incydent) {
        String godzina = "";
        // Szuka wzorca czasu HH:MM po średniku
        Pattern wzór = Pattern.compile("(?<=;)\\d{1,2}:\\d{2}(?=;)");
        Matcher dopasowanie = wzór.matcher(incydent);
        if (dopasowanie.find())
            godzina = dopasowanie.group();
        return godzina;
    }

    /**
     * Znalezienie numeru kierowcy biorącego udział w incydencie.
     *
     * @param incydent csv incydentu
     * @return numer kierowcy
     */
    public int znajdźNrKierowcyIncydentu(String incydent) {
        int nr = 0;
        // Szuka liczby całkowitej, która znajduje się przed ostatnim polem (opisem)
        // Regex: średnik, cyfry, średnik, dowolny tekst (opis), koniec linii
        Pattern wzór = Pattern.compile("(?<=;)\\d+(?=;[^;]+$)");
        Matcher dopasowanie = wzór.matcher(incydent);
        if (dopasowanie.find())
            nr = Integer.parseInt(dopasowanie.group());
        return nr;
    }

    /**
     * Znalezienie miejsca incydentu.
     *
     * @param incydent csv incydentu
     * @return miejsce zdarzenia
     */
    public String znajdźMiejsceIncydentu(String incydent) {
        String miejsce = "";
        // Miejsce znajduje się pomiędzy godziną (HH:MM) a numerem kierowcy (cyfry)
        Pattern wzór = Pattern.compile("(?<=:\\d{2};)[^;]+(?=;\\d)");
        Matcher dopasowanie = wzór.matcher(incydent);
        if (dopasowanie.find())
            miejsce = dopasowanie.group();
        return miejsce;
    }

    /**
     * Znalezienie opisu incydentu.
     *
     * @param incydent csv incydentu
     * @return treść opisu
     */
    public String znajdźOpisIncydentu(String incydent) {
        String opis = "";
        // Ostatni element po średniku
        Pattern wzór = Pattern.compile("(?<=;)[^;]+$");
        Matcher dopasowanie = wzór.matcher(incydent);
        if (dopasowanie.find())
            opis = dopasowanie.group();
        return opis;
    }

    /**
     * Utworzenie csv incydentu.
     *
     * @param nr         numer incydentu
     * @param godzina    godzina zdarzenia
     * @param miejsce    miejsce zdarzenia
     * @param nrKierowcy numer kierowcy
     * @return csv incydentu
     */
    public String utwórzCsvIncydentu(int nr, String godzina, String miejsce, int nrKierowcy) {
        return nr + ";" + godzina + ";" + miejsce + ";" + nrKierowcy;
    }

    /**
     * Opisanie incydentu.
     *
     * @param incydent csv incydentu
     * @return opis czytelny dla człowieka
     */
    public String opiszIncydent(String incydent) {
        return "Incydent nr " + znajdźNrIncydentu(incydent) +
                " [" + znajdźGodzinęIncydentu(incydent) + "] w " + znajdźMiejsceIncydentu(incydent) +
                ". Kierowca ID: " + znajdźNrKierowcyIncydentu(incydent) +
                ". Opis: " + znajdźOpisIncydentu(incydent);
    }
    // ==========================================
    // SEKCJA: KURS
    // ==========================================

    /**
     * Znalezienie numeru kursu.
     * @param kurs csv kursu (nr;godzina;nrTrasy;czyAktywny;opis)
     * @return numer kursu
     */
    public int znajdźNrKursu(String kurs) {
        int nr = 0;
        Pattern wzór = Pattern.compile("^\\d+");
        Matcher dopasowanie = wzór.matcher(kurs);
        if (dopasowanie.find())
            nr = Integer.parseInt(dopasowanie.group());
        return nr;
    }

    /**
     * Znalezienie godziny kursu.
     * @param kurs csv kursu
     * @return godzina (HH:MM)
     */
    public String znajdźGodzinęKursu(String kurs) {
        String godzina = "";
        // Szuka czasu w formacie H:MM lub HH:MM otoczonego średnikami
        Pattern wzór = Pattern.compile("(?<=;)\\d{1,2}:\\d{2}(?=;)");
        Matcher dopasowanie = wzór.matcher(kurs);
        if (dopasowanie.find())
            godzina = dopasowanie.group();
        return godzina;
    }

    /**
     * Znalezienie numeru trasy przypisanej do kursu.
     * @param kurs csv kursu
     * @return numer trasy
     */
    public int znajdźNrTrasyKursu(String kurs) {
        int nr = 0;
        // Szuka liczby znajdującej się bezpośrednio po godzinie (identyfikowanej przez dwukropek i cyfry)
        Pattern wzór = Pattern.compile("(?<=:\\d{2};)\\d+(?=;)");
        Matcher dopasowanie = wzór.matcher(kurs);
        if (dopasowanie.find())
            nr = Integer.parseInt(dopasowanie.group());
        return nr;
    }

    /**
     * Sprawdzenie, czy kurs jest aktywny.
     * @param kurs csv kursu
     * @return true jeśli aktywny
     */
    public boolean czyKursAktywny(String kurs) {
        boolean aktywny = false;
        // Szuka wartości boolean (true/false) poprzedzonej średnikiem
        Pattern wzór = Pattern.compile("(?<=;)(true|false)(?=;)");
        Matcher dopasowanie = wzór.matcher(kurs);
        if (dopasowanie.find())
            aktywny = Boolean.parseBoolean(dopasowanie.group());
        return aktywny;
    }

    /**
     * Znalezienie opisu kursu.
     * @param kurs csv kursu
     * @return opis
     */
    public String znajdźOpisKursu(String kurs) {
        String opis = "";
        // Pobiera wszystko po ostatnim średniku
        Pattern wzór = Pattern.compile("(?<=;)[^;]+$");
        Matcher dopasowanie = wzór.matcher(kurs);
        if (dopasowanie.find())
            opis = dopasowanie.group();
        return opis;
    }

    /**
     * Utworzenie csv kursu.
     * @param nr numer kursu
     * @param godzina godzina odjazdu
     * @param nrTrasy ID trasy
     * @param czyAktywny status kursu
     * @return csv kursu
     */
    public String utwórzCsvKursu(int nr, String godzina, int nrTrasy, boolean czyAktywny, boolean szynowy) {
        return nr + ";" + godzina + ";" + nrTrasy + ";" + czyAktywny + ";" + szynowy;
    }

    /**
     * Opisanie kursu.
     * @param kurs csv kursu
     * @return opis czytelny dla człowieka
     */
    public String opiszKurs(String kurs) {
        String status = czyKursAktywny(kurs) ? "Aktywny" : "Nieaktywny";
        return "Kurs nr " + znajdźNrKursu(kurs) +
                " [" + znajdźGodzinęKursu(kurs) + "] na trasie ID: " + znajdźNrTrasyKursu(kurs) +
                " (" + status + ") - " + znajdźOpisKursu(kurs);
    }
}

