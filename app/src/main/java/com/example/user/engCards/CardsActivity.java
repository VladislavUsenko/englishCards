package com.example.user.engCards;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;


public class CardsActivity extends AppCompatActivity {

    private RecyclerView rv;
    private CardRVAdapter rvAdapter;
    private String categoryName;

    private List<Card> cards;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);



        Intent intent = getIntent();
        categoryName = intent.getStringExtra("CategoryName");

        getSupportActionBar().setTitle(categoryName);

        cards = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference();

        rv = findViewById(R.id.card_list);
        rvAdapter = new CardRVAdapter(cards);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rv);

        LinearLayoutManager llm = new LinearLayoutManager(this) ;
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();

    }

    private void initializeData(){

        mReference.child(categoryName).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Card card = dataSnapshot.getValue(Card.class);
                cards.add(card);

                rvAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}