package com.bankapp.impl;

import com.bankapp.dao.dbutil.PostgresSqlConnection;
import com.bankapp.exception.SqlException;
import com.bankapp.model.CheckingAccounts;
import com.bankapp.model.Customer;
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