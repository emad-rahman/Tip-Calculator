package com.example.emad.tipcalculator;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double bill;
    double tip;
    TextView textViewTotal;
    TextView textViewTip;
    EditText editTextBill;
    EditText editTextTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = 0.00;
        tip = 0.00;

        createEditTextBill();
        createEditTextTip();

        createTextViewTip();
        createTextViewTotal();

        createButtonCalculate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }






    private void createButtonCalculate() {
        Button button = (Button) findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValues();
            }
        });
    }

    private void updateValues() {
        if(editTextBill.getText().length() > 0 && editTextTip.getText().length() > 0){
            bill = Float.parseFloat(editTextBill.getText().toString());
            tip = Float.parseFloat(editTextTip.getText().toString());
        }

        double newTip = Calculator.calculateTip(bill, tip);
        double newTotal = Calculator.calculateTotal(bill, tip);
        String tipString = String.format(Locale.getDefault(), "Tip: $%.02f", newTip);
        String totalString = String.format(Locale.getDefault(), "Total: $%.02f", newTotal);
        textViewTip.setText(tipString);
        textViewTotal.setText(totalString);
    }

    private void createTextViewTotal() {
        TextView textView = (TextView) findViewById(R.id.textViewTotal);
        textViewTotal = textView;
        String tipString = "Total: $" + Double.toString(Calculator.calculateTotal(bill, tip));
        textView.setText(tipString);
    }

    private void createTextViewTip() {
        TextView textView = (TextView) findViewById(R.id.textViewTip);
        textViewTip = textView;
        String tipString = "Tip: $" + Double.toString(Calculator.calculateTip(bill, tip));
        textView.setText(tipString);
    }

    private void createEditTextBill() {
        EditText editText = (EditText) findViewById(R.id.editTextBill);
        editTextBill = editText;
        if(editText.getText().length() > 0){
            bill = Float.parseFloat(editText.getText().toString());
        }
    }

    private void createEditTextTip() {
        EditText editText = (EditText) findViewById(R.id.editTextTip);
        editTextTip = editText;
        if(editText.getText().length() > 0) {
            tip = Float.parseFloat(editText.getText().toString());
        }
    }
}
