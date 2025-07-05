import java.time.LocalDate;

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
    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(getExpiryDate());
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
