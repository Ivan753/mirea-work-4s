package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.lab1.adapter.CardAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView cardRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        cardRecyclerView = findViewById(R.id.card_recycler_view);
        CardAdapter adapter = new CardAdapter(1000000);
        cardRecyclerView.setAdapter(adapter);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
