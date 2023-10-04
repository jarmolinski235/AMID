public class Termostat {
    double aktualnaTemperatura;
    double ustawionaTemperatura;
    private boolean ogrzewanieWlaczane;
    private boolean chlodzenieWlaczane;

    public Termostat() {
        this.aktualnaTemperatura = 20.0;
        this.ustawionaTemperatura = 22.0;
        this.ogrzewanieWlaczane = false;
        this.chlodzenieWlaczane = false;
    }

    public void wlaczOgrzewanie() {
        ogrzewanieWlaczane = true;
        chlodzenieWlaczane = false;
        System.out.println("Ogrzewanie zostało włączone.");
    }

    public void wlaczChlodzenie() {
        chlodzenieWlaczane = true;
        ogrzewanieWlaczane = false;
        System.out.println("Chłodzenie zostało włączone.");
    }

    public void wylaczOgrzewanie() {
        ogrzewanieWlaczane = false;
        System.out.println("Ogrzewanie zostało wyłączone.");
    }

    public void wylaczChlodzenie() {
        chlodzenieWlaczane = false;
        System.out.println("Chłodzenie zostało wyłączone.");
    }

    public void sprawdzTemperature() {
        if (aktualnaTemperatura < ustawionaTemperatura && !chlodzenieWlaczane) {
            wlaczOgrzewanie();
        } else if (aktualnaTemperatura > ustawionaTemperatura && !ogrzewanieWlaczane) {
            wlaczChlodzenie();
        } else if (Math.abs(aktualnaTemperatura - ustawionaTemperatura) < 0.1) {
            wylaczOgrzewanie();
            wylaczChlodzenie();
        }
    }

    public void zmienTemperature(double zmiana) {
        aktualnaTemperatura += zmiana;
        System.out.println("Aktualna temperatura: " + aktualnaTemperatura + " stopni Celsjusza");
        sprawdzTemperature();
    }
}

class SymulatorTermostatu {
    public static void main(String[] args) {
        Termostat termostat = new Termostat();

        System.out.println("Aktualna temperatura: " + termostat.aktualnaTemperatura + " stopni Celsjusza");
        System.out.println("Ustawiona temperatura: " + termostat.ustawionaTemperatura + " stopni Celsjusza");

        termostat.zmienTemperature(1.5);
        termostat.zmienTemperature(-0.8);
    }
}
