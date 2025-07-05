public class EcommerceSystemExceptions extends RuntimeException{
    public EcommerceSystemExceptions(String message){
        super(message);
    }
}

class OutOfStockException extends EcommerceSystemExceptions {
    public OutOfStockException(String message) {
        super(message);
    }
}
class EmptyCartException extends EcommerceSystemExceptions{
    public EmptyCartException(String message){
        super(message);
    }
}

class InsufficientBalanceCustomerException extends EcommerceSystemExceptions{
    public InsufficientBalanceCustomerException(String message){
        super(message);
    }
}

class ExpireProductException extends EcommerceSystemExceptions{
    public ExpireProductException(String message){
        super(message);
    }
}