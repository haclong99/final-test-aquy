package vn.fis.finaltestaquy.exception;

public class AccountNotFoundException extends RuntimeException{
    private String message;
    public AccountNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public AccountNotFoundException(String post, String id, Long id1) {
    }
}
