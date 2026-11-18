class Flug {
    // Objektfelder
    private String zielflughafen;
    private double flugpreis;
    private int anzahlSitzplaetze;
    private int anzahlReservierteSitzplaetze;
    private int flugnummer;

    // Klassenfeld als Zaehler fuer die nächste Flugnummer (nur fuer den Konstruktor zugaenglich)
    private static int naechsteFlugnummer = 1000;

    // 2. Konstruktor mit Uebergabeparametern
    public Flug(String zielflughafen, int anzahlSitzplaetze, double flugpreis) {
        this.zielflughafen = zielflughafen;
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.flugpreis = flugpreis;
        this.anzahlReservierteSitzplaetze = 0; // Zu Beginn sind keine Plätze reserviert

        // Eindeutige Flugnummer ueber das Klassenfeld vergeben und Zaehler erhoehen
        this.flugnummer = naechsteFlugnummer;
        naechsteFlugnummer++;
    }

    // 3. Objektmethode zur Berechnung der Auslastung (Verhältnis reservierte zu vorhandenen Sitzplaetzen)
    public double berechneAuslastung() {
        if (anzahlSitzplaetze == 0) {//um zu meiden Division durch null
            return 0.0;
        }
        return (double) anzahlReservierteSitzplaetze / anzahlSitzplaetze;
    }

    // 4. Klassenmethode zur Berechnung der Einnahmen eines Fluges
    public static double berechneEinnahmen(Flug flug) {//hier ist ein Objekt und kein Konstruktor
        if (flug == null) {
            return 0.0;
        }

        return flug.anzahlReservierteSitzplaetze * flug.flugpreis;
    }

    // Getter fuer die Reservierungsklasse (benoetigt in Aufgabe 6)
    public int getAnzahlSitzplaetze() {
        return anzahlSitzplaetze;
    }

    public int getAnzahlReservierteSitzplaetze() {
        return anzahlReservierteSitzplaetze;
    }

    public void setAnzahlReservierteSitzplaetze(int anzahlReservierteSitzplaetze) {
        this.anzahlReservierteSitzplaetze = anzahlReservierteSitzplaetze;
    }

    // 5. Objektmethode, die alle relevanten Daten in einem String zurueckgibt
    public String getFlugDetails() {
        double auslastungProzent = berechneAuslastung() * 100;
        double einnahmen = berechneEinnahmen(this);

        return "Flug-Nr: " + flugnummer + "\n" +
                "Zielflughafen: " + zielflughafen + "\n" +
                "Flugpreis pro Passagier: " + flugpreis + " EUR\n" +
                "Sitzplaetze gesamt: " + anzahlSitzplaetze + "\n" +
                "Reservierte Sitzplaetze: " + anzahlReservierteSitzplaetze + "\n" +
                "Auslastung: " + String.format("%.2f", auslastungProzent) + "%\n" +
                "Aktuelle Einnahmen: " + einnahmen + " EUR";
    }
}

// 6. Klasse Reservierung
class Reservierung {

    // Klassenmethode zum Pruefen und Durchfuehren einer Reservierung
    public static boolean reservierePlaetze(Flug flug, int anzahlPlaetze) {
        if (flug == null || anzahlPlaetze <= 0) {
            return false;
        }

        int freiePlaetze = flug.getAnzahlSitzplaetze() - flug.getAnzahlReservierteSitzplaetze();

        // Pruefen, ob genügend Plaetze frei sind
        if (anzahlPlaetze <= freiePlaetze) {
            flug.setAnzahlReservierteSitzplaetze(flug.getAnzahlReservierteSitzplaetze() + anzahlPlaetze);
            return true; // Reservierung erfolgreich
        }

        return false; // Nicht genügend Plaetze frei
    }
}