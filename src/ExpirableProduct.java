import java.time.LocalDate;

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
