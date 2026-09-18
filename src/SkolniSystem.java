import java.util.ArrayList;
import java.util.List;

public class SkolniSystem {
    private List<Student> seznamStudentu;
    private List<Osoba> listOsob;


    public SkolniSystem() {
        this.seznamStudentu = new ArrayList<>();
        this.listOsob = new ArrayList<>();
    }

    public void pridatStudenta(Osoba osoba) {
        listOsob.add(osoba);
    }
    public void vypsatStudenty() {
        if (listOsob.isEmpty()) {
            System.out.println("V systému zatím nejsou žádní studenti.");
            return;
        }


            System.out.println(listOsob.toString());

    }

    public Osoba najitDleJmena(String jmeno) {
        for (Osoba o : listOsob) {
            if (o.getJmeno().equalsIgnoreCase(jmeno)) {
                return o;
            }
        }
        return null;
    }

}
