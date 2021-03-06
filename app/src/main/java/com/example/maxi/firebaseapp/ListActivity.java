package com.example.maxi.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText etFamiliar;
    private ListView listView;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnAdd = findViewById(R.id.btnAdd);
        etFamiliar = findViewById(R.id.etFamiliar);
        listView = findViewById(R.id.listView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users").child(user.getUid()).child("familiares");
        Query query = myRef.orderByValue();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot value : dataSnapshot.getChildren()) {
                    list.add(value.getValue(String.class));
                }
                listView.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, list));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = etFamiliar.getText().toString();
                myRef.push().setValue(s);
            }
        });
    }
}
