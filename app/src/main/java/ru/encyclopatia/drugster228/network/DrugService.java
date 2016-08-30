package ru.encyclopatia.drugster228.network;

import java.util.List;

import retrofit2.http.GET;
import ru.encyclopatia.drugster228.network.responce.DrugResponce;
import rx.Observable;


public interface DrugService {
    String SERVICE_ENDPOINT = "https://drugster.herokuapp.com";

    @GET("/all")
    Observable<List<DrugResponce>> getDrugs();
}
