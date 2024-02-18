package com.workintechs18d4project.S18D4.controller;

import com.workintechs18d4project.S18D4.dto.AccountResponse;
import com.workintechs18d4project.S18D4.dto.CustomerResponse;
import com.workintechs18d4project.S18D4.entity.Account;
import com.workintechs18d4project.S18D4.entity.Customer;
import com.workintechs18d4project.S18D4.service.AccountService;
import com.workintechs18d4project.S18D4.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/workintech")
public class AccountController {
    private CustomerService customerService;
    private AccountService accountService;

    @GetMapping("/account")
    public List<Account> findAll(){
        return accountService.findAllAccounts();
    }

    @PostMapping("/account/{customerID}")
    public AccountResponse save(@RequestBody Account account , @PathVariable Long customerID){

     Customer customer = customerService.getCustomerByID(customerID);
    //Join iliski oldugundan 2 tarafa da baglamamaiz gerecek.
     customer.getAccounts().add(account);//customer a account bagladik .
        account.setCustomer(customer);//account a da customer bagladik.
        Account addedAccount = accountService.addAccount(account);
        return new AccountResponse(addedAccount.getId(), addedAccount.getAccountName(), addedAccount.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @PutMapping("/account/{customerI}")
    public AccountResponse update(@RequestBody Account account , @PathVariable Long customerID){
        Customer customer = customerService.getCustomerByID(customerID);

        Account foundAccount = null;
        for (Account a : customer.getAccounts()){
            if (account.getId() == a.getId()){
                foundAccount = a ;
            }
        }
        if (foundAccount == null){
            throw new RuntimeException("Account is not found !");
        }
        //Set metodu belirli bir index ile guncelleme yapmamizi saglar .
        //Bunun icin bulunan account indexine erismemiz gerekiyor .
        int indexOfFound = customer.getAccounts().indexOf(foundAccount);
        customer.getAccounts().set(indexOfFound,account);//Customer's account guncellendi.
        account.setCustomer(customer);//Account a da customer baglandi ve guncellendi .

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @DeleteMapping("/account/{id}")
    public AccountResponse remove(@PathVariable Long id){

        Account account = accountService.findAccountByID(id);

        accountService.removeAccount(id);


        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(account.getCustomer().getId(), account.getCustomer().getEmail(), account.getCustomer().getSalary()));
    }


}
