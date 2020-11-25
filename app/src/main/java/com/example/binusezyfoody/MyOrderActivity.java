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

public class MyOrderActivity extends AppCompatActivity {

    ListView listMyorder;
    Button payNow, deleteAll;
    TextView totalHarga;

    String[] titleNull = {"Empty"};
    String[] priceNull = {"Empty"};
    int[] picNull = {R.mipmap.ic_launcher};
    String[] qtyNull = {"Empty"};

    Vector<Product> myOrder = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        totalHarga = (TextView) findViewById(R.id.totalHarga);
        payNow = (Button) findViewById(R.id.payNow);
        deleteAll = (Button) findViewById(R.id.deleteAll);

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Integer qty = Integer.parseInt(bundle.getString("quantity1"));
            if (bundle.getString("title1").equals("Jus Mangga") || bundle.getString("title1").equals("Mie Goreng")) {
                int price = 15000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Pulpy Orange") || bundle.getString("title1").equals("Oreo")) {
                int price = 9000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Coca-Cola")) {
                int price = 12000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Fruit Tea") || bundle.getString("title1").equals("Chitato")) {
                int price = 8000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Lays")) {
                int price = 10000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Tango")) {
                int price = 20000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Hamburger")) {
                int price = 35000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("Nasi Goreng")) {
                int price = 18000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            } else if (bundle.getString("title1").equals("KFC")) {
                int price = 48000 * qty;
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
                myOrder.add(new Product(bundle.getInt("image1"), bundle.getString("title1"), Integer.toString(price), bundle.getString("quantity1")));
            }
        }

        listMyorder = (ListView) findViewById(R.id.listMyorder);
        String[] orderTitle = new String[myOrder.size()];
        String[] orderPrice = new String[myOrder.size()];
        int[] orderPic = new int[myOrder.size()];
        String[] orderQty = new String[myOrder.size()];
        int total = 0;

        for (int i=0;i<myOrder.size();i++) {
            orderTitle[i] = myOrder.get(i).getTitleProduct();
            orderPrice[i] = myOrder.get(i).getPrice();
            orderPic[i] = myOrder.get(i).getProductImage();
            orderQty[i] = myOrder.get(i).getQuantity();
            total = (total + Integer.parseInt(orderPrice[i]));
        }

        if (myOrder.size() == 0) {
            totalHarga.setText("Total : Rp. 0");
            MyAdapter adapter = new MyAdapter(this, titleNull, priceNull, picNull, qtyNull);
            listMyorder.setAdapter(adapter);
        } else {
            totalHarga.setText("Total : Rp. " + Integer.toString(total));
            MyAdapter adapter = new MyAdapter(this, orderTitle, orderPrice, orderPic, orderQty);
            listMyorder.setAdapter(adapter);
        }

        int payPic = 0;
        String payTitle = "";
        String payPrice = "";
        String payQty = "";

        if (bundle != null) {
            payPic = bundle.getInt("image1");
            payTitle = bundle.getString("title1");
            payPrice = bundle.getString("price1");
            payQty = bundle.getString("quantity1");
        }

        int picPas = payPic;
        String titlePas = payTitle;
        String pricePas = payPrice;
        String qtyPas = payQty;

        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentPay;

                if (myOrder.size() == 0) {
                    intentPay = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);
                    startActivity(intentPay);
                } else {
                    intentPay = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("imageCom", picPas);
                    intentPay.putExtras(bundle);
                    intentPay.putExtra("titleCom", titlePas);
                    intentPay.putExtra("priceCom", pricePas);
                    intentPay.putExtra("qtyCom", qtyPas);
                    startActivity(intentPay);
                }
            }
        });

        if (myOrder.size() == 0) {
            deleteAll.setVisibility(View.GONE);
        } else {
            deleteAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myOrder.clear();
                    Intent intentDel = new Intent(MyOrderActivity.this, MyOrderActivity.class);
                    startActivity(intentDel);
                }
            });
        }
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rPrice[];
        int rImgs[];
        String rQty[];

        MyAdapter (Context c, String title[], String price[], int imgs[], String qty[]) {
            super(c, R.layout.row_my_order, R.id.titleMyorder, title);
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
            View row = layoutInflater.inflate(R.layout.row_my_order, parent, false);
            ImageView images = row.findViewById(R.id.imageMyorder);
            TextView myTitle = row.findViewById(R.id.titleMyorder);
            TextView myPrice = row.findViewById(R.id.priceMyorder);
            TextView myQty = row.findViewById(R.id.qtyMyorder);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myPrice.setText("Rp. " + rPrice[position]);
            myQty.setText("Quantity : " + rQty[position]);

            return row;
        }
    }
}