package com.example.liz.demorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity{
    List<String> name;
    List<Integer> image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        name = new ArrayList<>();
        name.add("Captain");
        name.add("Iron Man");
        name.add("Thor");
        name.add("Avenger");

        image = new ArrayList<>();
        image.add(R.drawable.captain);
        image.add(R.drawable.ironman);
        image.add(R.drawable.thor);
        image.add(R.drawable.avenger);
        RecyclerViewAdapter mRcvAdapter = new RecyclerViewAdapter(name, image);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRcvAdapter);

        mRcvAdapter.OnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(List<String> name, int position) {
                Toast.makeText(MainActivity.this, name.get(position)+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
