import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems;
    private double subTotal;
    private double shipping;
    private double amount;
    public Cart(){
        this.cartItems = new ArrayList<>();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getShipping() {
        return shipping;
    }

    public double getAmount() {
        return amount;
    }
    public boolean isCartEmpty() {
        return  cartItems.isEmpty();
    }
    public void addToCart(Product product, int quantity){
        if(quantity > product.getAvailableQuantity()){
            throw new OutOfStockException("provided "+product.getName()+" quantity greater than available quantity");
        }

        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
        CartItem newCartItem = new CartItem(product,quantity);
        cartItems.add(newCartItem);
        subTotal += (product.getPrice() * quantity);
        if(product instanceof Shippable){
            shipping += (((Shippable) product).getWeight())*quantity/10;
        }
        amount = subTotal + shipping;
    }

    public void checkout(){

        List<CartItem> shippableItems = new ArrayList<>();
        for (CartItem currentItem : cartItems) {
            if (currentItem.getProduct() instanceof Shippable) {
                shippableItems.add(currentItem);
            }
        }
        if(!shippableItems.isEmpty()) {
            ShippingService.printShipmentDetails(shippableItems);
        }
        System.out.println("** Checkout receipt **");
        for(int i=0; i<cartItems.size();i++){
            CartItem currentItem = cartItems.get(i);
            if(currentItem.getProduct() instanceof Expirable && ((Expirable)currentItem.getProduct()).isExpired()){
                throw new ExpireProductException(currentItem.getProduct().getName()+" is expired");
            }
            System.out.printf("%dx %-15s %8.2f%n",currentItem.getQuantity(),currentItem.getProduct().getName()+"   ",
                    currentItem.getProduct().getPrice()*currentItem.getQuantity());
        }
        System.out.println("-------------------");
        System.out.printf("%-15s %8.2f%n", "Subtotal",subTotal);
        System.out.printf("%-15s %8.2f%n", "Shipping",shipping);
        System.out.printf("%-15s %8.2f%n","Amount",amount);
    }
}
