package VaccinePassport.PatientManagement;

import VaccinePassport.Personnel.Person;

public class Patient {
    Person person;

    public Patient(Person person) {
       this.person = person;
   }

//    public void addPerson (Person p){
//        person = p;
//    }
    //getter setter
    public Person getPerson() {
        return person;
    }

}
