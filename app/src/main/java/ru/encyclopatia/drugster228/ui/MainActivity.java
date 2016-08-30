package ru.encyclopatia.drugster228.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import ru.encyclopatia.drugster228.R;
import ru.encyclopatia.drugster228.Utils;
import ru.encyclopatia.drugster228.model.Drug;
import ru.encyclopatia.drugster228.realm.RealmController;
import ru.encyclopatia.drugster228.network.DrugService;
import ru.encyclopatia.drugster228.network.ServiceFactory;
import ru.encyclopatia.drugster228.network.responce.DrugResponce;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    DrugService service;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.realm = RealmController.with(this).getRealm();
        service = ServiceFactory.createRetrofitService(DrugService.class, DrugService.SERVICE_ENDPOINT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refreshDB();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshDB() {
        RealmController.getInstance().clearAll();
        service.getDrugs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<List<DrugResponce>, Observable<DrugResponce>>() {
                    @Override
                    public Observable<DrugResponce> call(List<DrugResponce> drugResponces) {
                        return Observable.from(drugResponces);
                    }
                })
                .subscribe(new Subscriber<DrugResponce>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Narkotiki updated", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.Log("Error : " + e.getMessage());
                    }

                    @Override
                    public void onNext(final DrugResponce drugResponce) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                Drug rDrug = new Drug(drugResponce);
                                realm.copyToRealmOrUpdate(rDrug);
                            }
                        });
                        Utils.Log("Drug name : " + drugResponce.getName());
                    }
                });
    }
}
