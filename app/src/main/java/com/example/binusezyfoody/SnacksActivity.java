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

public class SnacksActivity extends AppCompatActivity {
    ListView listSnacks;
    String snacksName[] = {"Chitato", "Oreo", "Lays", "Tango"};
    String snacksPrice[] = {"8.000", "9.000", "10.000", "20.000"};
    int snacksPic[] = {R.drawable.chitato, R.drawable.oreo, R.drawable.lays, R.drawable.tango};
    private ImageButton myorderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        myorderButton = (ImageButton) findViewById(R.id.myOrderButton);
        myorderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnacksActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });

        listSnacks = (ListView) findViewById(R.id.listSnacks);

        MyAdapter adapter = new MyAdapter(this, snacksName, snacksPrice, snacksPic);
        listSnacks.setAdapter(adapter);

        listSnacks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SnacksActivity.this, OrderActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("image", snacksPic[position]);
                intent.putExtras(bundle);
                intent.putExtra("title", snacksName[position]);
                intent.putExtra("price", snacksPrice[position]);
                intent.putExtra("titleOrder", "Snack");
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