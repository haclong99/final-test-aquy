package vn.fis.finaltestaquy.exception;

public class TransactionNotFoundException extends RuntimeException{
    private String message;
    public TransactionNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public TransactionNotFoundException(String post, String id, Long id1) {
    }
}
