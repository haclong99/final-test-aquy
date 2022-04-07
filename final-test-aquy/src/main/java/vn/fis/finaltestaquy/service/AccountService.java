package vn.fis.finaltestaquy.service;

import vn.fis.finaltestaquy.entity.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account updateManager(Long id, Account account);
    Account findById(Long id);
    Account updateUser(Long id, Account account);
    Account findByAccountNumber(String accountNumber);
}
