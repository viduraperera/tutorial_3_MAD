package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button okButton = (Button) findViewById(R.id.Okbutton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
                displayToast();
            }
        });
    }
    public void openSecondActivity(){
        EditText editNumberOne = (EditText) findViewById(R.id.NumberOneEdit);
        String text = editNumberOne.getText().toString();

        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
    public void displayToast(){
        Context context = getApplicationContext();
        CharSequence message = "You just clicked the OK button";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast .makeText(context, message, duration);
        //toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
        toast.show();
    }
}