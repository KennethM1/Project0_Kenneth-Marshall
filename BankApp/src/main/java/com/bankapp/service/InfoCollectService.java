package com.bankapp.service;

import com.bankapp.exception.SqlException;
import com.bankapp.model.Customer;

public interface InfoCollectService {
    public Customer getCustomerById(long customer_id) throws SqlException;
    public Customer getCustomerByName(String customer_name) throws SqlException;
    public Customer setCustomerPassword(String customer_pass,String customer_name) throws SqlException;
    public Customer setCustomerUser(String customer_username) throws SqlException;

}
