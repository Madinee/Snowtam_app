package com.example.snowtam.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snowtam.EncodingActivity;
import com.example.snowtam.R;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SnowtamListAdapter extends RecyclerView.Adapter<SnowtamListAdapter.ViewHolder> {

    private List<String> list;

    public SnowtamListAdapter(List<String> list) {
        this.list = list;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView oaciCode;
        private TextView airportName;


        public ViewHolder(View itemView) {
            super(itemView);
            oaciCode = (TextView) itemView.findViewById(R.id.oaciCode);
//            airportName = (TextView) itemView.findViewById(R.id.airportName);

        }

        public TextView getOaciCode() {
            return oaciCode;
        }



        public void setAll(final String location, final String stateName) {
           oaciCode.setText(location);
//           airportName.setText(stateName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), EncodingActivity.class);
                    intent.putExtra("location",location);
//                    intent.putExtra("stateName",stateName);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.snowtam_item_row, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getOaciCode().setText(list.get(position));

//        String location=list.get(position).getLocation();
//        String stateName=list.get(position).getStateName();
//        viewHolder.setAll(location, stateName);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}

