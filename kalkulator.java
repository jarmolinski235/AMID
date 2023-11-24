import java.util.Scanner;


class Kwadrat {
    double bok;

    double obliczPole() {
        return bok * bok;
    }
}


class Prostokat {
    double dlugosc;
    double szerokosc;

    double obliczPole() {
        return dlugosc * szerokosc;
    }
}

class Trojkat {
    double podstawa;
    double wysokosc;

    double obliczPole() {
        return 0.5 * podstawa * wysokosc;
    }
}

public class kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz figurę do obliczeń:");
            System.out.println("1. Kwadrat");
            System.out.println("2. Prostokąt");
            System.out.println("3. Trójkąt");
            System.out.println("4. Wyjście");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    Kwadrat kwadrat = new Kwadrat();
                    System.out.print("Podaj długość boku kwadratu: ");
                    kwadrat.bok = scanner.nextDouble();
                    if (kwadrat.bok <= 0) {
                        System.out.println("Błąd: Długość boku musi być dodatnia!");
                        break;
                    }
                    System.out.println("Pole powierzchni kwadratu wynosi: " + kwadrat.obliczPole());
                    break;

                case 2:
                    Prostokat prostokat = new Prostokat();
                    System.out.print("Podaj długość prostokąta: ");
                    prostokat.dlugosc = scanner.nextDouble();
                    System.out.print("Podaj szerokość prostokąta: ");
                    prostokat.szerokosc = scanner.nextDouble();
                    if (prostokat.dlugosc <= 0 || prostokat.szerokosc <= 0) {
                        System.out.println("Błąd: Długość i szerokość muszą być dodatnie!");
                        break;
                    }
                    System.out.println("Pole powierzchni prostokąta wynosi: " + prostokat.obliczPole());
                    break;

                case 3:
                    Trojkat trojkat = new Trojkat();
                    System.out.print("Podaj długość podstawy trójkąta: ");
                    trojkat.podstawa = scanner.nextDouble();
                    System.out.print("Podaj wysokość trójkąta: ");
                    trojkat.wysokosc = scanner.nextDouble();
                    if (trojkat.podstawa <= 0 || trojkat.wysokosc <= 0) {
                        System.out.println("Błąd: Długość podstawy i wysokość muszą być dodatnie!");
                        break;
                    }
                    System.out.println("Pole powierzchni trójkąta wynosi: " + trojkat.obliczPole());
                    break;

                case 4:
                    System.out.println("Dziękujemy za skorzystanie z kalkulatora. Do widzenia!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Błędny wybór! Spróbuj ponownie.");
                    break;
            }
        }
    }
}
