package com.bankapp.impl;

import com.bankapp.dao.dbutil.PostgresSqlConnection;
import com.bankapp.exception.SqlException;
import com.bankapp.model.BankAccounts;
import com.bankapp.model.Customer;
import com.bankapp.model.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankServiceDAOImpl implements BankServiceDAO {

    private static Logger log = Logger.getLogger(BankServiceDAOImpl.class);
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
            String sql = "SELECT c.customer_name, d.account_id, d.customer_id, d.savings_account,d.checking_account, d.account_approval FROM bank_schema.customer c full join bank_schema.bankaccounts d on c.customer_id=d.customer_id where d.customer_id =? and c.customer_pass =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,customer_id );
            preparedStatement.setString(2, customer_pass);


            ResultSet resultSet = preparedStatement.executeQuery();
            boolean x = true;

            if((resultSet.next()&(resultSet.getBoolean("account_approval")==false))){
                log.info("Your bank account is awaiting approval");
            }
            else if(x) {
                log.info("Hi ");
                log.info(" Name : " + resultSet.getString("customer_name"));
                log.info(" Checking ID : " + resultSet.getInt("account_id"));
                log.info(" Customer ID : " + resultSet.getLong("customer_id"));
                log.info(" Savings Account Balance : " + resultSet.getInt("savings_account"));
                log.info(" Checking Account Balance : " + resultSet.getFloat("checking_account"));
            }else {

                log.warn("The Customer ID and Password entered does not match our records");
            }

        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
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
                log.info(" Welcome to your Employee Portal" + resultSet.getString("employee_name") +" how would you like to proceed?");
            }else {
                log.error("The Employee ID and Password entered does not match our records");
            }

        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return employee;
    }

    @Override
    public Employee userLookup(long customer_id, String customer_name) throws SqlException {
        Employee employee = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT customer_name, checking_account, customer_id, savings_account, account_approval\n" +
                    "FROM bank_schema.bankaccounts where customer_id =? and customer_name =?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,customer_id );
            preparedStatement.setString(2, customer_name);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                log.info(" Please take a look at the requested customer's information");
                log.info("===============================================================");
                log.info("Customer Name: "+ resultSet.getString("customer_name"));
                log.info("Customer ID: "+ resultSet.getString("customer_id"));
                log.info("Customer Checking Account Balance: "+ resultSet.getInt("checking_account"));
                log.info("Customer Savings Account Balance: "+ resultSet.getInt("savings_account"));
                log.info("Customer Account Status: "+ resultSet.getBoolean("account_approval"));
            }else {
                log.error("The Employee ID and Password entered does not match our records");



            }

        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
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
                log.info(" Name : " + resultSet.getString("customer_name"));
                log.info(" Checking ID : " + resultSet.getInt("checking_account_id"));
                log.info(" Customer ID : " + resultSet.getInt("customer_id"));
                log.info(" Savings Balance : " + resultSet.getInt("savings_account"));
                log.info(" Checking Account Balance : " + resultSet.getFloat("account_balance"));
            }else {
                log.error("The Customer ID and Password entered does not match our records");
            }

        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return customer;
    }

    @Override
    public Employee accountApproval(int account_id) throws SqlException {
        Employee employee = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "UPDATE bank_schema.bankaccounts\n" +
                    "SET account_approval=true\n" +
                    "WHERE account_id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,account_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                log.info("The Customer with that ID has been approved");}



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return employee;
    }

    @Override
    public Employee accountDenial(int account_id) throws SqlException {
            Employee employee = null;
            try (Connection connection = PostgresSqlConnection.getConnection()) {
                String sql = "UPDATE bank_schema.bankaccounts\n" +
                        "SET account_approval=false\n" +
                        "WHERE account_id=?;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,account_id );

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                    log.info("The Customer with that ID has been denied");

            } catch (SQLException | ClassNotFoundException e) {
                log.error(e); //This line will be replaced by logger... This is only for devs not for customers
                throw new SqlException("There has been an error related to the server");
            }
            return employee;
        }

    @Override
    public Customer depositChecking(int checking_account, long customer_id) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "UPDATE bank_schema.bankaccounts\n" +
                    "SET checking_account=checking_account+?\n" +
                    "WHERE customer_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,checking_account);
            preparedStatement.setLong(2,customer_id);

            preparedStatement.executeUpdate();
            /*if (resultSet.next()){
                System.out.println("You deposited "+customer.getDeposit_checking());}
            else {
                System.out.println("There was an error");}*/



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return customer;
    }

    @Override
    public Customer setUpAccount(String customer_name, int checking_account, int account_id, long customer_id, int savings_account) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "INSERT INTO bank_schema.bankaccounts\n" +
                    "(customer_name, account_id, checking_account, customer_id, savings_account, account_approval)\n" +
                    "VALUES(?, ?, ?, ?, ?, false);\n";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customer_name);
            preparedStatement.setInt(2,account_id);
            preparedStatement.setInt(3,checking_account);
            preparedStatement.setLong(4,customer_id);
            preparedStatement.setInt(5,savings_account);


            preparedStatement.executeUpdate();
            /*if (resultSet.next()){
                System.out.println("Thank you for registering");}
            else {
                System.out.println("There was an error");}*/



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return customer;
    }

    @Override
    public Customer setUpCustomer(String customer_name, long customer_id, int customer_age, String customer_pass) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "INSERT INTO bank_schema.customer\n" +
                    "(customer_name, customer_id, customer_age, customer_pass)\n" +
                    "VALUES(?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customer_name);
            preparedStatement.setLong(2,customer_id);
            preparedStatement.setInt(3,customer_age);
            preparedStatement.setString(4,customer_pass);

            //ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.executeUpdate();
            //System.out.println("Hi"+c);
            /*if (resultSet.next()){
                System.out.println("Thank you for registering");}
            else {
                System.out.println("There was an error");}*/



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return customer;

    }

    @Override
    public Customer withdrawChecking(int checking_account, long customer_id) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "UPDATE bank_schema.bankaccounts\n" +
                    "SET checking_account=checking_account-?\n" +
                    "WHERE customer_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,checking_account);
            preparedStatement.setLong(2,customer_id);

            preparedStatement.executeUpdate();
            /*if (resultSet.next()){
                System.out.println("You withdrew "+customer.getDeposit_checking());}
            else {
                System.out.println("There was an error");}*/



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return customer;
    }

    @Override
    public Customer withdrawSavings(int savings_account, long customer_id) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "UPDATE bank_schema.bankaccounts\n" +
                    "SET savings_account=savings_account-?\n" +
                    "WHERE customer_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,savings_account);
            preparedStatement.setLong(2,customer_id);

            preparedStatement.executeUpdate();
            /*if (resultSet.next()){
                System.out.println("You withdrew "+customer.getDeposit_checking());}
            else {
                System.out.println("There was an error");}*/



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return customer;
    }

    @Override
    public Customer depositSavings(int savings_account, long customer_id) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "UPDATE bank_schema.bankaccounts\n" +
                    "SET savings_account=savings_account+?\n" +
                    "WHERE customer_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,savings_account);
            preparedStatement.setLong(2,customer_id);

            preparedStatement.executeUpdate();
            /*if (resultSet.next()){
                System.out.println("You withdrew "+customer.getDeposit_checking());}
            else {
                System.out.println("There was an error");}*/



        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("There has been an error related to the server");
        }
        return customer;
    }

    @Override
    public Customer checkingValidate(long customer_id, int checking_account) throws SqlException {
        Customer customer = null;
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            String sql = "SELECT checking_account" +
                    "FROM bank_schema.bankaccounts where customer_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,customer_id );

            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer1=new Customer();

            if(resultSet.next()) {
                    customer1.setChecking_account(resultSet.getInt("checking_account"));


            }else {
                log.error("The Employee ID and Password entered does not match our records");



            }

        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("The Customer ID and Password entered does not match our records");
        }
        return customer;
    }


    @Override
    public List<Customer> getCustomers() throws SqlException {
        List<Customer> customerList=new ArrayList<>();
        try(Connection connection= PostgresSqlConnection.getConnection()){
            String sql="SELECT customer_name, account_id, checking_account, customer_id, savings_account, account_approval\n" +
                    "FROM bank_schema.bankaccounts;";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Customer customer=new Customer();
                customer.setCustomer_name(resultSet.getString("customer_name"));
                customer.setAccount_id(resultSet.getInt("account_id"));
                customer.setChecking_account(resultSet.getInt("checking_account"));
                customer.setCustomer_id (resultSet.getInt("customer_id"));
                customer.setSavings_account(resultSet.getInt("savings_account"));
                customer.setAccount_approval(resultSet.getBoolean("account_approval"));
                customerList.add(customer);

            }
            if(customerList.size()==0){
                throw new SqlException("No employee exist in DB as of now");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e); //This line will be replaced by logger... This is only for devs not for customers
            throw new SqlException("Internal error occured.. Contact sysadmin");
        }
        return customerList;
    }


}

