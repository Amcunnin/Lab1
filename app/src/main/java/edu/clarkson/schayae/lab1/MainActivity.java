package edu.clarkson.schayae.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Button;
import java.util.ArrayList;
import android.view.View.*;


public class MainActivity extends AppCompatActivity {
    //declarations
    private RadioButton radioA;
    private RadioButton radioB;
    private Button saveButton;
    private EditText editMessage;
    private ListView entryList;
    private ArrayList<String> listA = new ArrayList<String>();
    private ArrayList<String> listB = new ArrayList<String>();
    private ArrayAdapter<String> adapterA;
    private ArrayAdapter<String> adapterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapping variables to controls
        radioA = (RadioButton) findViewById(R.id.radioA);
        radioB = (RadioButton) findViewById(R.id.radioB);
        adapterA = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listA);
        adapterB = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listB);
        saveButton = (Button) findViewById(R.id.saveButton);
        editMessage = (EditText) findViewById(R.id.editMessage);
        entryList = (ListView) findViewById(R.id.entryList);

        //set entryList adapter to adapterA by default
        entryList.setAdapter(adapterA);

        radioA.setChecked(true);

        saveButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              if (radioA.isChecked()) {
                                                  listA.add(editMessage.getText().toString());
                                                  adapterA.notifyDataSetChanged();
                                                  Log.d("ListA entry", (listA.get(listA.size()-1)));
                                              }
                                              else {
                                                  listB.add(editMessage.getText().toString());
                                                  adapterB.notifyDataSetChanged();
                                                  Log.d("ListB entry", (listB.get(listB.size()-1)));
                                              }
                                          }
                                      }
        );
    }

    public void onRadioButtonClicked(View view) {
        boolean checked =((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioA:
                if (checked) entryList.setAdapter(adapterA);
                break;
            case R.id.radioB:
                if (checked) entryList.setAdapter(adapterB);
                break;
        }
    }
}
