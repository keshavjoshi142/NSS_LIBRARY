package com.example.keshavjoshi.nss_library;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Class1 extends AppCompatActivity {
    EditText search;
    ListView listView;
    final ArrayList<String> childrens = new ArrayList<String>();
    DatabaseReference dref;
    ArrayAdapter<String> adapter;
    Context context=this;
    TextView text;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, childrens);
        progress = ProgressDialog.show(this, "Loading...",
                "Loading Your Books....", true);
        getWindow().setBackgroundDrawableResource(R.drawable.canstockphoto_csp24598110);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        text=(TextView)findViewById(R.id.text);
        search=(EditText) findViewById(R.id.editText2);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        final String x= (String) getIntent().getExtras().get("key");
        if(x.equals("class1")) {
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS1");
        }else if(x.equals("class2")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS2");
        }else if(x.equals("class3")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS3");
        }else if(x.equals("class4")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS4");
        }else if(x.equals("class5")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS5");
        }else if(x.equals("class6")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS6");
        }else if(x.equals("class7")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS7");
        }else if(x.equals("class8")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS8");
        }else if(x.equals("class9")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS9");
        }else if(x.equals("class10")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS10");
        }else if(x.equals("class11")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS11");
        }else if(x.equals("class12")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS12");
        }else if(x.equals("class13")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS13");
        }else if(x.equals("class14")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS14");
        }else if(x.equals("class15")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS15");
        }else if(x.equals("class16")){
            dref = FirebaseDatabase.getInstance().getReference().child("CLASS16");
        }

            dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child :children) {
                    BOOK book=child.getValue(BOOK.class);
                    childrens.add(book.NAME());
                }
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Class1.this.adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });



        new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    Thread.sleep(5000);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String a=listView.getItemAtPosition(position).toString();

                            int y=childrens.indexOf(a);


                            Intent intent1=new Intent(context,book_details.class);
                            intent1.putExtra("key",y);

                            intent1.putExtra("key1",x);

                            startActivity(intent1);


                        }
                    });



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        progress.dismiss();
                    }
                });
            }
        }).start();

    }

}

