package ru.encyclopatia.drugster228.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.encyclopatia.drugster228.realm.RealmString;

public class ProofStuff extends RealmObject {
    @PrimaryKey
    private String proofSource;
    private String proofDescription;
    private RealmList<RealmString> proofURLS;

    public ProofStuff(String proofSource, String proofDescription, RealmList<RealmString> proofURLS) {
        this.proofSource = proofSource;
        this.proofDescription = proofDescription;
        this.proofURLS = proofURLS;
    }

    public ProofStuff() {

    }

    public String getProofSource() {
        return proofSource;
    }

    public void setProofSource(String proofSource) {
        this.proofSource = proofSource;
    }

    public String getProofDescription() {
        return proofDescription;
    }

    public void setProofDescription(String proofDescription) {
        this.proofDescription = proofDescription;
    }

}
