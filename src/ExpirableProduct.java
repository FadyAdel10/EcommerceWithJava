import java.time.LocalDate;
/**
 * Represents a product that has an expiration date but does not require shipping.
 */
public class ExpirableProduct extends Product implements Expirable{

    private LocalDate expiryDate;
    public ExpirableProduct(String name,double price,int availableQuantity,LocalDate expiryDate){
        super(name, price, availableQuantity);
        this.expiryDate = expiryDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(getExpiryDate());
    }


}
