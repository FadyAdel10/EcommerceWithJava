public class Customer {
    private int id;
    private String name;
    private double balance;
    private Cart cart;

    public Customer(int id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addProductToCart(Product product,int quantity){
        cart.addToCart(product,quantity);
    }
    public void checkout(){
        if(cart.isCartEmpty()){
            throw new EmptyCartException("Empty cart");
        }
        if(balance < cart.getAmount())
        {
            throw new InsufficientBalanceCustomerException("your balance is insufficient");
        }
        cart.checkout();
        double customerCurrentBalance = balance - cart.getAmount();
        setBalance(customerCurrentBalance);
        System.out.println("Current balance  "+customerCurrentBalance);
    }
}
