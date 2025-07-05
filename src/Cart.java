import EcomeerceExceptions.ExpireProductException;
import EcomeerceExceptions.OutOfStockException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer's shopping cart.
 * Handles product addition, subtotal calculation, and checkout logic.
 */
public class Cart {
    private List<CartItem> cartItems;
    private double subTotal;
    private double shipping;
    private double amount;
    public Cart(){
        this.cartItems = new ArrayList<>();
    }


    public double getAmount() {
        return amount;
    }
    public boolean isCartEmpty() {
        return  cartItems.isEmpty();
    }

    //returns a list of cart items that are expired.
    public List<CartItem> getExpiredProducts() {
        List<CartItem> expiredItems = new ArrayList<>();

        for (CartItem currentItem : cartItems) {
            if (currentItem.getProduct() instanceof Expirable && ((Expirable) currentItem.getProduct()).isExpired()) {
                expiredItems.add(currentItem);
            }
        }
        return expiredItems;
    }

    //Checks whether the cart contains any expired products.
    public boolean isThereExpiredItems(){
        return !getExpiredProducts().isEmpty();
    }
    // Adds a product to the cart after validating available quantity.
    // Updates subtotal, shipping, and total amount.
    public void addToCart(Product product, int quantity){
    if(quantity > product.getAvailableQuantity()){
        throw new OutOfStockException("provided "+product.getName()+" quantity greater than available quantity");
    }
    // Reserve product stock
    product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
    // Create and add cart item
    CartItem newCartItem = new CartItem(product,quantity);
    cartItems.add(newCartItem);
    //  Update subtotal
    subTotal += (product.getPrice() * quantity);
    // Update shipping cost if product is shippable
    if(product instanceof Shippable){
        shipping += (((Shippable) product).getWeight())*quantity/10;
    }
    // Update total amount
    amount = subTotal + shipping;
    }
    // Performs checkout by printing the receipt and (if needed) shipping info.
    public void checkout(){

        List<CartItem> shippableItems = new ArrayList<>();
        // Collect shippable items
        for (CartItem currentItem : cartItems) {
            if (currentItem.getProduct() instanceof Shippable) {
                shippableItems.add(currentItem);
            }
        }
        // Print shipping details if applicable
        if(!shippableItems.isEmpty()) {
            ShippingService.printShipmentDetails(shippableItems);
        }
        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem currentItem : cartItems) {
            System.out.printf("%-4s %-20s %10.2f %n", currentItem.getQuantity() + "x", currentItem.getProduct().getName(),
                    currentItem.getProduct().getPrice() * currentItem.getQuantity());
        }
        System.out.println("-----------------------------------------");
        System.out.printf("%-25s %10.2f %n", "SubTotal", subTotal);
        System.out.printf("%-25s %10.2f %n", "Shipping", shipping);
        System.out.printf("%-25s %10.2f %n", "Amount", amount);
        System.out.println();
    }
}
