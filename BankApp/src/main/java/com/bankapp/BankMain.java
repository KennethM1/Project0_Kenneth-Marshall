package com.bankapp;

import com.bankapp.exception.SqlException;
import com.bankapp.model.Customer;
import com.bankapp.service.InfoCollectService;
import com.bankapp.service.impl.InfoCollectServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        /*System.out.println("============Welcome to The Bank of Kenneth================");
        Scanner scanner = new Scanner(System.in);
        //EmployeeSearchService employeeSearchService=new EmployeeSearchServiceImpl();
        int ch = 0;
        do {
            //System.out.println("How would you like to proceed");
            System.out.println("============================");
            System.out.println("1)Login");
            System.out.println("2)Sign Up");
            System.out.println("3)EXIT");
            System.out.println("Enter your choice(1-3) : ");

            try {
                ch = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {

            }
            switch (ch) {
                case 1:
                    Scanner scan2 = new Scanner(System.in);
                    int bh = 0;
                    System.out.println("============================");
                    System.out.println("1. Sign in as a Customer");
                    System.out.println("========or========");
                    System.out.println("2. Sign in as a Employee");
                    System.out.println("============================");
                    bh = Integer.parseInt(scan2.nextLine());

                    if (bh == 1) {
                        System.out.println("============================");
                        System.out.println("Please Enter Your UserName");
                        System.out.println("============================");
                        int lg = Integer.parseInt(scan2.nextLine());

                        System.out.println("============================");
                        System.out.println("Please Enter Your Password");
                        System.out.println("============================");
                        int pw = Integer.parseInt(scan2.nextLine());
                        validateData(lg, pw);
                        int mm = Integer.parseInt(scan2.nextLine());
                        switch (mm){
                            case 1:
                        }

                    } else if (bh == 2) {
                        System.out.println("stop playing with me");
                    }
                    break;


                case 2:

                    System.out.println("Are you a Customer or Employee?");

                case 3:
                    System.out.println("Thankq for using the App :) ");
                    break;
                default:
                    System.out.println("Invalid Input!!!!!! Your choice should be between 1-9 only........");

            }


        } while (ch != 3);

    }
    Password validation method
    public static Customer validateData(Customer pass, Customer user) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(x);
        arrayList.add(y);
        if (arrayList.size() > 0) {
            System.out.println("==================");
            System.out.println("Access Granted!!");
            System.out.println("==================");
            accountInfo();
        } else {
            System.out.println("==================");
            System.out.println("Access Denied!!");
            System.out.println("==================");
        }
    }
    //Existing Customer Menu
    public static void accountInfo(Customer customer){
        Customer c1 = new Customer();
        c1.setAccount_balance();
        System.out.println("============================");
        System.out.println("1)View Checkings Account");
        System.out.println("2)View Savings Account");
        System.out.println("3)Deposit into Checkings");
        System.out.println("3)Deposit into Savings");
        System.out.println("4)Exit");
        System.out.println("Enter your choice(1-4) : ");*/


        /*BankServiceDAOImpl test = new BankServiceDAOImpl();
Customer customer = new Customer();
        //System.out.println(customer.getAccount_id(1000));
        //System.out.println(read.getCustomer_name());
        try {customer= test.getCustomerById(102);
            //System.out.println(test.getCustomerById());
        } catch (SqlException e) {
            e.printStackTrace();

        }*/
        InfoCollectService infoCollectService = new InfoCollectServiceImpl();
        try {
            Customer customer = infoCollectService.getCustomerByName("ben");
        } catch (SqlException e) {
            System.out.println("oops");
        }
        InfoCollectService infoCollectService2 = new InfoCollectServiceImpl();
        try {
            Customer customer = infoCollectService2.getCustomerById(100);
        } catch (SqlException e) {
            System.out.println("oops");
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++");
        InfoCollectService infoCollectService3 = new InfoCollectServiceImpl();
        try {
            Customer customer = infoCollectService3.setCustomerPassword("passk", "mike");
        } catch (SqlException e) {
            System.out.println("oops");

        }
    }
}