import java.util.Scanner;

public class Main {
    private static Warteschlange warteschlange = new Warteschlange();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean autoAbarbeitung = false;

    public static void main(String[] args) {
        int wahl;
        do {
            zeigeMenu();
            wahl = leseInt();
            switch (wahl) {
                case 1 -> autoAnstellen();
                case 2 -> warteschlange.einfahren();
                case 3 -> autoVerlassen();
                case 4 -> warteschlange.anzeigen();
                case 5 -> automatischeAbarbeitung();
                case 0 -> System.out.println("Programm beendet.");
                default -> System.out.println("Ungültige Eingabe!");
            }
            System.out.println();
        } while (wahl != 0);

        scanner.close();
    }

    private static void zeigeMenu() {
        System.out.println("=== Autowaschanlage ===");
        System.out.println("1 - Auto anstellen");
        System.out.println("2 - Nächstes Auto einfahren lassen");
        System.out.println("3 - Auto verlässt die Schlange");
        System.out.println("4 - Warteschlange anzeigen");
        System.out.println("5 - Automatische Abarbeitung (Thread)");
        System.out.println("0 - Beenden");
        System.out.print("Auswahl: ");
    }

    private static void autoAnstellen() {
        System.out.print("Kennzeichen: ");
        String kennzeichen = scanner.nextLine().trim();
        System.out.print("Farbe: ");
        String farbe = scanner.nextLine().trim();
        warteschlange.hinzufuegen(new Auto(kennzeichen, farbe));
    }

    private static void autoVerlassen() {
        System.out.print("Kennzeichen des abfahrenden Autos: ");
        String kennzeichen = scanner.nextLine().trim();
        warteschlange.verlassen(kennzeichen);
    }

    private static void automatischeAbarbeitung() {
        if (warteschlange.istLeer()) {
            System.out.println("Schlange ist leer, nichts zu verarbeiten.");
            return;
        }

        System.out.println("Starte automatische Abarbeitung...");

        // ERWEITERUNG: Thread / Runnable
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!warteschlange.istLeer()) {
                    warteschlange.einfahren();
                    try {
                        Thread.sleep(1500); // 1,5 Sekunden pro Auto simulieren
                    } catch (InterruptedException e) {
                        System.out.println("Thread unterbrochen.");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                System.out.println("Alle Autos wurden gewaschen!");
            }
        });

        thread.start();

        // Warten bis Thread fertig
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Warten unterbrochen.");
        }
    }

    private static int leseInt() {
        try {
            int wert = Integer.parseInt(scanner.nextLine().trim());
            return wert;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
