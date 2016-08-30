package ru.encyclopatia.drugster228.network.responce;

import java.util.ArrayList;

import ru.encyclopatia.drugster228.model.InSale;
import ru.encyclopatia.drugster228.model.ProofSection;

public class DrugResponce {
    private String objectId;
    private String name;
    private String description;
    private String indicated;
    private String contraIndicated;
    private ArrayList<InSale> inSale;
    private ProofSection proofSection;

    public DrugResponce(String objectId, String name, String description, String indicated,
                        String contraIndicated, ArrayList<InSale> inSale, ProofSection proofSection) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.indicated = indicated;
        this.contraIndicated = contraIndicated;
        this.inSale = inSale;
        this.proofSection = proofSection;
    }

    public DrugResponce() {

    }

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIndicated() {
        return indicated;
    }

    public String getContraIndicated() {
        return contraIndicated;
    }

    public ArrayList<InSale> getInSale() {
        return inSale;
    }

    public ProofSection getProofSection() {
        return proofSection;
    }


//    public ArrayList<ProofStuff> getProofStuff() {
//        return proofStuff;
//    }
//
//    public ArrayList<InSale> getInSale() {
//        return inSale;
//    }
}
