package com.bankapp.service.impl;

import com.bankapp.exception.SqlException;
import com.bankapp.impl.BankServiceDAO;
import com.bankapp.impl.BankServiceDAOImpl;
import com.bankapp.model.Customer;
import com.bankapp.service.InfoCollectService;

public class InfoCollectServiceImpl implements InfoCollectService {
    private BankServiceDAO bankServiceDAO= new BankServiceDAOImpl();
    @Override
    public Customer getCustomerById(long customer_id) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.getCustomerById(customer_id);
        return customer;
    }

    @Override
    public Customer getCustomerByName(String customer_name) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.getCustomerByName(customer_name);
        return customer;

    }

    @Override
    public Customer setCustomerPassword(String customer_pass, String customer_name) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.setCustomerPassword (customer_pass,customer_name);
        return customer;
    }

    @Override
    public Customer setCustomerUser(String customer_username) throws SqlException {
        return null;
    }
}
