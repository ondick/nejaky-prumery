public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Ondra",4,1.2);
        Student student2 = new Student("Michal",3,2.6);
        Student student3 = new Student("Michal",3,2.6);

        if (student2.equals(student3)){
            System.out.println("Student is the same");
        }
        student1.zlepsiPrumer(1);
        System.out.println(student1);
        System.out.println(student2.klasifikace(student2.getPrumer()));

    }
}