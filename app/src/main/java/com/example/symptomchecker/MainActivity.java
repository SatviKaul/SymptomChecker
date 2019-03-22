package com.example.symptomchecker;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.EditText;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private static final String[] SYMPTOMS=new String[]{"Abdominal pain", "Blood in stool",
            "Chest pain",
            "Constipation",
            "Cough",
            "Diarrhea",
            "Difficulty swallowing",
            "Dizziness",
            "Eye discomfort and redness",
            "Eye problems",
            "Foot pain or ankle pain",
            "Foot swelling or leg swelling",
            "Headaches",
            "Heart palpitations",
            "Hip pain",
            "Knee pain",
            "Low back pain",
            "Nasal congestion",
            "Nausea or vomiting",
            "Neck pain",
            "Numbness or tingling in hands",
            "Pelvic pain",
            "Shortness of breath",
            "Shoulder pain",
            "Sore throat",
            "Urinary problems",
            "Wheezing"
    };

    ArrayAdapter<String> Adapter;
    ArrayList<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = (ListView) findViewById(R.id.lv);
        final Button btn = (Button) findViewById(R.id.btn);

        final String[] symptoms = getResources().getStringArray(R.array.symptoms);
        final AutoCompleteTextView editText = findViewById(R.id.actv);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, SYMPTOMS);
        Adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        editText.setAdapter(adapter);
        lv.setAdapter(Adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List
                EditText edit = (EditText) findViewById(R.id.actv);
                /*if( edit.getText().toString().length() <= 3 )
                    edit.setError( "A Symptom is Required !" );*/

                boolean contains = false;

                //iterate the String array
                for(int i=0; i < SYMPTOMS.length; i++){

                    //check if string array contains the string
                    if(SYMPTOMS[i].equals(edit.getText().toString())){
                        contains = true;
                        break;
                    }
                }
                if(contains) {
                    list.add(edit.getText().toString());
                    edit.setText("");
                }
                else if ( edit.getText().toString().length()==0) {
                    edit.setError("A Symptom is Required !");
                }
                else if(edit.getText().toString().length()>0 && edit.getText().toString().length() <=3){
                    edit.setError("Incomplete Symptom");
                }
                 else{
                     edit.setError( "Invalid Symptom!" );
                 }
                /* notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */
                adapter.notifyDataSetChanged();
                Adapter.notifyDataSetChanged();
        //editText.setThreshold(1);

        //get the input like for a normal EditText
        //String input = editText.getText().toString();
    }
});}
    }
