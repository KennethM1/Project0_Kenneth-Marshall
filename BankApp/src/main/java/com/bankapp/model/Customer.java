package com.bankapp.model;

public class Customer {
    private long account_id;
    private String name;
    private double account_balance;

    public Customer() {
    }

    public Customer(long account_id, String name, double account_balance) {
        this.account_id = account_id;
        this.name = name;
        this.account_balance = account_balance;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    @Override
    public String toString() {
        return "CustomerClass{" +
                "account_id=" + account_id +
                ", name='" + name + '\'' +
                ", account_balance=" + account_balance +
                '}';
    }

}
