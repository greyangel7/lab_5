package phones;

public class PriceLowTag extends Tag {
    private double price;

    public PriceLowTag(double price) {
        this.price = price;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getPrice() < price;
    }
}