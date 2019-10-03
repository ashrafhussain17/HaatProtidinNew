package com.ne.csedu.haatprotidinnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SearchPage extends AppCompatActivity {
    String[] locationOptions = {"None","dasd","dasdasda","aswq"};
    String[] typeOptions = {"None","dasd111","dasdasda","aswq"};
    String[] colorOptions = {"None","dasd222","dasdasda","aswq","sadasdas"};
    int count;
    int index,userIndex;
    Context context;
    Intent intent = new Intent(this,SearchPage.class);

    ArrayList<String> currentFilters = new ArrayList<>();

    private RecyclerView htRecyclerView;
    private HorTagRecyclerViewAdapter htAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);


        //hortag start
        htRecyclerView = findViewById(R.id.hor_tag_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        htRecyclerView.setLayoutManager(layoutManager);

        htAdapter = new HorTagRecyclerViewAdapter(currentFilters,this);
        htRecyclerView.setAdapter(htAdapter);


        EditText edittextsearch = findViewById(R.id.etSearchtext);

        Switch Filterbutton =  findViewById(R.id.Filter);
        final Spinner editlocation = findViewById(R.id.etlocation);
        final TextView locationLabel =findViewById(R.id.tvlocation);
        final Spinner edittype = findViewById(R.id.ettype);
        final TextView typeLabel = findViewById(R.id.tvtype);
        final Spinner editcolor = findViewById(R.id.etcolor);
        final TextView colorLabel = findViewById(R.id.tvcolor);


        editlocation.setVisibility(View.GONE);
        locationLabel.setVisibility(View.GONE);

        edittype.setVisibility(View.GONE);
        typeLabel.setVisibility(View.GONE);

        editcolor.setVisibility(View.GONE);
        colorLabel.setVisibility(View.GONE);



        count = 0;

        currentFilters = getIntent().getStringArrayListExtra("currentFilters");
        if(currentFilters == null) currentFilters = new ArrayList<>();
        Collections.sort(currentFilters);
        index = currentFilters.size();

        Filterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch radioButton = (Switch) view;
                if (radioButton.isChecked()) {
                        editlocation.setVisibility(View.VISIBLE);
                        locationLabel.setVisibility(View.VISIBLE);

                        edittype.setVisibility(View.VISIBLE);
                        typeLabel.setVisibility(View.VISIBLE);

                        editcolor.setVisibility(View.VISIBLE);
                        colorLabel.setVisibility(View.VISIBLE);

                        count=1;
                }
                else if(!radioButton.isChecked()){
                    radioButton.setChecked(false);
                    editlocation.setVisibility(View.GONE);
                    locationLabel.setVisibility(View.GONE);

                    edittype.setVisibility(View.GONE);
                    typeLabel.setVisibility(View.GONE);

                    editcolor.setVisibility(View.GONE);
                    colorLabel.setVisibility(View.GONE);

                    count =0;
                }
            }
        });

        //LOCATION ER JONNO EKHAN THEKE ADAPTER BANANO SHURU
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,locationOptions);
        // Specify layout to be used when list of choices appears
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        editlocation.setAdapter(locationAdapter);
        editlocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchPage.this, locationOptions[position] + " selected", Toast.LENGTH_SHORT).show();
                currentFilters.add(locationOptions[position]);
                intent.putExtra("currentFilters",currentFilters);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //TYPE ER JONNO EKHAN THEKE
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,typeOptions);
        // Specify layout to be used when list of choices appears
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        edittype.setAdapter(typeAdapter);

        edittype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchPage.this, typeOptions[position] + " selected", Toast.LENGTH_SHORT).show();
                currentFilters.add(locationOptions[position]);
                intent.putExtra("currentFilters",currentFilters);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //COLOR ER JONNO EKHAN THEKE
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colorOptions);
        // Specify layout to be used when list of choices appears
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        editcolor.setAdapter(colorAdapter);

        editcolor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchPage.this, colorOptions[position] + " selected", Toast.LENGTH_SHORT).show();
                currentFilters.add(locationOptions[position]);
                intent.putExtra("currentFilters",currentFilters);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
