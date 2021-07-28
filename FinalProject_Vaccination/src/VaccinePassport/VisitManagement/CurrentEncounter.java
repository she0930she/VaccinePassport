package VaccinePassport.VisitManagement;

import VaccinePassport.ClinicManagement.Clinic;
import VaccinePassport.EmployeeManagement.Nurse;
import VaccinePassport.HealthSign.VitalSign;
import VaccinePassport.OrderManagement.VaccineOrder;
import VaccinePassport.PatientManagement.Patient;


public class CurrentEncounter {
    Patient patient;
    String chiefComplaint;
    Nurse nurse;
    VitalSign vs;
    String dateOfEncounter;  //date to take vaccine or date to see dr
    VaccineOrder vaccineOrder;
    Clinic clinic;


    public CurrentEncounter(Patient p, String cc, String doe, Nurse nr) {    //nurse helps checkIn patient
        patient =p;
        this.chiefComplaint = cc;
        this.dateOfEncounter = doe;
        nurse= nr;
        vs = new VitalSign();
    }


    public void newVaccineOrder (VaccineOrder vo){
        this.vaccineOrder= vo;
        vo.setPatient(this.patient);
        vo.setClinic(this.clinic);
        vo.setDateOfEncounter(this.getDateOfEncounter());
    }

    //getter setter
    public Nurse getNurse() {
        return nurse;
    }
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }
    public VitalSign getVs() {
        return vs;
    }
    public void setVs(VitalSign vs) {
        this.vs = vs;
    }

    public Patient getPatient() {
        return patient;
    }
    public String getDateOfEncounter() {
        return dateOfEncounter;
    }
    public VaccineOrder getVaccineOrder() {
        return vaccineOrder;
    }
    public Clinic getClinic() {
        return clinic;
    }
    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }
    //at that encounter day, the register agent choose what clinic this patient is currently at.

}
