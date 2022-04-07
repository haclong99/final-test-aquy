package vn.fis.finaltestaquy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.finaltestaquy.controller.response.TransferResult;
import vn.fis.finaltestaquy.entity.Account;
import vn.fis.finaltestaquy.entity.StatusAccount;
import vn.fis.finaltestaquy.entity.TransactionErrorCode;
import vn.fis.finaltestaquy.exception.AccountException;
import vn.fis.finaltestaquy.exception.BankException;
import vn.fis.finaltestaquy.repository.AccountRepository;
import vn.fis.finaltestaquy.repository.TransactionRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class TransactionServiceImpl {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    public Account getAccountById(Long id) throws AccountException {
        Optional<Account> oAccount = accountRepository.findById(id);

        if (oAccount.isPresent()) {
            Account account = oAccount.get();
            if (account.getStatus() == StatusAccount.APPROVE) {
                throw new AccountException(TransactionErrorCode.ACCOUNT_DISABLED,
                        "Account " + account.getId() + " of " + account.getAccountNumber() + " is disabled");
            } else {
                return account;
            }
        } else {
            throw new AccountException(TransactionErrorCode.ID_NOT_FOUND,
                    "Account id " + id + " does not exist");
        }
    }

    @Transactional(rollbackOn = {BankException.class})
    public TransferResult transfer(long fromAccID, long toAccID, long amount) {
        Account fromAccount;
        Account toAccount;

        try {
            fromAccount = getAccountById(fromAccID);
            toAccount = getAccountById(toAccID);
        } catch (AccountException accountException) {
            throw new BankException(accountException.getErrorCode(), "Account Error", accountException.getMessage());
        }


        if (fromAccount.getBalance() < amount) {
            String detail = "Account " + fromAccount.getId() + " of " + fromAccount.getAccountNumber() + " does not have enough balance";
            throw new BankException(TransactionErrorCode.BALANCE_NOT_ENOUGH, "Not enough balance", detail);
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);

        toAccount.setBalance(toAccount.getBalance() + amount);
        Date transferDate = new Date();

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        return new TransferResult(TransactionErrorCode.SUCCESS, "Transfer success", transferDate);
    }
}
