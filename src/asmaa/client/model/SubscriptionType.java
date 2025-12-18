package asmaa.client.model;

public enum SubscriptionType {
    NONE(0),
    MONTH_1(5),
    MONTH_6(10),
    YEAR_1(15);

    private final int discount;

    SubscriptionType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
