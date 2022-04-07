package vn.fis.finaltestaquy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fis.finaltestaquy.controller.request.TransferRequest;
import vn.fis.finaltestaquy.controller.response.TransferResult;
import vn.fis.finaltestaquy.exception.BankException;
import vn.fis.finaltestaquy.service.impl.TransactionServiceImpl;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<TransferResult> transfer(@ModelAttribute TransferRequest transferRequest) {

        try {
            TransferResult result = transactionService.transfer(
                    transferRequest.getFrom(),
                    transferRequest.getTo(),
                    transferRequest.getAmount());

            return ResponseEntity.ok().body(result);
        } catch (BankException e) {
            TransferResult transerError = new TransferResult(
                    e.getErrorCode(),
                    e.getMessage() + " : " + e.getDetail(),
                    new Date());
            return ResponseEntity.badRequest().body(transerError);
        }
    }
}
