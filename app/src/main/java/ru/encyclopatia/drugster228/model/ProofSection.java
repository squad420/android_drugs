package ru.encyclopatia.drugster228.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ProofSection extends RealmObject {
    private String proofIndex;
    private String proofBaseText;
    private RealmList<ProofStuff> proofStuff;

    public String getProofIndex() {
        return proofIndex;
    }

    public String getProofBaseText() {
        return proofBaseText;
    }

    public RealmList<ProofStuff> getProofStuff() {
        return proofStuff;
    }
}
