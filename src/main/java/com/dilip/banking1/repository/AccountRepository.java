package com.dilip.banking1.repository;

import com.dilip.banking1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
