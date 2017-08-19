package com.example.keshavjoshi.nss_library;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp;
    TextView textView;
    Button button;
    ArrayAdapter<String> adapter;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button3);
        sp = (Spinner) findViewById(R.id.spinner);
        String[] string={"CLASS1","CLASS2","CLASS3","CLASS4","CLASS5","CLASS6","CLASS7","CLASS8","CLASS9","CLASS10","CLASS11","CLASS12","IIT-JEE","GK-CS","LANGUAGE AND GRAMMER","SANSKRIT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, string);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener( this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getSelectedItem().toString().equals("CLASS1")) {
                    String x="class1";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);

                } else if (sp.getSelectedItem().toString().equals("CLASS2")) {
                    String x="class2";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS3")) {
                    String x="class3";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS4")) {
                    String x="class4";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS5")) {
                    String x="class5";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS6")) {
                    String x="class6";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS7")) {
                    String x="class7";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS8")) {
                    String x="class8";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS9")) {
                    String x="class9";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS10")) {
                    String x="class10";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS11")) {
                    String x="class11";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("CLASS12")) {
                    String x="class12";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("IIT-JEE")) {
                    String x="class13";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("GK-CS")) {
                    String x="class14";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("LANGUAGE AND GRAMMER")) {
                    String x="class15";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }else if (sp.getSelectedItem().toString().equals("SANSKRIT")) {
                    String x="class16";
                    Intent intent=new Intent(context,Class1.class);
                    intent.putExtra("key",x);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
