package com.burakdemir.multipleviewholder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;

import com.burakdemir.multipleviewholder.Adapter.UlkeAdapter;
import com.burakdemir.multipleviewholder.Model.Reklam;
import com.burakdemir.multipleviewholder.Model.Ulke;
import com.burakdemir.multipleviewholder.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    SearchView searchView;

    UlkeAdapter ulkeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        ulkeAdapter = new UlkeAdapter(this, Ulke.getUlkeler(), Reklam.getReklamlar());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(ulkeAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


}
