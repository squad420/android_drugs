package ru.encyclopatia.drugster228.realm;

import io.realm.RealmObject;

public class RealmString extends RealmObject {
    String val;

    public RealmString(String val) {
        this.val = val;
    }

    public RealmString() {

    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
