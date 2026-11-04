class Main {
    public static void main(String[] args) {
        // Objekt vom Typ Flug erzeugen
        Flug meinFlug = new Flug("Muenchen (MUC)", 150, 249.99);

        // Eigenschaften auf der Standardausgabe ausgeben
        System.out.println("--- Urspruengliche Flugdetails ---");
        System.out.println(meinFlug.getFlugDetails());
        System.out.println();

        // Plaetze reservieren
        int gewuenschtePlaetze = 45;
        boolean erfolg = Reservierung.reservierePlaetze(meinFlug, gewuenschtePlaetze);

        System.out.println("Reservierungsversuch von " + gewuenschtePlaetze + " Plaetzen: " + (erfolg ? "Erfolgreich" : "Fehlgeschlagen"));
        System.out.println();

        // Bisherige Auslastung und Einnahmen berechnen und ausgeben
        System.out.println("--- Aktualisierte Flugdetails nach Reservierung ---");
        System.out.println(meinFlug.getFlugDetails());
    }
}