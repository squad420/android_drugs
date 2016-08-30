package ru.encyclopatia.drugster228.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import ru.encyclopatia.drugster228.R;
import ru.encyclopatia.drugster228.adapters.DrugAdapter;
import ru.encyclopatia.drugster228.model.Drug;
import ru.encyclopatia.drugster228.realm.RealmController;


public class SearchFragment extends Fragment {
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    Unbinder unbinder;
    DrugAdapter adapter;

    Realm realm;

    public SearchFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.realm = RealmController.with(this).getRealm();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpRecyclerView();
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                OrderedRealmCollection collection = realm.where(Drug.class).contains("name",
                        charSequence.toString()).findAll();
                adapter.updateData(collection);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

    private void setUpRecyclerView() {
        adapter = new DrugAdapter(getActivity(), realm.where(Drug.class).findAll(), true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
