# Autowaschanlage

Ein interaktives Konsolenprogramm zur Verwaltung einer Warteschlange vor einer Autowaschanlage, das das FIFO-Prinzip (First-In-First-Out) umsetzt und eine automatische Abarbeitung mittels Multithreading bietet.

## 📋 Projektinformationen

| Feld | Inhalt |
| :--- | :--- |
| **Projektname** | Autowaschanlage |
| **Klasse / Kurs** | 1a APC |
| **Schuljahr** | 2026 |
| **Abgabedatum** | 12.05.2026 |
| **Autor/in** | Betül Celik |
| **Lehrer/in** | Gerhard Jarz |
| **Fach** | Programmieren / Java |

## 📝 Projektbeschreibung

**Ziel der Anwendung:** Das Programm dient zur effizienten Steuerung und Verwaltung von maximal 10 Fahrzeugen in einer Warteschlange vor einer Autowaschanlage, um Platz- und Kapazitätsgrenzen optimal abzubilden.

**Hauptfunktionen:**
* **Menüsteuerung:** Eine interaktive Konsolen-Oberfläche mittels einer `do-while`-Schleife und einer `switch-case`-Mehrfachverzweigung.
* **Auto anstellen:** Neue Fahrzeuge (erfasst mit Kennzeichen und Farbe) reihen sich am Ende der Schlange ein (sofern das Limit von 10 Autos nicht überschritten ist).
* **Einfahren lassen:** Das vorderste Auto verlässt die Warteschlange und fährt in die Waschanlage ein (FIFO-Prinzip). Alle nachfolgenden Autos rücken nach.
* **Schlange verlassen:** Ein Auto kann die Warteschlange jederzeit vorzeitig verlassen, indem das Kennzeichen eingegeben und das Element aus der Liste entfernt wird.
* **Warteschlange anzeigen:** Ausgabe aller aktuell wartenden Fahrzeuge in der Konsole.
* **Fortgeschrittene Erweiterung (Threads):** Eine automatische Abarbeitung der gesamten verbleibenden Warteschlange über einen separaten Thread (`Runnable`). Die Autos fahren im Abstand von 1,5 Sekunden (`Thread.sleep(1500)`) automatisch nacheinander in die Waschanlage ein.

## 📸 Bildschirmfoto

![Bildschirmfoto der Autowaschanlage](bildschirmfoto.png)

## 🛠️ Entwicklungsumgebung

### Verwendete Programme & Werkzeuge

| Programm / Werkzeug | Version | Zweck |
| :--- | :--- | :--- |
| IntelliJ IDEA | Neueste Version | Entwicklungsumgebung (IDE) |
| Java Development Kit (JDK) | 17 / 21 | Kompilieren und Ausführen des Java-Quellcodes |

### Zusatzpakete & Bibliotheken

| Paket / Bibliothek | Version | Zweck |
| :--- | :--- | :--- |
| `java.util.Scanner` | Standard | Einlesen von Benutzereingaben über die Konsole |
| `java.util.LinkedList` / `List` | Standard | Dynamische Verwaltung der Warteschlangen-Elemente |
| `java.lang.Thread` | Standard | Multithreading für die automatische Abarbeitung der Autos |

### Betriebssystem (Entwicklung)
* **Betriebssystem:** Windows

## 🚀 Installation & Ausführung

### Voraussetzungen
* [x] Java JDK ist installiert und im Systempfad (PATH) hinterlegt.
* [x] Eine Kommandozeile (Terminal) oder eine IDE (wie IntelliJ IDEA) ist vorhanden.

### Schritte über die Konsole

```bash
# 1. In den Projektordner wechseln, in dem sich die .java-Dateien befinden
cd [Pfad-zum-Ordner]

# 2. Alle Quellcodedateien kompilieren
javac Main.java Auto.java Warteschlange.java

# 3. Das Hauptprogramm starten
java Main
