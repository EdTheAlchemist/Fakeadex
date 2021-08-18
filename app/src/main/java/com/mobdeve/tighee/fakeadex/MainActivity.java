package com.mobdeve.tighee.fakeadex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        this.recyclerView = findViewById(R.id.myRecyclerView);

        // Set the adapter (logic has been compressed into one line)
        this.recyclerView.setAdapter(new MyAdapter(DataHelper.load_data()));

        // Create a LinearLayoutManager with a horizontal orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // Set the LayoutManager
        this.recyclerView.setLayoutManager(linearLayoutManager);

        // This next code snippet ensures that scroller snaps in place instead of being free position
        // Taken from https://stackoverflow.com/questions/29134094/recyclerview-horizontal-scroll-snap-in-center
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}