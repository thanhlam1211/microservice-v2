package com.udemy.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountsDto {

    private Long customerId;

    private String accountType;

    private String branchAddress;
}
