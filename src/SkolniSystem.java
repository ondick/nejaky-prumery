import java.util.ArrayList;
import java.util.List;

public class SkolniSystem {
    private List<Student> seznamStudentu;

    public SkolniSystem() {
        this.seznamStudentu = new ArrayList<>();
    }

    public void pridatStudenta(Student student) {
        seznamStudentu.add(student);
    }
    public void vypsatStudenty() {
        if (seznamStudentu.isEmpty()) {
            System.out.println("V systému zatím nejsou žádní studenti.");
            return;
        }

            System.out.println(seznamStudentu.toString());

    }

    public Student najitDleJmena(String jmeno) {
        for (Student s : seznamStudentu) {
            if (s.getJmeno().equalsIgnoreCase(jmeno)) {
                return s;
            }
        }
        return null;
    }

}
