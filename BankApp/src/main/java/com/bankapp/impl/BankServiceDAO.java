package com.bankapp.impl;

import com.bankapp.exception.SqlException;
import com.bankapp.model.Customer;

import java.util.List;

public interface BankServiceDAO {
        public Customer getCustomerById(long customer_id) throws SqlException;
        public Customer getCustomerByName(String customer_name) throws SqlException;
        public Customer setCustomerPassword(String customer_pass,String customer_name) throws SqlException;
        public Customer setCustomerUser(String customer_username) throws SqlException;
    }

