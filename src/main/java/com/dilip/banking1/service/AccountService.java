package com.dilip.banking1.service;

import com.dilip.banking1.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(Long id);
    AccountDto deposit(Long id , double amount);
    AccountDto withdraw(Long id , double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
}
