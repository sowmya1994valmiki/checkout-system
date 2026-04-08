package com.shop.checkout;

public final class Offers {

    public static final Offer APPLES_BUY_ONE_GET_ONE = items -> {
        long appleCount = items.stream().filter(i -> i == Item.APPLE).count();
        long freeApples = appleCount / 2;
        return (int) (freeApples * Item.APPLE.getPriceInPence());
    };


    public static final Offer ORANGES_GET_ONE_EXTRA = items -> {
        long orangeCount = items.stream().filter(i -> i == Item.ORANGE).count();
        long freeOranges = orangeCount / 3;
        return (int) (freeOranges * Item.ORANGE.getPriceInPence());
    };
}
