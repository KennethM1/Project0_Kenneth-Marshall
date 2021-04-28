package com.bankapp.impl;

import com.bankapp.dao.dbutil.PostgresSqlConnection;
import com.bankapp.exception.SqlException;
import com.bankapp.model.CheckingAccounts;
import com.bankapp.model.Customer;
import com.bankapp.model.Employee;
import com.bankapp.service.InfoCollectService;

import java.sql.*;

public class BankServiceDAOImpl implements BankServiceDAO {



    @Override
    public Customer getCustomerById(long customer_id) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT customer_name, customer_id, customer_age\n" +
                    "FROM bank_schema.customer where customer_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,customer_id);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            System.out.println(resultSet.getString("customer_name"));
            System.out.println(resultSet.getInt("customer_id"));
            System.out.println(resultSet.getInt("customer_age"));
            }



        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            //throw new SqlException("Internal error occured.. Contact sysadmin");
        }
return customer;
    }

    @Override
    public Customer getCustomerByName(String customer_name) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT customer_name, customer_id, customer_age\n" +
                    "FROM bank_schema.customer Where customer_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer_name);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.print(" Name : " + resultSet.getString("customer_name"));
                System.out.print(" ID : " + resultSet.getInt("customer_id"));
                System.out.print(" Age : " + resultSet.getInt("customer_age"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("Internal error occured.. Contact sysadmin");
        }
        return customer;
    }

    @Override
    public Customer setCustomerPassword(String customer_pass, String customer_name) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "UPDATE bank_schema.customer set customer_pass=? where customer_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer_pass);
            preparedStatement.setString(2, customer_name);


            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("User name and password updated successfully");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("Internal error occured.. Contact sysadmin");
        }
        return customer;
    }

    @Override
    public Customer setCustomerUser(String customer_username) throws SqlException {
        return null;
    }

    @Override
    public Customer userValidation(Long customer_id, String customer_pass) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT c.customer_name, d.checking_account_id, d.customer_id, d.savings_account,d.account_balance FROM bank_schema.customer c full join bank_schema.bankaccounts d on c.customer_id=d.customer_id where d.customer_id =? and c.customer_pass =?;\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,customer_id );
            preparedStatement.setString(2, customer_pass);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.print(" Name : " + resultSet.getString("customer_name"));
                System.out.print(" Checking ID : " + resultSet.getInt("checking_account_id"));
                System.out.print(" Customer ID : " + resultSet.getInt("customer_id"));
                System.out.print(" Savings Balance : " + resultSet.getInt("savings_account"));
                System.out.print(" Checking Account Balance : " + resultSet.getFloat("account_balance"));
            }else {
                System.out.println("The Customer ID and Password entered does not match our records");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return customer;
    }

    @Override
    public Employee userValidation2(int employee_id, String employee_pass) throws SqlException {
        Employee employee = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT employee_name FROM bank_schema.employee where employee_id =? and employee_pass =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,employee_id );
            preparedStatement.setString(2, employee_pass);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.print(" Welcome to your Employee Portal" + resultSet.getString("employee_name") +" how would you like to proceed?");
            }else {
                System.out.println("The Employee ID and Password entered does not match our records");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return employee;
    }

    @Override
    public Employee userLookup(long customer_id, String customer_name) throws SqlException {
        Employee employee = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT customer_name, account_balance, customer_id, savings_account\n" +
                    "FROM bank_schema.bankaccounts where customer_id =? and customer_name =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,customer_id );
            preparedStatement.setString(2, customer_name);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.print(" Please take a look at the requested customer's information");
                System.out.println("===============================================================");
                System.out.println("Customer Name: "+ resultSet.getString("customer_name"));
                System.out.println("Customer Account Balance: "+ resultSet.getInt("account_balance"));
                System.out.println("Customer ID: "+ resultSet.getString("customer_id"));
                System.out.println("Customer Savings Account Balance: "+ resultSet.getInt("savings_account"));
            }else {
                System.out.println("The Employee ID and Password entered does not match our records");



            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return employee;
    }

    @Override
    public Customer inputCustomer(String customer_name, int customer_age, String customer_pass) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT c.customer_name, d.checking_account_id, d.customer_id, d.savings_account,d.account_balance FROM bank_schema.customer c full join bank_schema.bankaccounts d on c.customer_id=d.customer_id where d.customer_id =? and c.customer_pass =?;\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setLong(1,customer_id );
            preparedStatement.setString(2, customer_pass);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.print(" Name : " + resultSet.getString("customer_name"));
                System.out.print(" Checking ID : " + resultSet.getInt("checking_account_id"));
                System.out.print(" Customer ID : " + resultSet.getInt("customer_id"));
                System.out.print(" Savings Balance : " + resultSet.getInt("savings_account"));
                System.out.print(" Checking Account Balance : " + resultSet.getFloat("account_balance"));
            }else {
                System.out.println("The Customer ID and Password entered does not match our records");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return customer;
    }
}
/*if (resultSet.next()) {
            System.out.print(" Name : " + resultSet.getString("username"));
            System.out.print(" Name : " + resultSet.getString("name"));
            System.out.print(" City : " + resultSet.getString("password"));
            //put variables in customer and return it!
            //set name and password - but only if returned from DB
            customer.setUsername(resultSet.getString("username"));
            customer.setName(resultSet.getString("name"));
            customer.setPassword(resultSet.getString("password"));
        } */