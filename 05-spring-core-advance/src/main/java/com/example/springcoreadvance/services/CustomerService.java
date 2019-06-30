package com.example.springcoreadvance.services;

import com.example.springcoreadvance.commands.CustomerForm;
import com.example.springcoreadvance.domain.Customer;

public interface CustomerService extends CRUDService<Customer> {

    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);
}
