package com.example.parcelbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private EditText fname,lname,edAddress,edcity;
    private Button btnSubmit;
    DatabaseReference databaseReference;
    long maxId=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("intro");

        setContentView(R.layout.activity_main);
        fname=findViewById(R.id.firstName);
        lname=findViewById(R.id.lastName);
        edAddress=findViewById(R.id.address);
        edcity=findViewById(R.id.city);
        btnSubmit=findViewById(R.id.btnSubmit);

        Intro intro = new Intro();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                    maxId =(dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIntros();


            }
        });
    }
    public void addIntros(){

           String efirstName=fname.getText().toString();
           String elastName=lname.getText().toString();
           String eAddress=edAddress.getText().toString();
           String eCity=edcity.getText().toString();


        if (!TextUtils.isEmpty(efirstName) && !TextUtils.isEmpty(elastName)  && !TextUtils.isEmpty(eAddress) && !TextUtils.isEmpty(eCity)){


               Intro intros = new Intro(efirstName,elastName,eAddress,eCity);
               databaseReference.child(String.valueOf(maxId+1)).setValue(intros);
               fname.setText("");
               lname.setText("");
               edAddress.setText("");
               edcity.setText("");



        }
           else {
               Toast.makeText(MainActivity.this, "Enter the required field ", Toast.LENGTH_LONG).show();
           }
    }
}
