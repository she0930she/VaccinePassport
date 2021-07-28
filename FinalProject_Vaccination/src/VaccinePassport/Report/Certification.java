package VaccinePassport.Report;

import VaccinePassport.ClinicManagement.Clinic;
import VaccinePassport.OrderManagement.VaccineOrder;
import VaccinePassport.PatientManagement.Patient;
import VaccinePassport.Personnel.Person;
import VaccinePassport.VaccineManagement.Vaccine;

import java.util.ArrayList;

public class Certification {
    Clinic clinic;
    Vaccine vaccine;
    ArrayList <VaccineOrder> vaccineOrderList;    //This is my VaccineHistory
    Patient patient;
    String dateOfEncounter;
    VaccineOrder vaccineOrder;
    //Certification links with VaccineOrder (=>CurrentEncounter)

    public Certification(Patient patient, VaccineOrder vo) {
        this.patient = patient;
        this.clinic = vo.getClinic();
        this.dateOfEncounter = vo.getDateOfEncounter();
        vaccineOrderList= new ArrayList<>();
        this.vaccineOrder =vo;
        this.vaccine = vo.getVaccine();
        vaccineOrderList.add(vo);
    }
//    public void addVaccineOrder (VaccineOrder vo){
//        this.vaccineOrder =vo;
//        this.vaccine = vo.getVaccine();
//        vaccineOrderList.add(vo);
//    }

    //getter setter
    public Vaccine getVaccine() {
        return vaccine;
    }
    public ArrayList<VaccineOrder> getVaccineOrderList() {
        return vaccineOrderList;
    }
    public Patient getPatient() {
        return patient;
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
    public VaccineOrder getVaccineOrder() {
        return vaccineOrder;
    }
}
