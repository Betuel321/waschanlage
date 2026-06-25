import java.util.LinkedList;

public class Warteschlange {
    private static final int MAX_GROESSE = 10;
    private LinkedList<Auto> schlange;

    public Warteschlange() {
        schlange = new LinkedList<>();
    }

    // Auto hinten anstellen
    public boolean hinzufuegen(Auto auto) {
        if (schlange.size() >= MAX_GROESSE) {
            System.out.println("Die Warteschlange ist voll! Kein Platz mehr.");
            return false;
        }
        schlange.addLast(auto);
        System.out.println(auto + " hat sich angestellt.");
        return true;
    }

    // Erstes Auto einfahren lassen (vorne entfernen)
    public Auto einfahren() {
        if (schlange.isEmpty()) {
            System.out.println("Keine Autos in der Warteschlange.");
            return null;
        }
        Auto auto = schlange.removeFirst();
        System.out.println(auto + " fährt in die Waschanlage ein.");
        return auto;
    }

    // Auto per Kennzeichen aus der Schlange entfernen
    public boolean verlassen(String kennzeichen) {
        for (Auto a : schlange) {
            if (a.getKennzeichen().equalsIgnoreCase(kennzeichen)) {
                schlange.remove(a);
                System.out.println(a + " hat die Schlange verlassen und fährt nach Hause.");
                return true;
            }
        }
        System.out.println("Kein Auto mit Kennzeichen '" + kennzeichen + "' gefunden.");
        return false;
    }

    // Schlange anzeigen
    public void anzeigen() {
        if (schlange.isEmpty()) {
            System.out.println("Die Warteschlange ist leer.");
            return;
        }
        System.out.println("--- Aktuelle Warteschlange (" + schlange.size() + "/" + MAX_GROESSE + ") ---");
        int pos = 1;
        for (Auto a : schlange) {
            System.out.println("  " + pos++ + ". " + a);
        }
    }

    public boolean istLeer() {
        return schlange.isEmpty();
    }

    public int getGroesse() {
        return schlange.size();
    }
}
