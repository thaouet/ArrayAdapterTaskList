package com.example.thaouet.tasklist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTask extends AppCompatActivity {

    EditText task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        task = (EditText)findViewById(R.id.taskEditText);
    }

    public  void ValiderButtonClick(View view)
    {
        String resultat = task.getText().toString();

        Intent returnIntent = new Intent();
        returnIntent.putExtra("task",resultat);
        setResult(Activity.RESULT_OK, returnIntent);

        finish();
    }
}
