package VaccinePassport.OrderManagement;

import VaccinePassport.ClinicManagement.Clinic;
import VaccinePassport.EmployeeManagement.Physician;
import VaccinePassport.PatientManagement.Patient;
import VaccinePassport.VaccineManagement.Vaccine;

public class VaccineOrder {
    Physician physician;
    Boolean takeVaccine;
    Vaccine vaccine;
    Patient patient;
    Clinic clinic;
    String dateOfEncounter;


    public VaccineOrder(Physician physician, Vaccine v) {
        this.physician = physician;
        this.takeVaccine = true;
        this.vaccine =v;
    }
    //vaccineStatus


    public Physician getPhysician() {
        return physician;
    }
    public Boolean getTakeVaccine() {
        return takeVaccine;
    }
    public Vaccine getVaccine() {
        return vaccine;
    }
    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Clinic getClinic() {
        return clinic;
    }
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    public String getDateOfEncounter() {
        return dateOfEncounter;
    }
    public void setDateOfEncounter(String dateOfEncounter) {
        this.dateOfEncounter = dateOfEncounter;
    }
    //patient might choose preferred vaccine to take

}
