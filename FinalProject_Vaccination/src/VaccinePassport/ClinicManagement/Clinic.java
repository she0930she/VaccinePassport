package VaccinePassport.ClinicManagement;

import VaccinePassport.PatientManagement.Patient;
import VaccinePassport.VisitManagement.CurrentEncounter;
import VaccinePassport.VisitManagement.EncounterHistory;

import java.util.ArrayList;
import java.util.HashMap;

public class Clinic {
    String clinicName;
    HashMap <Patient, ArrayList<CurrentEncounter> > patientEncounterHistory;
    CurrentEncounter currentEncounter;
    EncounterHistory encounterHistory;
    String address;

    public Clinic(String name) {
        this.clinicName = name;
        patientEncounterHistory= new HashMap<>();
    }

    // add currentEncounter into that Patient EncounterHistory
    public void addPatientIntoEncounterHistory( CurrentEncounter ce){
        Patient p = ce.getPatient();
        ce.setClinic(this);
        ArrayList <CurrentEncounter> currList = patientEncounterHistory.get(p);
        if ( patientEncounterHistory.containsKey(p)   ){
            //put p currentEncounter into value() ArrayList
            //how to add an ArrayList into value()
            currList.add(ce);
        }else{
            //ArrayList has not been initiated
            currList= new ArrayList<>();
            currList.add(ce);
            patientEncounterHistory.put(p,currList);
        }
    }
    

    //getter setter
    public String getClinicName() {
        return clinicName;
    }
    public HashMap<Patient, ArrayList<CurrentEncounter>> getPatientEncounterHistory() {
        return patientEncounterHistory;
    }

}
