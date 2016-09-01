package edu.clarkson.schayae.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listA = new ArrayList<String>();
    ArrayList<String> listB = new ArrayList<String>();
    ArrayAdapter<String> adapterA;
    ArrayAdapter<String> adapterB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
