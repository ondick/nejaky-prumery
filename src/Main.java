import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SkolniSystem system = new SkolniSystem();

        Student student1 = new Student("Ondra", 4, 1.2);
        Student student2 = new Student("Michal", 3, 2.6);
        Student student3 = new Student("Michal", 3, 2.6);

        system.pridatStudenta(student1);
        system.pridatStudenta(student2);
        system.pridatStudenta(student3);

        System.out.println("--- TESTOVÁNÍ FUNKCÍ Z ČÁSTI A ---");
        if (student2.equals(student3)) {
            System.out.println("Student is the same (student2 a student3 se shodují)");
        }

        student1.zlepsiPrumer(1.0);
        System.out.println("Ondra po zlepšení: " + student1);

        System.out.println("Klasifikace pro Michala: " + student2.klasifikace());
        System.out.println("----------------------------------\n");


        boolean bezi = true;

        while (bezi) {
            System.out.println("1) Přidat studenta");
            System.out.println("2) Vypsat studenty");
            System.out.println("3) Hledat podle jména");
            System.out.println("0) Konec");
            System.out.print("Vyberte akci: ");

            String volbaStr = scanner.nextLine();
            int volba;

            try {
                volba = Integer.parseInt(volbaStr);
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup, zadejte číslo.");
                continue;
            }

            switch (volba) {
                case 1:
                    try {
                        System.out.print("Jméno studenta: ");
                        String jmeno = scanner.nextLine();
                        System.out.print("Ročník (1-4): ");
                        int rocnik = Integer.parseInt(scanner.nextLine());
                        System.out.print("Průměr (1.0-5.0): ");
                        double prumer = Double.parseDouble(scanner.nextLine().replace(",", "."));

                        system.pridatStudenta(new Student(jmeno, rocnik, prumer));
                        System.out.println("Student byl úspěšně přidán.");
                    } catch (Exception e) {
                        System.out.println("Chyba při zadávání údajů: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\nSeznam studentů:");
                    system.vypsatStudenty();
                    break;

                case 3:
                    System.out.print("Zadejte jméno hledaného studenta: ");
                    String hledaneJmeno = scanner.nextLine();
                    Student nalezeny = system.najitDleJmena(hledaneJmeno);

                    if (nalezeny != null) {
                        System.out.println("Student nalezen:");
                        nalezeny.popis();

                        System.out.print("Přejete si upravit jeho průměr? (ano/ne): ");
                        String odpoved = scanner.nextLine();
                        if (odpoved.equalsIgnoreCase("ano")) {
                            System.out.print("Zadejte nový průměr: ");
                            try {
                                double novyPrumer = Double.parseDouble(scanner.nextLine().replace(",", "."));
                                nalezeny.setPrumer(novyPrumer);
                                System.out.println("Průměr byl úspěšně změněn.");
                            } catch (Exception e) {
                                System.out.println("Chyba: " + e.getMessage());
                            }
                        }
                    } else {
                        System.out.println("Student nenalezen.");
                    }
                    break;

                case 0:
                    bezi = false;
                    System.out.println("Konec programu.");
                    break;

                default:
                    System.out.println("Neplatná volba. Zadejte číslo z menu.");
            }
        }
        scanner.close();
    }
}