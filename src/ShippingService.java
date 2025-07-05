import java.util.List;

public class ShippingService {
    public static void printShipmentDetails(List<CartItem> shippingItems){
        System.out.println("** Shipment notice **");
        for (CartItem currentItem : shippingItems) {
            System.out.printf("%dx %-15s %8.2fg%n", currentItem.getQuantity(), currentItem.getProduct().getName() + "   ",
                    ((Shippable) currentItem.getProduct()).getWeight() * currentItem.getQuantity());
        }
    }
}
