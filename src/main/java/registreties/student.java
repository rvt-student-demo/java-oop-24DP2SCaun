package registreties; //norāda, kurā pakotnē atrodas fails

public class student { //klase, kas glabā info par vienu studentu
//privātie lauki, kuriem tikai šī klase var piekļūt
    private String name;  //studenta vārds
    private String surname; //studenta uzvārds
    private String email; //studenta e-pasts
    private String personalCode; //studenta personas kods
    private String registrationDataTime; //studenta reģistrācijas datums un laiks

    public student (String name, 
                    String surname, 
                    String email, 
                    String personalCode, 
                    String registrationDataTime) { //konstruktors - izsaucas, kad tiek izveidots jauns student objekts

        this.name = name; //iestata vārdu
        this.surname = surname; //iestata uzvārdu
        this.email = email; //iestata e-pastu
        this.personalCode = personalCode; //iestata personas kodu
        this.registrationDataTime = registrationDataTime; //iestata reģistrācijas laiku un datumu
    }
// Getter metodes - ļauj citām klasēm nolasīt laukus
    public String getName() {return name; } 
    public String getSurname() {return surname; }
    public String getEmail() {return email; }
    public String getPersonalCode() {return personalCode; }
    public String getRegistrationDateTime() {return registrationDataTime; }

    public String toCvsRow() { //pārvērš student par CSV rindu
        return String.join (";", name, 
                            surname, 
                            email, 
                            personalCode, 
                            registrationDataTime); //join apvieno laukus vienā rindā ar semikolu starpā
    }

    public static student fromCvsRow(String line) { //statiskā metode - izveido student objektu no CVS rindas

        String [] parts = line.split(";"); //sadala rindu masīvā pēc semikola
        return new student (
            parts[0], //vārds
            parts[1], //uzvārds
            parts[2], //e-pasts
            parts[3], //personas kods
            parts[4] //datums un laiks
        );
    }

}