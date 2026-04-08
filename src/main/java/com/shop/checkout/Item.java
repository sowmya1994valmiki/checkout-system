package com.shop.checkout;

public enum Item {

    APPLE(60),
    ORANGE(25);

    private final int priceInPence;

    Item(int priceInPence) {
        this.priceInPence = priceInPence;
    }

    public int getPriceInPence() {
        return priceInPence;
    }

}
