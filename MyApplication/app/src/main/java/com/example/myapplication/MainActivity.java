package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            EditText redInput = (EditText) findViewById(R.id.editTextText3);
            EditText blueInput = (EditText) findViewById(R.id.editTextText4);
            EditText greenInput = (EditText) findViewById(R.id.editTextText5);
            View colorOutput = (View) findViewById(R.id.view2);
            TextView errorText = (TextView) findViewById(R.id.textView6);
            errorText.setVisibility(View.INVISIBLE);
            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(v -> updateColor(redInput, blueInput, greenInput, colorOutput, errorText));
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void updateColor(EditText redInput, EditText blueInput, EditText greenInput, View colorOutput, TextView errorText){
        Log.i("Text", "The Button has Generated the Color!");
        Log.i("Text", "The button has gotten the red value of " + redInput.getText().toString());

        String totalColor = "#" + redInput.getText().toString() + blueInput.getText().toString() + greenInput.getText().toString();
        try {
            Log.i("Text", "The complete color value is: " + totalColor);
            colorOutput.setBackgroundColor(Color.parseColor(totalColor));
            errorText.setVisibility(View.INVISIBLE);
            colorOutput.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Log.i("Text", "Could not generate color: " + totalColor);
            colorOutput.setVisibility(View.INVISIBLE);
            errorText.setVisibility(View.VISIBLE);
        }
    }
}