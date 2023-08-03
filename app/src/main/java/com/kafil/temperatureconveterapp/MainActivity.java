package com.kafil.temperatureconveterapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private Button buttonConvertCelsius;
    private Button buttonConvertFahrenheit;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        buttonConvertCelsius = findViewById(R.id.buttonConvertCelsius);
        buttonConvertFahrenheit = findViewById(R.id.buttonConvertFahrenheit);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvertCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToFahrenheit();
            }
        });

        buttonConvertFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToCelsius();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        double temperature;
        try {
            temperature = Double.parseDouble(editTextTemperature.getText().toString());
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input");
            return;
        }

        double result = (temperature * 9 / 5) + 32;
        textViewResult.setText(String.format("%.2f °F", result));
    }

    private void convertFahrenheitToCelsius() {
        double temperature;
        try {
            temperature = Double.parseDouble(editTextTemperature.getText().toString());
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input");
            return;
        }

        double result = (temperature - 32) * 5 / 9;
        textViewResult.setText(String.format("%.2f °C", result));
    }
}
