package com.dilip.banking1.controller;

import com.dilip.banking1.dto.AccountDto;
import com.dilip.banking1.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //REST API request for adding a new acccount
    @PostMapping
    public ResponseEntity<AccountDto> addAccountDto(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //REST API for getting an Account details by id
    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccount(id);
        return ResponseEntity.ok(accountDto);
    }

    //REST API for deposit amount by id
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id , @RequestBody Map<String, Double> request){
        AccountDto accountDto = accountService.deposit(id , request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    //REST API for withdrawal of money by id
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id , @RequestBody Map<String , Double> request){
        AccountDto accountDto = accountService.withdraw(id , request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    //REST API for getting all account details
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

    //REST API for deleting an account by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }

}
