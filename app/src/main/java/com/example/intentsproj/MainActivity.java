package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NUMBER_ONE = "com.example.intentsproj.EXTRA_NUMBER_ONE";
    public static final String EXTRA_NUMBER_TWO = "com.example.intentsproj.EXTRA_NUMBER_TWO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();

        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_layout));

        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        String firstNumber = editNumberOne.getText().toString();

        EditText editNumberTwo = (EditText) findViewById(R.id.NumberTwoEdit);
        String secondNumber = editNumberTwo.getText().toString();

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra(EXTRA_NUMBER_ONE, firstNumber);
        i.putExtra(EXTRA_NUMBER_TWO, secondNumber);
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