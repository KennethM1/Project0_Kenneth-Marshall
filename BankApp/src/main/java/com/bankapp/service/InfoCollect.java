package com.bankapp.service;

import com.bankapp.model.Customer;

public interface InfoCollect {
public Customer getAccountById(long id);
public Customer getAccountByName(String name);

}
