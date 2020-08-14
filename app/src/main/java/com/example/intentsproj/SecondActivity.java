package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int no1, no2, answer;
    String textViewAnswer;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Intent i = getIntent();
        String numberOne = i.getStringExtra(MainActivity.EXTRA_NUMBER_ONE);
        String numberTwo = i.getStringExtra(MainActivity.EXTRA_NUMBER_TWO);

        result = findViewById(R.id.final_result);
        TextView updatedOne = (TextView) findViewById(R.id.numberOneUpdated);
        TextView updatedTwo = (TextView) findViewById(R.id.numberTwoUpdated);

        no1 = Integer.parseInt(numberOne);
        no2 = Integer.parseInt(numberTwo);

        updatedOne.setText(numberOne);
        updatedTwo.setText(numberTwo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button plusButton = (Button) findViewById(R.id.plus);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer = no1 + no2;
                textViewAnswer = String.valueOf(answer);
                result.setText(no1 + " + " + no2 + " = " + answer);
            }
        });

    }
}