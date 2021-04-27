package com.bankapp.model;

public class Customer {
    private long customer_id;
    private String customer_name;
    private double account_balance;
    private boolean account_approved;
    private Customer customer_pass;
    private Customer customer_user;

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public Customer getCustomer_pass() {
        return customer_pass;
    }

    public void setCustomer_pass(Customer customer_pass) {
        this.customer_pass = customer_pass;
    }

    public Customer getCustomer_user() {
        return customer_user;
    }

    public void setCustomer_user(Customer customer_user) {
        this.customer_user = customer_user;
    }

    public Customer() {
    }
    public void customer_login(){

    }

    public long getAccount_id(long customer_id) {
        return customer_id;
    }

    public void setAccount_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public boolean isAccount_approved() {
        return account_approved;
    }

    public void setAccount_approved(boolean account_approved) {
        this.account_approved = account_approved;
    }
}
