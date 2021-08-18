package com.mobdeve.tighee.fakeadex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<PokemonModel> data;

    public MyAdapter(ArrayList<PokemonModel> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Pass data into the ViewHolder using the defined setters
        holder.setNameTv(data.get(position).getName());
        holder.setDescriptionTv(data.get(position).getDesc());
        holder.setLocationTv(data.get(position).getLocation());
        holder.setSpeciesTv(data.get(position).getSpecie());
        holder.setImageId(data.get(position).getImageId());
        // Give the delete button logic (Toast + delete data + update view)
        // OnClickListener is defined here so that it has access to the data and passed into the ViewHolder
        holder.setDeleteOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inform the user of the deleted element
                Toast.makeText(
                        view.getContext(), // or holder.itemView.getContext()
                        data.get(position).getName() + " has been deleted.",
                        Toast.LENGTH_SHORT
                ).show();
                // Remove the element from the data (i.e. ArrayList)
                data.remove(position);
                // Inform the adapter class that the data has changed
                notifyDataSetChanged(); // This forces the RecyclerView to update
                // Without the previous line, the view won't update despite the data changing
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
