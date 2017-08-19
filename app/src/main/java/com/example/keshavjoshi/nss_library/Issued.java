package com.example.keshavjoshi.nss_library;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Issued extends AppCompatActivity {
     TextView text;
    Context context=this;
    ListView list;
    DatabaseReference dref;
    final ArrayList<String> childrens = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued);
        text=(TextView)findViewById(R.id.textView3);
        list=(ListView)findViewById(R.id.listissued);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, childrens);
        list.setAdapter(adapter);

        dref= FirebaseDatabase.getInstance().getReference().child("issue");
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot child :children) {
                    ISSUED_BOOK book=child.getValue(ISSUED_BOOK.class);
                    childrens.add(book.NAME());
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a=list.getItemAtPosition(position).toString();
                Intent intent=new Intent(context,issued_book_detail.class);
                intent.putExtra("key",a);
                startActivity(intent);
                finish();


            }
        });

    }
}
