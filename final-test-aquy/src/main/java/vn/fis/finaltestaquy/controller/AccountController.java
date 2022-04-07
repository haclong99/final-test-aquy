package vn.fis.finaltestaquy.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.finaltestaquy.dto.AccountDto;
import vn.fis.finaltestaquy.entity.Account;
import vn.fis.finaltestaquy.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    AccountService accountService;

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable(name = "id") Long id) {
        Account account = accountService.findById(id);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return ResponseEntity.ok().body(accountResponse);
    }

    @PostMapping("/account")
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {

        Account accountRequest = modelMapper.map(accountDto, Account.class);
        Account account = accountService.createAccount(accountRequest);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return new ResponseEntity<AccountDto>(accountResponse, HttpStatus.CREATED);
    }

    @PutMapping("/account/manager/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable long id, @RequestBody AccountDto accountDto) {

        Account accountRequest = modelMapper.map(accountDto, Account.class);
        Account account = accountService.updateManager(id, accountRequest);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return ResponseEntity.ok().body(accountResponse);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<AccountDto> updateUser(@PathVariable long id, @RequestBody AccountDto accountDto) {

        Account accountRequest = modelMapper.map(accountDto, Account.class);
        Account account = accountService.updateUser(id, accountRequest);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return ResponseEntity.ok().body(accountResponse);
    }

    @GetMapping("/account/accountNumber/{accountNumber}")
    public ResponseEntity<AccountDto> findByAccountNumber(@PathVariable(name = "accountNumber") String accountNumber) {
        Account account = accountService.findByAccountNumber(accountNumber);

        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);

        return ResponseEntity.ok().body(accountResponse);
    }
}
