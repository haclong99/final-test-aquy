package vn.fis.finaltestaquy.exception;

import vn.fis.finaltestaquy.entity.TransactionErrorCode;

public class BankException extends RuntimeException{
    private TransactionErrorCode errorCode;
    private String detail;

    public BankException(TransactionErrorCode errorCode, String message, String detail) {
        super(message);
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public TransactionErrorCode getErrorCode() {
        return this.errorCode;
    }

}
