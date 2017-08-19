package com.example.keshavjoshi.nss_library;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class STUDENT_DETAIL extends AppCompatActivity {
        EditText name;
    EditText Class;
    DatabaseReference dref;
    Button but;
    DatePickerDialog datePickerDialog;
    final String[] Date = new String[1];
    int x;
    Button sdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__detail);
        name=(EditText)findViewById(R.id.name);
        Class=(EditText)findViewById(R.id.class1);
        but=(Button)findViewById(R.id.button);
        sdate=(Button)findViewById(R.id.button5);
        String y= (String) getIntent().getExtras().get("key1");
        getWindow().setBackgroundDrawableResource(R.drawable.k2ec7b3bda4cbecee9d752ce32d1755f7_searchlibrarycatalogpicuresofbooks_353308);
getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

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
        sdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(STUDENT_DETAIL.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                for(int i=1;i<10;i++) {
                                    if (monthOfYear+1==i){
                                        Date[0] = (dayOfMonth + "/"+"0"
                                                + (monthOfYear + 1) + "/" + year);
                                        break;
                                    }
                                    else{

                                        Date[0] = (dayOfMonth + "/"+
                                                + (monthOfYear + 1) + "/" + year);
                                    }
                                }
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }

        });

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=getIntent().getExtras().getInt("key");
         final String NAME= name.getText().toString();
                final String CLASS=Class.getText().toString();
                dref.orderByChild("NO").equalTo(x+1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children=dataSnapshot.getChildren();
                        for(DataSnapshot child:children){
                            BOOK book=child.getValue(BOOK.class);
                            String Class=book.CLASS();

                            String Status=book.STATUS();
                            String Code=book.CODE();
                            String Name=book.NAME();
                            String Medium=book.MEDIUM();
                            long No=book.NO();
                            String NoS=Long.toString(No);

                            DatabaseReference dref1= FirebaseDatabase.getInstance().getReference().child("issue");
                            final Map<String, String> userdata = new HashMap<String, String>();

                            userdata.put("stu_Name", NAME);
                            userdata.put("stu_Class", CLASS);
                            userdata.put("CLASS", Class);
                            userdata.put("STATUS", Status);
                            userdata.put("CODE", Code);
                            userdata.put("NAME", Name);
                            userdata.put("MEDIUM", Medium);
                            userdata.put("NO", NoS);
                            userdata.put("DATE",Date[0]);



                            dref1.push().setValue(userdata);

                            dref.orderByChild("NO").equalTo(x+1).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                                        child.getRef().child("STATUS").setValue("ISSUED");
                                    }

                                    }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }
                                }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }


                });
                Toast.makeText(STUDENT_DETAIL.this, "THIS BOOK IS ISSUED SUCCESSFULLY....", Toast.LENGTH_LONG).show();
                but.setEnabled(false);
            }
        });
    }
}
