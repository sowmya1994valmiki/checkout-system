package com.shop.checkout;

import java.util.List;


public interface Offer {
    int discountInPence(List<Item> items);
}
