package discount;

public class DiscountDiscount implements DiscountStrategy {

    @Override
    public double discount(double billAmount) {
        return billAmount - (billAmount * 0.5);
    }
}
