package com.zybooks.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText billEditText;
    private EditText percentEditText;
    private TextView tipTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign the widgets to class variables
        billEditText = (EditText) findViewById(R.id.billEditText);
        percentEditText = (EditText) findViewById(R.id.tipEditText);
        tipTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalTextView = (TextView) findViewById(R.id.totalAmountTextView);
    }

    public void calculateClick(View view){

        // Get the text that was typed into the EditTexts
        String billStr = billEditText.getText().toString();
        String percentStr = percentEditText.getText().toString();

        //Use a try‐catch to catch a NumberFormatException that is thrown 
        // by Float.parseFloat() when parsing an empty string. 
        try {

            // Convert the texts into floats
            Float billAmt = Float.parseFloat(billStr);
            Float percentAmt = Float.parseFloat(percentStr);
            percentAmt/=100;

            //determine the tip given the bill and the percentage
            Float tipAmt = billAmt * percentAmt;

            //determine the total
            Float totalAmt = billAmt + tipAmt;

            //convert floats into money formatted strings
            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
            String tipAmtStr = moneyFormat.format(tipAmt);
            String totalAmtStr = moneyFormat.format(totalAmt);

            //display the results
            tipTextView.setText(tipAmtStr);
            totalTextView.setText(totalAmtStr);

        }
        catch(NumberFormatException e){

            //Display a toast message when the exception is thrown.
            Toast.makeText(this, "Please enter numbers for bill and tip percent.",
                    Toast.LENGTH_SHORT).show();
            //clear out the tip amount and total values if the 
            //exception is thrown.
            tipTextView.setText("");
            totalTextView.setText("");

        }
    }
}
