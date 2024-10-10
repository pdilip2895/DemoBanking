package com.dilip.banking1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    @JsonProperty("account_holder_name")
    private String accountHolderName;
    private double balance = 0;
}
