package com.shop.checkout;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class CheckoutTest {
    @Test
    void shouldReturnTotalWithoutOffers() {
        Checkout checkout = new Checkout(List.of());

        List<String> items = List.of("APPLE", "APPLE");

        int total = checkout.total(items);

        assertEquals("£1.20", formatInPounds(total));
    }

    @Test
    void shouldHandleMixedItemsCorrectly() {
        Checkout checkout = new Checkout(List.of());

        List<String> items = List.of("APPLE", "ORANGE");

        int total = checkout.total(items);

        assertEquals(
                Item.APPLE.getPriceInPence() + Item.ORANGE.getPriceInPence(),
                total
        );
    }

    @Test
    void shouldApplyDiscountFromOffersForApples() {
        Offer offer = mock(Offer.class);
        Checkout checkout = new Checkout(List.of(offer));
        when(offer.discountInPence(anyList())).thenReturn(60);

        List<String> items = List.of("APPLE", "APPLE");
        int total = checkout.total(items);
        assertEquals("£0.60", formatInPounds(total));
    }

    @Test
    void shouldApplyDiscountFromOffers() {
        Offer offer = mock(Offer.class);
        Checkout checkout = new Checkout(List.of(offer));
        when(offer.discountInPence(anyList())).thenReturn(85);

        List<String> items = List.of(
                "APPLE", "APPLE",
                "ORANGE", "ORANGE", "ORANGE"
        );
        int total = checkout.total(items);
        assertEquals("£1.10", formatInPounds(total));
    }


    private  String formatInPounds(int total) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
        return formatter.format(total / 100.0);
    }
}

