package com.example.keshavjoshi.nss_library;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class issued_book_detail extends AppCompatActivity {
    TextView bname;
    TextView bclass;
    TextView bcode;
    TextView sname;
    TextView sclass;
    TextView sdate;
    DatabaseReference dref;
    DatabaseReference dref1;
    Button back;
    Context context=this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_book_detail);
        bname=(TextView)findViewById(R.id.textView10);
        bclass=(TextView)findViewById(R.id.textView11);
        bcode=(TextView)findViewById(R.id.textView12);
        sname=(TextView)findViewById(R.id.textView13);
        sdate=(TextView)findViewById(R.id.textView14);
        sclass=(TextView)findViewById(R.id.textView15);
        back=(Button)findViewById(R.id.button4);
        final String n= (String) getIntent().getExtras().get("key");
        dref= FirebaseDatabase.getInstance().getReference().child("issue");
        dref.orderByChild("NAME").equalTo(n).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child :children) {
                    ISSUED_BOOK book=child.getValue(ISSUED_BOOK.class);
                   bname.setText(book.NAME());
                    bclass.setText(book.CLASS());
                    bcode.setText(book.CODE());
                    sname.setText(book.stu_Name());
                    sclass.setText(book.stu_Class());
                    sdate.setText(book.DATE());

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dref.orderByChild("NAME").equalTo(n).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren())
                            child.getRef().setValue(null);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                Toast.makeText(context, "BOOK IS PLACED BACK IN SHELF SUCESSFULLY", Toast.LENGTH_LONG).show();
                if (bclass.getText().toString().equals("1st")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS1");
                } else if (bclass.getText().toString().equals("2nd")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS2");
                } else if (bclass.getText().toString().equals("3rd")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS3");
                } else if (bclass.getText().toString().equals("4th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS4");
                } else if (bclass.getText().toString().equals("5th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS5");
                } else if (bclass.getText().toString().equals("6th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS6");
                } else if (bclass.getText().toString().equals("7th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS7");
                } else if (bclass.getText().toString().equals("8th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS8");
                } else if (bclass.getText().toString().equals("9th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS9");
                } else if (bclass.getText().toString().equals("10th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS10");
                } else if (bclass.getText().toString().equals("11th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS11");
                } else if (bclass.getText().toString().equals("12th")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS12");
                } else if (bclass.getText().toString().equals("IIT")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS13");
                } else if (bclass.getText().toString().equals("GK-CS")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS14");
                } else if (bclass.getText().toString().equals("LANGUAGE AND GRAMMER")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS15");
                } else if (bclass.getText().toString().equals("")) {
                    dref1 = FirebaseDatabase.getInstance().getReference().child("CLASS16");
                }
                dref1.orderByChild("NAME").equalTo(bname.getText().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            child.getRef().child("STATUS").setValue("AVAILABLE");

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                back.setEnabled(false);


            }
        });


        }
    }

