package registreties;

import java.util.Scanner;

public class mainApp { // galvenā klase ar visām funkcijām programmas

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //ievades skeneris
        CsvFileHandler fileHandler = new CsvFileHandler("students.csv"); //CSV fails
        registrationService service = new registrationService(fileHandler); 
         
        boolean running = true; //kontrole ciklam

        while (running) {

            System.out.println("Izvēlies darbību: register | show | remove | edit | exit");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {

                case "register" -> handleRegister(scanner, service); //reģistrācija
                case "show" -> tablePrinter.printstudents(service.getAll()); //tabulas izdruka
                case "remove" -> handleRemove(scanner, service); // dzēšana
                case "edit" -> handleEdit (scanner, service); // rediģēšana
                case "exit" -> running = false; //iziet
                default -> System.out.println("Nezināma komanda"); 
            }
        }

        scanner.close();  //aizver skeneri

    }

    private static void handleRegister(Scanner scanner, registrationService service) {

        try {
            System.out.print("Vārds");
            String name = scanner.nextLine();
            if (!validator.isValidName(name)) throw new validationException ("Nepareizs vārds!");

            System.out.print("Uzvārds");
            String surname = scanner.nextLine();
            if (!validator.isValidName(surname)) throw new validationException ("Nepareizs uzvārds!");

            System.out.print("E-pasts");
            String email = scanner.nextLine();
            if (!validator.isValidEmail(email)) throw new validationException ("Nepareizs E-pasts!");

            System.out.print("Personas kods");
            String personalCode = scanner.nextLine();
            if (!validator.isValidPersonalCode(personalCode)) throw new validationException ("Nepareizs personas kods!");
        
            String dateTime = dateTimeUtil.nowAsString(); // iegūst datumu un laiku

            student s = new student (name, surname, email, personalCode, dateTime); //izveido studentu

            service.register(s); //reģistrē
            System.out.println("Students ir reģistrēts!");
        } catch (validationException e) {

            System.out.println("Kļūda" + e.getMessage());
        }
    }

    private static void handleRemove (Scanner scanner, registrationService service){ //dzēšanas funkcija

        System.out.print("Ievadi personas kodu dzēšanai: ");
        String code = scanner.nextLine();

        if (service.removeByPersonalCode(code)) {

            System.out.println("Students dzēsts!");
        } else {

            System.out.println("Students ar šādu personas kodu nav atrast!");
        }
    }

    private static void handleEdit (Scanner scanner, registrationService service) { //rediģēšanas funkcija

        System.out.print("Ievadi personas kodu rediģēšanai!");
        String code = scanner.nextLine();

        try {
            System.out.print("Jauns vārds: ");
            String name = scanner.nextLine();
            if (!validator.isValidName(name)) throw new validationException ("Nepareizs vārds!");

            System.out.print("Jauns uzvārds: ");
            String surname = scanner.nextLine();
            if(!validator.isValidName(surname)) throw new validationException ("Nepareizs uzvārds!");

            System.out.print("Jauns e-pasts: ");
            String email = scanner.nextLine();
            if (!validator.isValidEmail(email)) throw new validationException ("Nepareizs E-pasts!");

            String dateTime = dateTimeUtil.nowAsString();

            student updated = new student(name, surname, email, code, dateTime);

            if (service.editByPersonalCode(code, updated)) {

                System.out.println("Dati atjaunoti!");
            } else {

                System.out.println("Students ar šādu personas kodu netika atrasts!");
            }
        } catch (validationException e) {

            System.out.println("Kļūda: " + e.getMessage());
        }
    }
}