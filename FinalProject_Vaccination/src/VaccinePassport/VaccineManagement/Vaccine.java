package VaccinePassport.VaccineManagement;

public class Vaccine {
    String name;
    int inventoryN;
    String batch;

    public Vaccine(String name) {
        this.name = name;

    }

    //getter setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
