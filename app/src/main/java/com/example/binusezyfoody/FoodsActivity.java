package com.example.binusezyfoody;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodsActivity extends AppCompatActivity {

    ListView listFoods;
    String foodsName[] = {"Hamburger", "Nasi Goreng", "KFC", "Mie Goreng"};
    String foodsPrice[] = {"35.000", "18.000", "48.000", "15.000"};
    int foodsPic[] = {R.drawable.burger, R.drawable.friedrice, R.drawable.kfc, R.drawable.noodle};
    private ImageButton myorderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        myorderButton = (ImageButton) findViewById(R.id.myOrderButton);
        myorderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodsActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });

        listFoods = (ListView) findViewById(R.id.listFoods);

        MyAdapter adapter = new MyAdapter(this, foodsName, foodsPrice, foodsPic);
        listFoods.setAdapter(adapter);

        listFoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FoodsActivity.this, OrderActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", foodsPic[position]);
                intent.putExtras(bundle);
                intent.putExtra("title", foodsName[position]);
                intent.putExtra("price", foodsPrice[position]);
                intent.putExtra("titleOrder", "Food");
                startActivity(intent);
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rPrice[];
        int rImgs[];

        MyAdapter (Context c, String title[], String price[], int imgs[]) {
            super(c, R.layout.row, R.id.titleList, title);
            this.context = c;
            this.rTitle = title;
            this.rPrice = price;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.imageList);
            TextView myTitle = row.findViewById(R.id.titleList);
            TextView myPrice = row.findViewById(R.id.priceList);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myPrice.setText("Rp. " + rPrice[position]);

            return row;
        }
    }
}