package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TopUpActivity extends AppCompatActivity {
    TextView saldoNow;
    EditText inputSaldo;
    private CardView paytopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        saldoNow = (TextView) findViewById(R.id.angkaSaldo);
        inputSaldo = (EditText) findViewById(R.id.inputSaldo);
        paytopUp = (CardView) findViewById(R.id.payTopup);

        paytopUp.setOnClickListener(new View.OnClickListener() {
            Integer no1, no2 = 0;

            @Override
            public void onClick(View v) {

                try {
                    no1 = Integer.parseInt(saldoNow.getText().toString());
                    no2 = Integer.parseInt(inputSaldo.getText().toString());
                } catch(NumberFormatException nfe) {

                }

                Integer sum = no1 + no2;
                no2 = 0;
                saldoNow.setText(sum.toString());
                inputSaldo.setText("");
            }
        });
    }
}