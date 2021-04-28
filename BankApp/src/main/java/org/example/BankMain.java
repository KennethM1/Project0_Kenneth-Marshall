package org.example;
//package com.bankapp;

import com.bankapp.exception.SqlException;
import com.bankapp.model.Customer;
import com.bankapp.model.Employee;
import com.bankapp.service.InfoCollectService;
import com.bankapp.service.impl.InfoCollectServiceImpl;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;



public class BankMain {
    private static Logger log=Logger.getLogger(BankMain.class);
    public static void main(String[] args) {
        log.trace("============Welcome to The Bank of Kenneth================");
        Scanner scanner = new Scanner(System.in);

        int ch = 0;
        do {

            log.trace("============================");
            log.trace("1)Login");
            log.trace("2)Sign Up");
            log.trace("3)EXIT");
            log.trace("Enter your choice(1-3) : ");

            try {
                ch = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {

            }
            switch (ch) {
                case 1:
                    Scanner scan2 = new Scanner(System.in);
                    int bh = 0;
                    log.trace("============================");
                    log.trace("1. Sign in as a Customer");
                    log.trace("========or========");
                    log.trace("2. Sign in as a Employee");
                    log.trace("============================");
                    bh = Integer.parseInt(scan2.nextLine());

                    if (bh == 1) {
                        log.trace("============================");
                        log.trace("Please Enter Your CustomerID");
                        log.trace("============================");
                        long lg = scan2.nextLong();
                        scan2.nextLine();

                        log.trace("============================");
                        log.trace("Please Enter Your Password");
                        log.trace("============================");
                        String pw = scan2.nextLine();

                        InfoCollectService infoCollectService = new InfoCollectServiceImpl();
                        try {
                            Customer customer = infoCollectService.userValidation(lg,pw);
                            log.trace(customer);
                        } catch (SqlException e) {
                            log.trace("Invalid input");
                        }
                    }else if (bh == 2 ){
                        log.trace("============================");
                        log.trace("Please Enter Your EmployeeID");
                        log.trace("============================");
                        int lg = scan2.nextInt();
                        scan2.nextLine();

                        log.trace("============================");
                        log.trace("Please Enter Your Password");
                        log.trace("============================");
                        String pw = scan2.nextLine();
                        InfoCollectService infoCollectService = new InfoCollectServiceImpl();
                        try {
                            Employee employee= infoCollectService.userValidation2(lg,pw);
                            if (lg !=1911){
                                break;
                            }

                        } catch (SqlException e) {
                            log.trace("Invalid Input");

                        }

                        int empl=0;
                        do{
                            log.trace("============================");
                            log.trace("1)View Specific Customer Accounts");
                            log.trace("2)View all Customer Accounts");
                            log.trace("3)Approve a Customer Account");
                            log.trace("4)View all Transactions");
                            log.trace("5)Exit");
                            log.trace("Enter your choice(1-5) : ");

                            empl = Integer.parseInt(scanner.nextLine());


                            switch (empl){
                                case 1:

                                    log.trace("============================");
                                    log.trace("============================");
                                    log.trace("Please Enter Specific Customer ID");
                                    log.trace("============================");
                                    int emp1 = scan2.nextInt();
                                    scan2.nextLine();
                                    log.trace("============================");
                                    log.trace("============================");
                                    log.trace("Please Enter Specific Customer Name");
                                    log.trace("============================");
                                    String emp2 = scan2.nextLine();
                                    InfoCollectService infoCollectService2 = new InfoCollectServiceImpl();
                                    try {
                                        Employee employee= infoCollectService2.userLookup(emp1,emp2);
                                    } catch (SqlException e) {
                                        log.trace("The Employee ID and Password entered does not match our records");

                                    }

                                case 2:

                                case 3:

                                case 4:

                                case 5:

                            }

                             }while (empl!=5);
                    }
                    break;


                case 2:
                    //int bh = 0;
                    Scanner scan3 = new Scanner(System.in);
                    log.trace("=============The================");
                    log.trace("=============Bank===============");
                    log.trace("==============Of================");
                    log.trace("===========Kenneth==============");
                    log.trace("================================");
                    log.trace("================================");
                    log.trace("  \"A Happy Home for Your Money\"  ;)");
                    log.trace("=================================");
                    log.trace("================================");
                    log.trace("=================================");
                    log.trace("=================================");
                    log.trace("===================================");
                    log.trace("==================================");
                    log.trace("Please enter your first name");
                    String login_name =scan3.nextLine();
                    log.trace("Please enter your age");
                    String login_age =scan3.nextLine();
                    log.trace("Please enter your initial deposit amount");
                    Integer login_deposit =scan3.nextInt();
                    scan3.nextLine();
                    log.trace("Please enter your password");
                    String login_pass =scan3.nextLine();
                    long randomNum = (long)(Math.random() * 900);
                    //randomNum=customer_id;
                    System.out.println("Thank You! Your information will be viewed and either approved or rejected by our staff");

                    break;



                case 3:
                    log.trace("Thanks for using the App :) ");
                    break;
                default:
                    log.trace("Invalid Input!!!!!! Your choice should be between 1-9 only........");

            }


        } while (ch != 3);

    }
    //Password validation method
   /* public static userValidation(Customer customer_id, Customer customer_pass) {
        ArrayList<Customer> arrayList = new ArrayList<>();
        arrayList.add(pass);
        arrayList.add(user);
        if (arrayList.size() > 0) {
            System.out.println("==================");
            System.out.println("Access Granted!!");
            System.out.println("==================");
            //accountInfo();
        } else {
            System.out.println("==================");
            System.out.println("Access Denied!!");
            System.out.println("==================");
            return Customer;
        }
    }*/
    //Existing Customer Menu
    public static void accountInfo(Customer customer){
        Customer c1 = new Customer();
        log.trace("============================");
        log.trace("1)View Checkings Account");
        log.trace("2)View Savings Account");
        log.trace("3)Deposit into Checkings");
        log.trace("3)Deposit into Savings");
        log.trace("4)Exit");
        log.trace("Enter your choice(1-4) : ");



        }
    }
