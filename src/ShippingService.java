import java.util.List;
/**
 * Utility service responsible for handling shipment-related operations.
 * Specifically, it prints shipment details for all shippable items in a cart.
 */
public class ShippingService {
    public static void printShipmentDetails(List<CartItem> shippingItems){
        double totalPackageWeight = 0;
        System.out.println("** Shipment notice **");
        for (CartItem currentItem : shippingItems) {
            // Total weight of current product line (in grams)
            double weightIngrams = ((Shippable) currentItem.getProduct()).getWeight() * currentItem.getQuantity();
            totalPackageWeight += weightIngrams/1000;   // Convert to Kg
            // Print item shipment info
            System.out.printf("%-5s %-20s %10.2f%n", currentItem.getQuantity() + "x",  currentItem.getProduct().getName()
                    , ((Shippable) currentItem.getProduct()).getWeight() * currentItem.getQuantity());
        }
        // Print total shipment weight in Kg
        System.out.printf("%-24s %10sKg %n", "Total package weight", totalPackageWeight);
        System.out.println();
    }
}
