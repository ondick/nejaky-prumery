public class Ucitel extends Osoba implements IVypisovatelny{

    private String predmet;

    public Ucitel(String jmeno, String predmet) {
        super(jmeno);
        setPredmet(predmet);
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        if (predmet == null || predmet.trim().isEmpty()) {
            throw new IllegalArgumentException("Předmět nesmí být prázdný.");
        }
        this.predmet = predmet.trim();
    }

    @Override
    public void popis() {
        System.out.println("Učitel: " + getJmeno() + ", vyučuje: " + predmet);
    }

    @Override
    public String radekVypisu() {
        return String.format("Učitel  | %-15s | vyučuje: %s", getJmeno(), predmet);
    }
}
