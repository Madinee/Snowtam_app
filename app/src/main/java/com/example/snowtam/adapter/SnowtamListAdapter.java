package com.example.snowtam.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowtam.EncodingActivity;
import com.example.snowtam.R;
import com.example.snowtam.service.data.Snowtam;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SnowtamListAdapter extends RecyclerView.Adapter<SnowtamListAdapter.ViewHolder> {

    private List<Snowtam> list;

    public SnowtamListAdapter(List<Snowtam> list) {
        this.list = list;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView oaciCode;
        private TextView airportName;
        private View itemView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            oaciCode = (TextView) itemView.findViewById(R.id.oaciCode);
            airportName = (TextView) itemView.findViewById(R.id.airportName);

        }

    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.snowtam_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

//        String location=list.get(position).getLocation();
//        String stateName=list.get(position).getStateName();

        final Snowtam snowtam=list.get(position);
        viewHolder.oaciCode.setText(snowtam.getLocation());
        viewHolder.airportName.setText(snowtam.getStateName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(viewHolder.itemView.getContext(), EncodingActivity.class);
                    intent.putExtra("all",snowtam.getAll());
                    intent.putExtra("location", snowtam.getLocation());
                    intent.putExtra("StateName", snowtam.getStateName());  System.out.println(snowtam.getId());
                    
                    viewHolder.itemView.getContext().startActivity(intent);
                }
            });
//        viewHolder.setAll(location, stateName);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}

