package VaccinePassport.ClinicManagement;

import java.util.ArrayList;
import java.util.HashSet;

public class Government {
    String governmentName;
    Clinic clinic;
    HashSet <Clinic > clininList;

    public Government(String governmentName) {
        this.governmentName = governmentName;
        clininList= new HashSet<>();
    }
    //every clinic shall notify Department of Health that they are qualified healthcare provider
    public void addClinicInGovSystem(Clinic c){

        clininList.add(c);
    }
    //問一下怎麼寫？？
    public void IsThisClinicInSystem(Clinic c){
        //Boolean inSystem= false;
        if (clininList.contains(c)){
            //inSystem= true;
            System.out.println("This clinic is a qualified healthcare provider ");
        }else{
            System.out.println("The clinic is not in Department of Health qualified healthcare providers.");
        }
    }

    //getter setter
    public String getGovernmentName() {
        return governmentName;
    }
    public HashSet<Clinic> getClininList() {
        return clininList;
    }
}
