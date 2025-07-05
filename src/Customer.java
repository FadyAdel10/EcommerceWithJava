import EcomeerceExceptions.EmptyCartException;
import EcomeerceExceptions.ExpireProductException;
import EcomeerceExceptions.InsufficientBalanceCustomerException;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    /**
     * Represents a customer with an ID, name, balance, and shopping cart.
     * Handles product selection and checkout logic.
     */
    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //  Adds a product to the customer's cart.
    public void addProductToCart(Product product,int quantity){
        cart.addToCart(product,quantity);
    }

    /**
     * Finalizes the purchase process, checking all rules:
     * - Cart must not be empty
     * - Customer must have enough balance
     * - No expired products allowed
     *
     * On success:
     * - Deducts the total amount from the customer's balance
     * - Prints checkout receipt and updated balance
     *
     * @throws EmptyCartException If cart has no items
     * @throws InsufficientBalanceCustomerException If balance is too low
     * @throws ExpireProductException If any item is expired
     */
    public void checkout(){
        //  Check if the cart is empty
        if(cart.isCartEmpty()){
            throw new EmptyCartException("Empty cart");
        }
        //  Check if the customer has sufficient funds
        if(balance < cart.getAmount())
        {
            throw new InsufficientBalanceCustomerException("your balance is insufficient");
        }
        //  Check if there are any expired items in the cart and if there is, it will throw expired exception
        if(cart.isThereExpiredItems()){
            String expiredProducts="";
            for (int i=0;i<cart.getExpiredProducts().size()-1;i++){
                String expiredProduct = cart.getExpiredProducts().get(i).getProduct().getName();
                expiredProducts += expiredProduct+",";
            }
            int lastIndex= cart.getExpiredProducts().size()-1;
            String lastExpiredProduct = cart.getExpiredProducts().get(lastIndex).getProduct().getName();
            expiredProducts += lastExpiredProduct+ " expired";
            throw new ExpireProductException(expiredProducts);
        }
        //  Proceed to checkout and update balance
        cart.checkout();
        double customerCurrentBalance = balance - cart.getAmount();
        setBalance(customerCurrentBalance);
        System.out.println("Current balance  "+customerCurrentBalance);
    }
}
