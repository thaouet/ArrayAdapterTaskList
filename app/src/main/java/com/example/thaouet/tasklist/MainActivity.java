package com.example.thaouet.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listeDesTaches;
    List<String> listeDesValeurs ;
    ArrayAdapter<String> adapter;
    Button ajouterTacheButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeDesValeurs = new ArrayList<String>();
        listeDesValeurs.add("Cours HTML");
        listeDesValeurs.add("Body Pump");
        listeDesValeurs.add("Cinema");
        listeDesValeurs.add("Cours HTML");
        listeDesValeurs.add("Body Pump");
        listeDesValeurs.add("Cinema");
        listeDesValeurs.add("Cours HTML");
        listeDesValeurs.add("Body Pump");
        listeDesValeurs.add("Cinema");
        listeDesValeurs.add("Cours HTML");
        listeDesValeurs.add("Body Pump");
        listeDesValeurs.add("Cinema");
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,listeDesValeurs);
        listeDesTaches = (ListView)findViewById(R.id.list);
        listeDesTaches.setAdapter(adapter);
        ajouterTacheButton =(Button)findViewById(R.id.AjouterButton);
        ajouterTacheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(MainActivity.this,EditTask.class);
                startActivityForResult(i,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String task=data.getStringExtra("task");
            adapter.add(task);
            adapter.notifyDataSetChanged();
        }

    }


    public void SupprimerButtonClick(View view)
    {
        SparseBooleanArray checkedItemPositions = listeDesTaches.getCheckedItemPositions();
        int itemCount = listeDesTaches.getCount();

        for(int i=itemCount-1; i >= 0; i--){
            if(checkedItemPositions.get(i)){
                adapter.remove(listeDesValeurs.get(i));
            }
        }
        checkedItemPositions.clear();
        adapter.notifyDataSetChanged();
    }




}
