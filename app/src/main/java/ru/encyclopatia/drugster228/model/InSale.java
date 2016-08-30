package ru.encyclopatia.drugster228.model;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InSale extends RealmObject {
    @PrimaryKey
    private int id;

    private String name;
    private int price;

    public InSale(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public InSale() {
    }

    public static RealmList<InSale> getRealmInSale(ArrayList<InSale> inSales) {
        RealmList<InSale> rInSales = new RealmList<InSale>();
        for (InSale inSale : inSales
                ) {
            rInSales.add(inSale);
        }
        return rInSales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
