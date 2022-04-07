package vn.fis.finaltestaquy.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import vn.fis.finaltestaquy.entity.TransactionErrorCode;

import java.util.Date;

@Data
@AllArgsConstructor
public class TransferResult {
  private TransactionErrorCode resultCode; //200 success, 404 account not found, 405 balance not enought
  private String message;
  private Date transferDate;
}
