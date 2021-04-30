package com.bankapp.service.impl;

import com.bankapp.exception.SqlException;
import com.bankapp.impl.BankServiceDAO;
import com.bankapp.impl.BankServiceDAOImpl;
import com.bankapp.model.BankAccounts;
import com.bankapp.model.Customer;
import com.bankapp.model.Employee;
import com.bankapp.service.InfoCollectService;

import java.util.List;

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

    @Override
    public Customer userValidation(long customer_id, String customer_pass) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.userValidation(customer_id, customer_pass);
        return customer;
    }

    @Override
    public Employee userValidation2(int employee_id, String employee_pass) throws SqlException {
        Employee employee=null;
        employee=bankServiceDAO.userValidation2(employee_id, employee_pass);
        return employee;
    }

    @Override
    public Employee userLookup(long customer_id, String customer_name) throws SqlException {
        Employee employee=null;
        employee=bankServiceDAO.userLookup(customer_id, customer_name);
        return employee;
    }

    @Override
    public Customer inputCustomer(String customer_name, int customer_age, String customer_pass) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.inputCustomer (customer_name, customer_age, customer_pass);
        return customer;
    }

    @Override
    public Employee accountApproval(int account_id) throws SqlException {
        Employee employee=null;
        employee=bankServiceDAO.accountApproval(account_id);
        return employee;
    }

    @Override
    public Employee accountDenial(int account_id) throws SqlException {
        Employee employee=null;
        employee=bankServiceDAO.accountDenial(account_id);
        return employee;
    }

    @Override
    public List<Customer> getCustomers() throws SqlException {
       return bankServiceDAO.getCustomers();
 }

    @Override
    public Customer depositChecking(int checking_account,  long customer_id) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.depositChecking(checking_account, customer_id);
        return customer;
    }

    @Override
    public Customer setUpAccount(String customer_name, int checking_account, int account_id, long customer_id, int savings_account) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.setUpAccount(customer_name, checking_account, account_id, customer_id, savings_account);
        return customer;
    }

    @Override
    public Customer setUpCustomer(String customer_name, long customer_id, int customer_age, String customer_pass) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.setUpCustomer(customer_name, customer_id, customer_age, customer_pass);
        return customer;
    }

    @Override
    public Customer withdrawChecking(int checking_account, long customer_id) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.withdrawChecking(checking_account, customer_id);
        return customer;
    }

    @Override
    public Customer withdrawSavings(int savings_account, long customer_id) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.withdrawSavings(savings_account, customer_id);
        return customer;
    }

    @Override
    public Customer depositSavings(int savings_account, long customer_id) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.depositSavings(savings_account, customer_id);
        return customer;
    }

    @Override
    public Customer checkingValidate(long customer_id, int checking_account) throws SqlException {
        Customer customer=null;
        customer=bankServiceDAO.checkingValidate(customer_id, checking_account );
        return customer;
    }


}


