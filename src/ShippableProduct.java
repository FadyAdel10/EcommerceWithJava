/**
 * Represents a product that requires shipping but does not expire.
 */

public class ShippableProduct extends Product implements Shippable{
    private double weight;

    public ShippableProduct(String name,double price,int availableQuantity,double weight){
        super(name, price, availableQuantity);
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
