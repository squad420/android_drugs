package ru.encyclopatia.drugster228.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.encyclopatia.drugster228.network.responce.DrugResponce;

public class Drug extends RealmObject {
    @PrimaryKey
    private String objectId;

    private String name;
    private String description;
    private String indicated;
    private String contraIndicated;
    private RealmList<InSale> inSale;
    private ProofSection proofSection;

    public Drug(String objectId, String name, String description, String indicated,
                String contraIndicated, RealmList<InSale> inSale, ProofSection proofSection) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.indicated = indicated;
        this.contraIndicated = contraIndicated;
        this.inSale = inSale;
        this.proofSection = proofSection;
    }

    public Drug() {

    }

    public Drug(String name) {//Test
        this.name = name;
    }

    public Drug(DrugResponce drugResponce) {
        this.objectId = drugResponce.getObjectId();
        this.name = drugResponce.getName();
        this.description = drugResponce.getDescription();
        this.indicated = drugResponce.getIndicated();
        this.contraIndicated = drugResponce.getContraIndicated();
        this.inSale = InSale.getRealmInSale(drugResponce.getInSale());
        this.proofSection = drugResponce.getProofSection();
    }

    public ProofSection getProofSection() {
        return proofSection;
    }

    public void setProofSection(ProofSection proofSection) {
        this.proofSection = proofSection;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIndicated() {
        return indicated;
    }

    public void setIndicated(String indicated) {
        this.indicated = indicated;
    }

    public String getContraIndicated() {
        return contraIndicated;
    }

    public void setContraIndicated(String contraIndicated) {
        this.contraIndicated = contraIndicated;
    }

    public RealmList<InSale> getInSale() {
        return inSale;
    }

    public void setInSale(RealmList<InSale> inSale) {
        this.inSale = inSale;
    }
}
