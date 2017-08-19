package com.example.keshavjoshi.nss_library;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Iterator;

public class book_details extends AppCompatActivity {
    DatabaseReference dref;
    TextView name;
    TextView name1;
    TextView code;
    TextView code1;
    TextView medium;
    TextView medium1;
    TextView status;
    TextView status1;
    Button issue;



    Context context=this;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        final TextView name= (TextView) findViewById(R.id.name);
        final TextView name1= (TextView) findViewById(R.id.name1);
        final TextView code= (TextView) findViewById(R.id.code);
        final TextView code1= (TextView) findViewById(R.id.code1);
        final TextView medium= (TextView) findViewById(R.id.medium);
       final TextView medium1= (TextView) findViewById(R.id.medium1);
        TextView status= (TextView) findViewById(R.id.status);
        final TextView status1= (TextView) findViewById(R.id.status1);
        final Button issue= (Button) findViewById(R.id.issue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
         x=getIntent().getExtras().getInt("key");

        final String y= (String) getIntent().getExtras().get("key1");

        if(y.equals("class1")) {
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS1");
        }else if(y.equals("class2")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS2");
        }else if(y.equals("class3")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS3");
        }else if(y.equals("class4")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS4");
        }else if(y.equals("class5")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS5");
        }else if(y.equals("class6")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS6");
        }else if(y.equals("class7")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS7");
        }else if(y.equals("class8")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS8");
        }else if(y.equals("class9")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS9");
        }else if(y.equals("class10")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS10");
        }else if(y.equals("class11")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS11");
        }else if(y.equals("class12")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS12");
        }else if(y.equals("class13")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS13");
        }else if(y.equals("class14")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS14");
        }else if(y.equals("class15")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS15");
        }else if(y.equals("class16")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS16");
        }
        dref.orderByChild("NO").equalTo(x+1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child :children) {
                    BOOK book = child.getValue(BOOK.class);
                    name1.setText(book.NAME());
                    code1.setText(book.CODE());
                    medium1.setText(book.MEDIUM());
                    status1.setText(book.STATUS());

                    if(book.STATUS().equals("ISSUED")){
                        issue.setEnabled(false);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

}
        });

        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(context,STUDENT_DETAIL.class);
                        intent1.putExtra("key",x);
                intent1.putExtra("key1",y);
                startActivity(intent1);
                finish();

            }
        });


        }

        }
