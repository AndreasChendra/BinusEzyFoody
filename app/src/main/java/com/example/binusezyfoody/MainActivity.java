package com.example.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardDrinks, cardSnacks, cardFoods, cardTopUp;
    private ImageButton myorderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myorderButton = (ImageButton) findViewById(R.id.myOrderButton);
        cardDrinks = (CardView) findViewById(R.id.cardViewDrinks);
        cardSnacks = (CardView) findViewById(R.id.cardViewSnacks);
        cardFoods = (CardView) findViewById(R.id.cardViewFoods);
        cardTopUp = (CardView) findViewById(R.id.cardViewTopUp);

        myorderButton.setOnClickListener(this);
        cardDrinks.setOnClickListener(this);
        cardSnacks.setOnClickListener(this);
        cardFoods.setOnClickListener(this);
        cardTopUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.myOrderButton : intent = new Intent(this, MyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.cardViewDrinks : intent = new Intent(this, DrinksActivity.class);
                startActivity(intent);
                break;
            case R.id.cardViewSnacks : intent = new Intent(this, SnacksActivity.class);
                startActivity(intent);
                break;
            case R.id.cardViewFoods : intent = new Intent(this, FoodsActivity.class);
                startActivity(intent);
                break;
            case R.id.cardViewTopUp : intent = new Intent(this, TopUpActivity.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}