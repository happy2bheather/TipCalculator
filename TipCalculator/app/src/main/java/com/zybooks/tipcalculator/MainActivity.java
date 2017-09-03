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
    private TipCalculatorModel model = new TipCalculatorModel();

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
            //Float bill=Float.parseFloat(billStr);
            model.setBill(Float.parseFloat(billStr));
            //Float percent=Float.parseFloat(percentStr);
            model.setPercentage(Float.parseFloat(percentStr));

            //convert floats into money formatted strings
            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
            String tipAmtStr = moneyFormat.format(model.getTip());
            String totalAmtStr = moneyFormat.format(model.getTotal());

            //display the results
            tipTextView.setText(tipAmtStr);
            totalTextView.setText(totalAmtStr);

        }
        catch(NumberFormatException e){

            //Display a toast message when the exception is thrown.
            String errorMsg = getResources().getString(R.string.error);
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

            //clear out the tip amount and total values if the 
            //exception is thrown.
            tipTextView.setText("");
            totalTextView.setText("");
        }
    }
}
