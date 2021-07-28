package VaccinePassport.Report;

import VaccinePassport.ClinicManagement.Clinic;
import VaccinePassport.ClinicManagement.Government;
import VaccinePassport.OrderManagement.VaccineOrder;
import VaccinePassport.PatientManagement.Patient;
import VaccinePassport.VaccineManagement.Vaccine;

import java.util.HashSet;

//CDC checks Clinic from Gov system & certification verification
public class CDC {
    String cdcName;
    Vaccine vaccine;
    VaccineOrder vaccineOrder;
    Government departmentOfHealth;
    Clinic clinic;

    public CDC(String cdcName, Government govern) {
        this.cdcName = cdcName;
        departmentOfHealth = govern;  //connect CDC with Government
    }

    public void checkCertification(Certification cf){
        if (cf== null){
            System.out.println("This is a falsified certification. ");
            return;
        }
        Boolean check= false;
        //1.check the identity of clinic from "Government"
        Clinic neededCheckClinic = cf.getClinic();
        HashSet <Clinic> governHash = departmentOfHealth.getClininList();

        //2.check patient in "clinic"
        //From different route: first from Govern, the other clinic from Certification's clinic
        Patient neededCheckPatient= cf.getPatient();    //certification's patient

        //check the identity of clinic + the identity of Patient
        if (governHash.contains(neededCheckClinic)){
            //real Clinic contains neededCheck Patient, then this is a true Patient
            if (neededCheckClinic.getPatientEncounterHistory().keySet().contains(neededCheckPatient)){
                check=true;
                System.out.println("The certification is true. ");
            }
        }else{ System.out.println("This is a falsified certification."); }
    }


}
