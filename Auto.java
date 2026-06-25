public class Auto {
    private String kennzeichen;
    private String farbe;

    public Auto(String kennzeichen, String farbe) {
        this.kennzeichen = kennzeichen;
        this.farbe = farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getFarbe() {
        return farbe;
    }

    @Override
    public String toString() {
        return "[" + kennzeichen + " | " + farbe + "]";
    }
}
