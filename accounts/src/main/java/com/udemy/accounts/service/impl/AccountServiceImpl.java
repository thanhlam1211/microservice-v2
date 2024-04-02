package com.udemy.accounts.service.impl;

import com.udemy.accounts.constants.AccountsConstants;
import com.udemy.accounts.dto.CustomerDto;
import com.udemy.accounts.entity.Account;
import com.udemy.accounts.entity.Customer;
import com.udemy.accounts.exception.CustomerAlreadyExistException;
import com.udemy.accounts.mapper.CustomerMapper;
import com.udemy.accounts.repository.AccountRepository;
import com.udemy.accounts.repository.CustomerRepository;
import com.udemy.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered with given mobile number" + customerDto.getMobileNumber());
        }
        customer.setCreateAt(LocalDateTime.now());
        customer.setCreatedBy("Lam Bui");
        System.out.println(LocalDateTime.now());
        Customer savesCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savesCustomer));
    }
    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreateAt(LocalDateTime.now());
        newAccount.setCreatedBy("Lam Bui");
        return newAccount;
    }
}
