package vn.fis.finaltestaquy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.finaltestaquy.entity.Account;
import vn.fis.finaltestaquy.entity.StatusAccount;
import vn.fis.finaltestaquy.exception.AccountNotFoundException;
import vn.fis.finaltestaquy.repository.AccountRepository;
import vn.fis.finaltestaquy.repository.CustomerRepository;
import vn.fis.finaltestaquy.service.AccountService;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository ;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Account createAccount(Account account) {
        account.setStatus(StatusAccount.APPROVE);
        return accountRepository.save(account);
    }

    @Override
    public Account updateManager(Long id, Account accountRequest) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account", "id", id));
        account.setStatus(StatusAccount.EFFECT);
        return accountRepository.save(account);
    }

    @Override
    public Account updateUser(Long id, Account accountRequest) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account", "id", id));
        account.setStatus(StatusAccount.LOCK);
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setBalance(accountRequest.getBalance());
        return accountRepository.save(account);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> result = accountRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new AccountNotFoundException("Account", "id", id);
        }
    }
}
