package discount;

public class CustomerOrder {

    private String customerName;
    private double billAmount;
    private DiscountStrategy discountStrategy;

    public CustomerOrder(String customerName, double billAmount, char discountType) {
        this.customerName = customerName;
        this.billAmount = billAmount;
        setDiscountStrategy(discountType);
    }

    public double getBillAmount() {
        return discountStrategy.discount(billAmount);
    }

    public void setDiscountStrategy(char discountType) {
        switch (discountType) {
            case 'S':
            case 's':
                discountStrategy = new SaleDiscount();
                break;
            case 'D':
            case 'd':
                discountStrategy = new DiscountDiscount();
                break;
            case 'L':
            case 'l':
                discountStrategy = new LiquidationDiscount();
                break;
            default:
                discountStrategy = billAmount -> billAmount;
        }
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "customerName='" + customerName + '\''
                + ", billAmount=" + billAmount
                + ", discountType=" + discountStrategy
                + '}';
    }
}
