/*
Assumptions:
shipping cost is total products weight in grams divided by 10
checkout operation reduces the customer balance in case of successful checkout operation

 */





import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Start Ecommerce System \n");
        //Creating products of Ecommerce system
        Product mobileScratchCards = new Product("Mobile scratch card",10.5,5);
        Product biscuits = new ExpirableProduct("Biscuits",12.8,4, LocalDate.of(2026,2,5));
        Product tv = new ShippableProduct("Tv",2000,3,1010.5);
        Product cheese = new ExpirableAndShippableProduct("Cheese",20.3,6, LocalDate.of(2026,4,5),300.6);
        //Creating customer
        Customer customer1 = new Customer("Ahmed",3200);

        customer1.addProductToCart(mobileScratchCards,4);
        customer1.addProductToCart(biscuits,2);
        customer1.addProductToCart(tv,1);
        customer1.addProductToCart(cheese,3);
        customer1.checkout();

    }
}
