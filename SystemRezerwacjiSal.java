import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SalaLekcyjna {
    private String numerSali;
    private int pojemnosc;
    private Map<String, Boolean> terminy;

    public SalaLekcyjna(String numerSali, int pojemnosc) {
        this.numerSali = numerSali;
        this.pojemnosc = pojemnosc;
        this.terminy = new HashMap<>();
    }

    public String getNumerSali() {
        return numerSali;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public boolean czyDostepna(String termin) {
        return !terminy.containsKey(termin) || !terminy.get(termin);
    }

    public void zarezerwuj(String termin) {
        terminy.put(termin, true);
    }

    public void zwolnij(String termin) {
        terminy.put(termin, false);
    }
}

public class SystemRezerwacjiSal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SalaLekcyjna> sale = new ArrayList<>();

        while (true) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj salę");
            System.out.println("2. Zarezerwuj salę");
            System.out.println("3. Sprawdź dostępność sali");
            System.out.println("4. Wyjście");

            int opcja = scanner.nextInt();
            scanner.nextLine();

            switch (opcja) {
                case 1:
                    System.out.print("Podaj numer sali: ");
                    String numerSali = scanner.nextLine();
                    System.out.print("Podaj pojemność sali: ");
                    int pojemnosc = scanner.nextInt();
                    scanner.nextLine();
                    SalaLekcyjna sala = new SalaLekcyjna(numerSali, pojemnosc);
                    sale.add(sala);
                    System.out.println("Sala została dodana.");
                    break;
                case 2:
                    System.out.print("Podaj numer sali: ");
                    numerSali = scanner.nextLine();
                    System.out.print("Podaj termin (data i godzina): ");
                    String termin = scanner.nextLine();
                    SalaLekcyjna salaDoZarezerwacji = znajdzSale(sale, numerSali);
                    if (salaDoZarezerwacji != null && salaDoZarezerwacji.czyDostepna(termin)) {
                        salaDoZarezerwacji.zarezerwuj(termin);
                        System.out.println("Sala została zarezerwowana.");
                    } else {
                        System.out.println("Sala jest już zajęta lub nie istnieje.");
                    }
                    break;
                case 3:
                    System.out.print("Podaj numer sali: ");
                    numerSali = scanner.nextLine();
                    System.out.print("Podaj termin (data i godzina): ");
                    termin = scanner.nextLine();
                    SalaLekcyjna salaDoSprawdzenia = znajdzSale(sale, numerSali);
                    if (salaDoSprawdzenia != null && salaDoSprawdzenia.czyDostepna(termin)) {
                        System.out.println("Sala jest dostępna.");
                    } else {
                        System.out.println("Sala jest zajęta lub nie istnieje.");
                    }
                    break;
                case 4:
                    System.out.println("Dziękujemy. Do widzenia!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
                    break;
            }
        }
    }

    private static SalaLekcyjna znajdzSale(List<SalaLekcyjna> sale, String numerSali) {
        for (SalaLekcyjna sala : sale) {
            if (sala.getNumerSali().equalsIgnoreCase(numerSali)) {
                return sala;
            }
        }
        return null;
    }
}
