package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView result_bill, result_tip, result_total;
    Button calculate_button;
    EditText edit_tip;
    double bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_bill = findViewById(R.id.result_bill);
        result_tip = findViewById(R.id.result_tip);
        result_total = findViewById(R.id.result_total);
        calculate_button = findViewById(R.id.calculate_button);
        edit_tip = findViewById(R.id.edit_tip);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double billResult = calculateTip();
                displayResult(billResult);
            }
        });

    }

    private double calculateTip() {
        String billToCalculate = edit_tip.getText().toString();
        bill  =  Integer.parseInt(billToCalculate) * 1.0;
        return bill * 1.15;
    }
    private void displayResult(double billResult){
        DecimalFormat mydecimal = new DecimalFormat("0.00");
        String resultTotal = mydecimal.format(billResult);
        String resultBill =  mydecimal.format(bill);
        String resultTip = mydecimal.format(billResult-bill);

        result_bill.setText("Bill: " + resultBill);
        result_tip.setText("Tip: " +resultTip);
        result_total.setText("Total: " +resultTotal);

    }
}