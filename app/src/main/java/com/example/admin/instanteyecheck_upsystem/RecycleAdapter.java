

package com.example.admin.instanteyecheck_upsystem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by csa on 3/1/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<Historytable> dataModelArrayList;

    public RecycleAdapter(List<Historytable> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView dname,per;

        public Myholder(View itemView) {
            super(itemView);

            dname = (TextView) itemView.findViewById(R.id.dname);
            per= (TextView) itemView.findViewById(R.id.per);
            //country = (TextView) itemView.findViewById(R.id.country1);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
         return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        Historytable dataModel=dataModelArrayList.get(position);
        holder.dname.setText(dataModel.getHdname());
        holder.per.setText(String.valueOf(dataModel.getHpercent()));
        //holder.country.setText(dataModel.getCounty());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
