package com.bankapp.impl;

import com.bankapp.exception.SqlException;
import com.bankapp.model.Customer;
import com.bankapp.model.Employee;

import java.util.List;

public interface BankServiceDAO {
        public Customer getCustomerById(long customer_id) throws SqlException;
        public Customer getCustomerByName(String customer_name) throws SqlException;
        public Customer setCustomerPassword(String customer_pass,String customer_name) throws SqlException;
        public Customer setCustomerUser(String customer_username) throws SqlException;
        public Customer userValidation(Long customer_id, String customer_pass) throws SqlException;
        public Employee userValidation2(int employee_id, String employee_pass) throws SqlException;
        public Employee userLookup(long customer_id, String customer_name) throws SqlException;
        public Customer inputCustomer(String customer_name, int customer_age, String customer_pass) throws SqlException;
    }

