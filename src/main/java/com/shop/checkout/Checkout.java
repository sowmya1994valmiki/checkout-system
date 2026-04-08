package com.shop.checkout;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Checkout {

    private final List<Offer> offers;

    public Checkout(List<Offer> offers) {
        this.offers = offers;
    }

    public int total(List<String> itemNames) {
        List<Item> items = itemNames.stream()
                .map(name -> Item.valueOf(name.trim().toUpperCase()))
                .toList();
        return totalAmountAfterDiscount(items);
    }

    public int totalAmountAfterDiscount(List<Item> items) {
        int totalAmountBeforeDiscount = items.stream()
                .mapToInt(Item::getPriceInPence)
                .sum();

        int discount = offers.stream()
                .mapToInt(offer -> offer.discountInPence(items))
                .sum();

        return totalAmountBeforeDiscount - discount;
    }

    public static void main(String[] args) {

        Checkout checkout = new Checkout(List.of(
                Offers.APPLES_BUY_ONE_GET_ONE,
                Offers.ORANGES_GET_ONE_EXTRA
        ));

        List<String> items = List.of(
                "Apple", "Apple", "Orange", "Apple"
        );

        int total = checkout.total(items);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
        String totalInPounds = formatter.format(total / 100.0);

        System.out.println("Items: " + items);
        System.out.printf("Total price after discount: %s", totalInPounds);    }

}
