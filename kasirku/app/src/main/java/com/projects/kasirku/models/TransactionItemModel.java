package com.projects.kasirku.models;

import androidx.annotation.Nullable;

public class TransactionItemModel {

    private String name;
    private int itemPrice;
    private int quantity;
    private int itemTotalPrice;

    public TransactionItemModel(String name, int itemPrice, int quantity, int itemTotalPrice) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.itemTotalPrice = itemTotalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(int itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    @Override
    public boolean equals(@Nullable Object comparatorObj) {
        if (comparatorObj instanceof TransactionItemModel)
            return ((TransactionItemModel) comparatorObj).name.equals(getName());

        return false;
    }
}
