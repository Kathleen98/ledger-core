package main.java.domain.exception;

public class UnbalancedTransactionException extends RuntimeException {

    public UnbalancedTransactionException(String message){
        super(message);
    }

    public UnbalancedTransactionException(String message, Throwable cause){
        super(message, cause);
    }

}
