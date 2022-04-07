package vn.fis.finaltestaquy.exception;

import vn.fis.finaltestaquy.entity.TransactionErrorCode;

public class AccountException extends Exception{
    private TransactionErrorCode errorCode;
    public AccountException(TransactionErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public TransactionErrorCode getErrorCode() {
        return this.errorCode;
    }
}
