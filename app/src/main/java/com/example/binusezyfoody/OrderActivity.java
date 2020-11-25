package com.example.binusezyfoody;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    ImageView imageView;
    TextView title, price, orderTitle;
    EditText inputQty;
    private ImageButton myorderButton;
    Button buyButton, oMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        orderTitle = findViewById(R.id.textOrder);
        imageView = findViewById(R.id.imageOrder);
        title = findViewById(R.id.titleOrder);
        price = findViewById(R.id.priceOrder);
        inputQty = findViewById(R.id.inputQty);

        myorderButton = (ImageButton) findViewById(R.id.myOrderButton);
        myorderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });

        String oTitle ="", oPrice ="", oText = "";

        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            oTitle = bundle.getString("title");
            oPrice = bundle.getString("price");
            oText = bundle.getString("titleOrder");
        }
        int oPic = bundle.getInt("image");

        orderTitle.setText("Order " + oText);
        imageView.setImageResource(oPic);
        title.setText(oTitle);
        price.setText("Rp. " + oPrice);

        String myoTitle = oTitle;
        String myoPrice = oPrice;

        buyButton = (Button) findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, MyOrderActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image1", oPic);
                intent.putExtras(bundle);
                intent.putExtra("title1", myoTitle);
                intent.putExtra("price1", myoPrice);
                intent.putExtra("quantity1", inputQty.getText().toString());
                startActivity(intent);
            }
        });

        oMoreButton = (Button) findViewById(R.id.oMoreButton);
        oMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;

                if (bundle.getString("titleOrder").equals("Drink")) {
                    intent1 = new Intent(OrderActivity.this, DrinksActivity.class);
                    startActivity(intent1);
                } else if (bundle.getString("titleOrder").equals("Snack")) {
                    intent1 = new Intent(OrderActivity.this, SnacksActivity.class);
                    startActivity(intent1);
                } else if (bundle.getString("titleOrder").equals("Food")) {
                    intent1 = new Intent(OrderActivity.this, FoodsActivity.class);
                    startActivity(intent1);
                }
            }
        });
    }
}