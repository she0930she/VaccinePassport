package VaccinePassport.VaccineManagement;


import java.util.HashMap;

public class VaccineInventory {
    Vaccine vaccine;
    int inventoryN;
    HashMap<Vaccine, Integer> vInventoryMap;

    public VaccineInventory() {
        vInventoryMap= new HashMap<>();
    }

    public void addVaccineInventory(Vaccine v, int invent){
        vaccine= v;
        inventoryN = invent;
        vInventoryMap.put(v, invent);
    }
    public HashMap<Vaccine, Integer>  deductOneVaccineFromInvent (Vaccine v){
        for (Vaccine x : vInventoryMap.keySet()){
            if (x == v) {
                int quantity = vInventoryMap.get(x);
                quantity -= 1;
                vInventoryMap.put(x, quantity);
            }
        }
        return vInventoryMap;
    }

    //getter setter

    public HashMap<Vaccine, Integer> getvInventoryMap() {
        return vInventoryMap;
    }
}
