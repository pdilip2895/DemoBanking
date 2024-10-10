package com.dilip.banking1.service.impl;

import com.dilip.banking1.dto.AccountDto;
import com.dilip.banking1.entity.Account;
import com.dilip.banking1.mapper.AccountMapper;
import com.dilip.banking1.repository.AccountRepository;
import com.dilip.banking1.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.accessibility.AccessibleAction;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exists"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        if(amount > account.getBalance()){
           throw new RuntimeException("Insufficient Balance");
        }
        double remaining = account.getBalance() - amount;
        account.setBalance(remaining);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        accountRepository.deleteById(id);
    }

}
