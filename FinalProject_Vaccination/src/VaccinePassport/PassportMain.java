package VaccinePassport;

import VaccinePassport.ClinicManagement.Clinic;
import VaccinePassport.ClinicManagement.Government;
import VaccinePassport.EmployeeManagement.Nurse;
import VaccinePassport.EmployeeManagement.Physician;
import VaccinePassport.OrderManagement.VaccineOrder;
import VaccinePassport.PatientManagement.Patient;
import VaccinePassport.Personnel.Person;
import VaccinePassport.Report.CDC;
import VaccinePassport.Report.Certification;
import VaccinePassport.VaccineManagement.Vaccine;
import VaccinePassport.VaccineManagement.VaccineCatalog;
import VaccinePassport.VaccineManagement.VaccineInventory;
import VaccinePassport.VisitManagement.CurrentEncounter;

import java.util.ArrayList;
import java.util.HashMap;

public class PassportMain {
    public static void main(String[] args) {
        //task0 vaccine inventory management
        //1. create new vaccine
        Vaccine moderna = new Vaccine("Moderna");
        Vaccine jJ=  new Vaccine("Johnson& Johnson");
        Vaccine pfizer=  new Vaccine("Pfizer");
        //2.put vaccine into vaccineCatalog
        VaccineCatalog vaccineCatalog = new VaccineCatalog();
        vaccineCatalog.addVaccineIntoCata(moderna);
        vaccineCatalog.addVaccineIntoCata(jJ);
        vaccineCatalog.addVaccineIntoCata(pfizer);
        //3.put vaccine into vaccineInventory
        VaccineInventory vaccineInventory = new VaccineInventory();
        vaccineInventory.addVaccineInventory(moderna, 9000);
        vaccineInventory.addVaccineInventory(jJ, 6000);
        vaccineInventory.addVaccineInventory(pfizer, 15000);
        //4. show vaccine inventory
        System.out.println(" *****    Task0: vaccine inventory management   *****");
        System.out.println("    [before patient used]      ");
        for (Vaccine x: vaccineInventory.getvInventoryMap().keySet()){
            System.out.println("vaccine name: "+ x.getName()+
                    ",  " +
                    "quantity: "+ vaccineInventory.getvInventoryMap().get(x)
                    );
        }

        //Task1 Person Identity
        //Patient, Nurse & Physician
        Person p1 = new Person("Amanda", "09/30/2000");
        Patient pt1 = new Patient(p1);
        Person p2 = new Person("Eric", "09/16/1988");
        Patient pt2 = new Patient(p2);
        Person p3 = new Person("Nurse: Nancy", "01/16/1988");
        Person p4 = new Person("Doctor: Jeffrey", "02/16/1977");
        Nurse n1= new Nurse(p3);
        Physician py1 = new Physician(p4);
        Person p5 = new Person("Steve", "10/3/1980");
        Patient pt5 = new Patient(p5);
        Person p6 = new Person("Tom", "12/3/1980");
        Patient pt6 = new Patient(p6);

        //Task2 vaccination happens at " someplace, sometime "
        //1. create clinic
        Clinic uwMedicine = new Clinic("UW Medicine");
        //2. create currentEncounter
        CurrentEncounter ce = new CurrentEncounter(
                pt1, "get vaccination", "2021/04/19", n1);
        CurrentEncounter ce2 = new CurrentEncounter(
                pt2, "headache", "2021/01/31", n1);
        //3. connect clinic with EncounterHistory
        uwMedicine.addPatientIntoEncounterHistory(ce);
        uwMedicine.addPatientIntoEncounterHistory(ce2);



        //Task5 clinic-unit management
        Clinic harborview = new Clinic("Harborview Medical Center");
        Clinic swedish = new Clinic("Swedish Hospital");
        CurrentEncounter ce5 = new CurrentEncounter(
                pt5, "get vaccination", "2021/02/19", n1);
        CurrentEncounter ce6 = new CurrentEncounter(
                pt5, "diarrhea", "2020/02/19", n1);
        harborview.addPatientIntoEncounterHistory(ce5);  //connect patient with clinic
        swedish.addPatientIntoEncounterHistory(ce6);
        System.out.println();
        System.out.println("****    Task5 clinic-unit management      ********");
        for(Patient p: harborview.getPatientEncounterHistory().keySet()){
            System.out.println("Patient name: " + p.getPerson().getName());
            HashMap <Patient, ArrayList<CurrentEncounter> > tempHash=
                    harborview.getPatientEncounterHistory();
            int theLastItem= tempHash.get(p).size()-1;
            System.out.println("Date of encounter: "+tempHash.get(p)
                    .get(theLastItem).getDateOfEncounter());
            System.out.println("clinic name: "+harborview.getClinicName());
            System.out.println(tempHash.get(p).get(theLastItem)
                    .getNurse().getPerson().getName());
        }
        System.out.println();
        for(Patient p: swedish.getPatientEncounterHistory().keySet()){
            System.out.println("Patient name: " + p.getPerson().getName());
            HashMap <Patient, ArrayList<CurrentEncounter> > tempHash= swedish.getPatientEncounterHistory();
            System.out.println("the most recent encount: ");
            int theLastItem= tempHash.get(p).size()-1;
            System.out.println("Date of encounter: "+tempHash.get(p).get(theLastItem).getDateOfEncounter());
            System.out.println("clinic name: "+swedish.getClinicName());
            System.out.println(tempHash.get(p).get(theLastItem)
                    .getNurse().getPerson().getName());
        }
        //Task6 Certify the entities (clinics & nurses)


        //Task3 Certification
        //1. physician orders vaccineOrder for patient
        VaccineOrder vaccineOrder = new VaccineOrder(py1, moderna);  //connect physician orders vaccine for a patient
        VaccineOrder vaccineOrder5 = new VaccineOrder(py1, pfizer);
        //Patient who wants to be vaccinated will have VaccineOrder
        //if patient does not want to be vaccinated, vaccineOrder will be null

        //2. patient who got vaccinated the vaccineInventory will deduct "1".
        ce.newVaccineOrder(vaccineOrder);     //connect CurrentEncounter with VaccineOrder
        ce5.newVaccineOrder(vaccineOrder5);
        vaccineInventory.deductOneVaccineFromInvent(ce.getVaccineOrder().getVaccine());   //vaccineInventory deduct "1" in the inventory
        vaccineInventory.deductOneVaccineFromInvent(ce5.getVaccineOrder().getVaccine());
        System.out.println();
        System.out.println("**** Task0 Vaccine Inventory  ****   ");
        System.out.println("     [after patient used]      ");
        for (Vaccine x: vaccineInventory.getvInventoryMap().keySet()){
            System.out.println("vaccine name: "+ x.getName()+
                    ",  " +
                    "quantity: "+ vaccineInventory.getvInventoryMap().get(x)
            );
        }
        System.out.println();

        System.out.println("****    Task1 Person Identity     *****");
        System.out.println("****    Task2  vaccination happens at someplace sometime     *****");
        for(Patient p: uwMedicine.getPatientEncounterHistory().keySet()){
            System.out.println("Patient name: " + p.getPerson().getName());
            HashMap <Patient, ArrayList<CurrentEncounter> > tempHash= uwMedicine.getPatientEncounterHistory();
            //the last item in ArrayList is the most recent encounter
            int theLastItem= tempHash.get(p).size()-1;
            //time
            System.out.println("Date of encounter: "+tempHash.get(p).get(theLastItem).getDateOfEncounter());
            //place - only the clinic which sees this patient will be able to create CurrentEncounter
            //other clinic has no access
            System.out.println("clinic name: "+uwMedicine.getClinicName());
            System.out.println(tempHash.get(p).get(theLastItem)
                    .getNurse().getPerson().getName());
            if (tempHash.get(p).get(theLastItem).getVaccineOrder() != null){
            System.out.println("Vaccine name: "+tempHash.get(p).get(theLastItem).getVaccineOrder().getVaccine().getName());
            }else{
                System.out.println("  [this person is not vaccinated]  ");
            }
            System.out.println("chief complaint: "+ tempHash.get(p).get(theLastItem).getChiefComplaint());
            System.out.println();
        }


        //3. certification
        Certification certification1 = new Certification(pt1, vaccineOrder);  //assign certification1
        //certification1.getDateOfEncounter();
        Certification certification5 = new Certification(pt5, vaccineOrder5);    //certification5
        //certification5.setClinic(harborview);
        //certification5.setDateOfEncounter(ce5.getDateOfEncounter());
        System.out.println();
        System.out.println("****    Task3 Certification           ****   ");
        System.out.println("***     Task6 Certify the entities(clinics & nurses)    ******");
        System.out.println(certification1.getDateOfEncounter());
        System.out.println("Patient1: "+ certification1.getPatient().getPerson().getName());
        System.out.println("Does this patient get vaccinated: "+ certification1.getVaccineOrder().getTakeVaccine());
        System.out.println("Vaccine name: "+certification1.getVaccine().getName());
        System.out.println("location: " + certification1.getClinic().getClinicName());
        System.out.println(ce.getNurse().getPerson().getName());
        System.out.println();
        System.out.println("Patient2 does not get vaccine, so this does generate a certification for patient2. " +
                "The certification data for pt2 is 'null'");
        System.out.println();
        //checking system for no certification patient
        System.out.println(certification5.getDateOfEncounter());
        System.out.println("Patient5: "+  certification5.getPatient().getPerson().getName());
        System.out.println("Does this patient get vaccinated: "+ certification5.getVaccineOrder().getTakeVaccine());
        System.out.println("Vaccine name: "+certification5.getVaccine().getName());
        System.out.println("location: " + certification5.getClinic().getClinicName());
        System.out.println(ce5.getNurse().getPerson().getName());
        System.out.println();


        //Task4 Verification
        //Task6 cheat the system
        //1. create government system to store all clinics
        Government departmentOfHealth = new Government("Department of Health");
        departmentOfHealth.addClinicInGovSystem(uwMedicine);
        departmentOfHealth.addClinicInGovSystem(harborview);
        CDC cdc = new CDC("Centers for Disease Control", departmentOfHealth);

        //2. verification
        System.out.println("****    Task4 Verification           ****   ");
        System.out.println("The verification for: " + certification1.getPatient().getPerson().getName());
        cdc.checkCertification(certification1);
        System.out.println();
        System.out.println("The verification for: " + certification5.getPatient().getPerson().getName());
        cdc.checkCertification(certification5);
        System.out.println();

        //3. fake certification
        System.out.println("****    Task6 cheat the system           ****   ");
//        Certification certification2 = null;
//        cdc.checkCertification(certification2);
//        System.out.println();
        VaccineOrder vaccineOrder6= new VaccineOrder(py1, jJ);
        Certification certification6 = new Certification(pt6, vaccineOrder6);
        System.out.println("The verification for: " + certification6.getPatient().getPerson().getName());
        cdc.checkCertification(certification6);
        System.out.println("   ---This certification has no currentEncounter, and no clinic connection with it.\n" +
                " And the verification system catch this error.----    ");
        //This certification has no currentEncounter, and no clinic connection with it.
        //And the verification system catch this error.


    }
}
