package VaccinePassport.EmployeeManagement;

import VaccinePassport.Personnel.Person;

import java.time.Period;

public class Physician {
    Person person;

    public Physician(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
