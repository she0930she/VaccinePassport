package VaccinePassport.EmployeeManagement;

import VaccinePassport.Personnel.Person;

public class Nurse {
    Person person;

    public Nurse(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
