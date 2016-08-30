package ru.encyclopatia.drugster228.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import ru.encyclopatia.drugster228.R;
import ru.encyclopatia.drugster228.model.Drug;

public class DrugAdapter extends RealmRecyclerViewAdapter<Drug, DrugAdapter.ViewHolder> {
    public DrugAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Drug> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_drug, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public void updateData(@Nullable OrderedRealmCollection<Drug> data) {
        super.updateData(data);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text_name)
        TextView textName;

        Drug drug;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(Drug drug) {
            this.drug = drug;
            textName.setText(drug.getName());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, drug.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
