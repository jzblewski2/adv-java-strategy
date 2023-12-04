package discount;

public class SaleDiscount implements DiscountStrategy {

    @Override
    public double discount(double billAmount) {
        return billAmount - (billAmount * 0.1);
    }
}
