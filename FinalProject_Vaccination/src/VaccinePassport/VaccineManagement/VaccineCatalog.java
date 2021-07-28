package VaccinePassport.VaccineManagement;

import java.util.ArrayList;

public class VaccineCatalog {
    //Vaccine vaccine;
    ArrayList <Vaccine> vaccineList;

    public VaccineCatalog() {
        vaccineList = new ArrayList<>();
    }
    public void  addVaccineIntoCata (Vaccine v){
        vaccineList.add(v);

    }

    //getter setter
//    public Vaccine getVaccine() {
//        return vaccine;
//    }
//    public void setVaccine(Vaccine vaccine) {
//        this.vaccine = vaccine;
//    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

}
