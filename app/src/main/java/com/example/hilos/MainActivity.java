package com.example.hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView errorMessage;
    private boolean isDataValid(String userInput){
        boolean isValid;
        try {
            int inputValue = Integer.parseInt(userInput);
            isValid = inputValue > 0 && inputValue <= 60;
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;

    }
    public static final String VALUE_EXTRA = "VALUE_EXTRA";

    public void startButton(View view) {
        String userInput = input.getText().toString();
        if (isDataValid(userInput)) {
            errorMessage.setVisibility(View.GONE);
            Intent intent = new Intent(this, CountDownActivity.class);
            intent.putExtra(VALUE_EXTRA, userInput);
            startActivity(intent);
        } else {
            errorMessage.setVisibility(View.VISIBLE);
        }
    }

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    input = findViewById(R.id.input);
    errorMessage = findViewById(R.id.errorMessage);
}
}
