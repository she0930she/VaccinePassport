package VaccinePassport.VisitManagement;

import java.util.ArrayList;

public class EncounterHistory {
    CurrentEncounter currentEncounter;
    ArrayList <CurrentEncounter> encounterList;

    public EncounterHistory (CurrentEncounter ce) {
        encounterList.add(ce);
    }
}
