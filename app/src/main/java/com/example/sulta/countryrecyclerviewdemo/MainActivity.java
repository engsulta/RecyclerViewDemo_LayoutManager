package com.example.sulta.countryrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.sulta.countryrecyclerviewdemo.Model.Country;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    int[] myImageList = new int[]{R.drawable.download, R.drawable.paris,R.drawable.portogal,R.drawable.spain};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with

        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country("Egypt", myImageList[0]));
        countries.add(new Country("Paris",myImageList[1] ));
        countries.add(new Country("Spain" ,myImageList[3]));
        countries.add(new Country("Portogal" ,myImageList[2]));
        countries.add(new Country("France",myImageList[1] ));

        countries.add(new Country("France",myImageList[1] ));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position%3==0?2:1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new MyRecyclerViewAdapter(this, countries);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}
