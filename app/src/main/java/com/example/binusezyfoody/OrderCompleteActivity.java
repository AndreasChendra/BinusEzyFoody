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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

public class OrderCompleteActivity extends AppCompatActivity {

    Button mainMenu;
    TextView totalCom;
    ListView listOrdercom;

    String[] titleNull = {"Empty"};
    String[] priceNull = {"Empty"};
    int[] picNull = {R.mipmap.ic_launcher};
    String[] qtyNull = {"Empty"};

    Vector<Product> myOrderCom = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        mainMenu = (Button) findViewById(R.id.mainMenu);
        totalCom = (TextView) findViewById(R.id.total);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Integer qty = Integer.parseInt(bundle.getString("qtyCom"));
            if (bundle.getString("titleCom").equals("Jus Mangga") || bundle.getString("titleCom").equals("Mie Goreng")) {
                int price = 15000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            }
            else if (bundle.getString("titleCom").equals("Pulpy Orange") || bundle.getString("titleCom").equals("Oreo")) {
                int price = 9000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("Coca-Cola")) {
                int price = 12000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("Fruit Tea") || bundle.getString("titleCom").equals("Chitato")) {
                int price = 8000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("Lays")) {
                int price = 10000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("Tango")) {
                int price = 20000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("Hamburger")) {
                int price = 35000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("Nasi Goreng")) {
                int price = 18000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            } else if (bundle.getString("titleCom").equals("KFC")) {
                int price = 48000 * qty;
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
                myOrderCom.add(new Product(bundle.getInt("imageCom"), bundle.getString("titleCom"), Integer.toString(price), bundle.getString("qtyCom")));
            }
        }

        listOrdercom = (ListView) findViewById(R.id.listOrderComplete);
        String[] orderTitle1 = new String[myOrderCom.size()];
        String[] orderPrice1 = new String[myOrderCom.size()];
        int[] orderPic1 = new int[myOrderCom.size()];
        String[] orderQty1 = new String[myOrderCom.size()];
        int totalTemp = 0;

        for (int i=0;i<myOrderCom.size();i++) {
            orderTitle1[i] = myOrderCom.get(i).getTitleProduct();
            orderPrice1[i] = myOrderCom.get(i).getPrice();
            orderPic1[i] = myOrderCom.get(i).getProductImage();
            orderQty1[i] = myOrderCom.get(i).getQuantity();
            totalTemp = (totalTemp + Integer.parseInt(orderPrice1[i]));
        }

        if (myOrderCom.size() == 0) {
            totalCom.setText("Total : Rp. 0");
            MyAdapter adapter = new MyAdapter(this, titleNull, priceNull, picNull, qtyNull);
            listOrdercom.setAdapter(adapter);
        } else {
            totalCom.setText("Total : Rp. " + Integer.toString(totalTemp));
            MyAdapter adapter = new MyAdapter(this, orderTitle1, orderPrice1, orderPic1, orderQty1);
            listOrdercom.setAdapter(adapter);
        }
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rPrice[];
        int rImgs[];
        String rQty[];

        MyAdapter (Context c, String title[], String price[], int imgs[], String qty[]) {
            super(c, R.layout.row_order_complete, R.id.titleOrderCom, title);
            this.context = c;
            this.rTitle = title;
            this.rPrice = price;
            this.rImgs = imgs;
            this.rQty = qty;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_order_complete, parent, false);
            ImageView images = row.findViewById(R.id.imageOrderCom);
            TextView myTitle = row.findViewById(R.id.titleOrderCom);
            TextView myPrice = row.findViewById(R.id.priceOrderCom);
            TextView myQty = row.findViewById(R.id.qtyOrderCom);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myPrice.setText("Rp. " + rPrice[position]);
            myQty.setText("Quantity : " + rQty[position]);

            return row;
        }
    }
}