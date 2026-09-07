import java.util.Objects;

public class Student {
    private String jmeno;
    private int rocnik;
    private double prumer;

    public Student(String jmeno, int rocnik, double prumer) {
        setJmeno(jmeno);
        setRocnik(rocnik);
        setPrumer(prumer);
    }


    public String getJmeno() {
        return jmeno;
    }
    public int getRocnik() {
        return rocnik;
    }
    public double getPrumer() {
        return prumer;
    }


    public void setJmeno(String jmeno) {
        if (jmeno == null || jmeno.trim().isEmpty()) {
            throw new IllegalArgumentException("Jméno nesmí být prázdné.");
        }
        this.jmeno = jmeno;
    }

    public void setRocnik(int rocnik) {
        if (rocnik < 1 || rocnik > 4) {
            throw new IllegalArgumentException("Ročník musí být v rozsahu 1 až 4.");
        }
        this.rocnik = rocnik;
    }

    public void setPrumer(double prumer) {
        if (prumer < 1.0 || prumer > 5.0) {
            throw new IllegalArgumentException("Průměr musí být v rozsahu 1.0 až 5.0.");
        }
        this.prumer = prumer;
    }


    @Override
    public String toString() {
        return "Jmeno= <"+jmeno+">, Rocnik= <"+rocnik+"> , Prumer= <"+prumer+">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(prumer, student.prumer) == 0 && Objects.equals(jmeno, student.jmeno);
    }

}
