import java.util.Locale;
import java.util.Objects;

public class Student extends Osoba implements IVypisovatelny{
    //private String jmeno;
    private int rocnik;
    private double prumer;

    public Student(String jmeno, int rocnik, double prumer) {
        super(jmeno);
        //setJmeno(jmeno);
        setRocnik(rocnik);
        setPrumer(prumer);
    }


    /*public String getJmeno() {
        return jmeno;
    }*/

    public int getRocnik() {
        return rocnik;
    }

    public double getPrumer() {
        return prumer;
    }


    /*public void setJmeno(String jmeno) {
        if (jmeno == null || jmeno.trim().isEmpty()) {
            throw new IllegalArgumentException("Mas jmeno blud?");
        }
        this.jmeno = jmeno;
    }*/

    public void setRocnik(int rocnik) {
        if (rocnik < 1 || rocnik > 4) {
            throw new IllegalArgumentException("more kam chodis");
        }
        this.rocnik = rocnik;
    }

    public void setPrumer(double prumer) {
        if (prumer < 1.0 || prumer > 5.0) {
            throw new IllegalArgumentException("1.0 až 5.0.");
        }
        this.prumer = prumer;
    }

    public void zlepsiPrumer(double oKolik) {
        if (oKolik < 0) {
            throw new IllegalArgumentException("Zlepsi to, nezhorsi bruder.");
        }
        this.prumer -= oKolik;
        if (this.prumer < 1.0) {
            this.prumer = 1.0;
        }
    }

    public String klasifikace(){
        if (prumer < 1.5) {
            return "Výborný";
        }
        if (prumer < 2.5) {
            return "Chvalitebný";
        }
        if (prumer < 3.5) {
            return "Dobrý";
        }
        if (prumer < 4.5) {
            return "Dostatečný";
        }
        else return "Nedostatečný";
    }


    @Override
    public String toString() {
        return getJmeno()+" (rocnik = "+rocnik+", prumer = "+prumer+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(prumer, student.prumer) == 0 && Objects.equals(getJmeno(), student.getJmeno());
    }
    public void popis(){
        System.out.println(toString()+", klasifikace: "+klasifikace());
    }

    @Override
    public String radekVypisu() {
        return String.format(Locale.US, "Student | %-15s | ročník %d | průměr %.2f", getJmeno(), rocnik, prumer);    }
}
