import java.time.LocalDate;


/**
 * A product that both expires and requires shipping.
 */
public class ExpirableAndShippableProduct extends Product implements Expirable,Shippable{
    private LocalDate expiryDate;
    private double weight;
    public ExpirableAndShippableProduct(String name,double price,int availableQuantity,LocalDate expiryDate,double weight){
        super(name, price, availableQuantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    //  Checks whether the product is expired based on the current date.
    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(getExpiryDate());
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
