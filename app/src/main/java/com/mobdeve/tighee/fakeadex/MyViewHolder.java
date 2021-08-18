package com.mobdeve.tighee.fakeadex;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTv, descriptionTv, locationTv, speciesTv;
    private ImageView imageIv;
    private Button deleteBtn;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.nameTv = itemView.findViewById(R.id.nameTv);
        this.descriptionTv = itemView.findViewById(R.id.descriptionTv);
        this.locationTv = itemView.findViewById(R.id.locationTv);
        this.speciesTv = itemView.findViewById(R.id.speciesTv);
        this.imageIv = itemView.findViewById(R.id.imageIv);
        this.deleteBtn = itemView.findViewById(R.id.deleteBtn);
    }

    public void setNameTv(String name) {
        this.nameTv.setText(name);
    }

    public void setDescriptionTv(String description) {
        this.descriptionTv.setText(description);
    }

    public void setLocationTv(String location) {
        this.locationTv.setText(location);
    }

    public void setSpeciesTv(String species) {
        this.speciesTv.setText(species);
    }

    public void setImageId(int imageId) {
        this.imageIv.setImageResource(imageId);
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        this.deleteBtn.setOnClickListener(onClickListener);
    }
}
