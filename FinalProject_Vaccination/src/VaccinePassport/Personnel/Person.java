package VaccinePassport.Personnel;

public class Person {
    String name;
    String dOB;

    public Person(String name, String dOB) {
        this.name = name;
        this.dOB = dOB;
    }

    //getter setter
    public String getName() {
        return name;
    }
    public String getdOB() {
        return dOB;
    }
}
