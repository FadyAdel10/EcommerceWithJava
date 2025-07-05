/**
 * Represents an item inside a shopping cart,
 * containing the product and the quantity chosen by the customer.
 */

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product,int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

}
