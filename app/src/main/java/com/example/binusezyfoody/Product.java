package com.example.binusezyfoody;

import android.graphics.drawable.Drawable;

public class Product {

    private String titleProduct;
    private int productImage;
    private String price;
    private String quantity;

    public Product(int productImage, String titleProduct, String price, String quantity) {
        this.productImage = productImage;
        this.titleProduct = titleProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
