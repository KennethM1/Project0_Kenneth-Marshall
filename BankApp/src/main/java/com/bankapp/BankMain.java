package com.bankapp;

import com.bankapp.exception.SqlException;
import com.bankapp.model.Customer;
import com.bankapp.model.Employee;
import com.bankapp.service.InfoCollectService;
import com.bankapp.service.impl.InfoCollectServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        System.out.println("============Welcome to The Bank of Kenneth================");
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
                        long lg = scan2.nextLong();
                        scan2.nextLine();

                        System.out.println("============================");
                        System.out.println("Please Enter Your Password");
                        System.out.println("============================");
                        String pw = scan2.nextLine();
                        //System.out.println(pw +lg);
                        //int mm = scan2.nextLine();
                        InfoCollectService infoCollectService = new InfoCollectServiceImpl();
                        try {
                            Customer customer = infoCollectService.userValidation(lg,pw);
                            System.out.println(customer);
                        } catch (SqlException e) {
                            System.out.println("Invalid input");;
                        }
                    }else if (bh == 2 ){
                        System.out.println("============================");
                        System.out.println("Please Enter Your EmployeeID");
                        System.out.println("============================");
                        int lg = scan2.nextInt();
                        scan2.nextLine();

                        System.out.println("============================");
                        System.out.println("Please Enter Your Password");
                        System.out.println("============================");
                        String pw = scan2.nextLine();
                        InfoCollectService infoCollectService = new InfoCollectServiceImpl();
                        try {
                            Employee employee= infoCollectService.userValidation2(lg,pw);
                            if (lg !=1911){
                                break;
                            }

                        } catch (SqlException e) {
                            System.out.println("Invalid Input");

                        }

                        int empl=0;
                        do{
                            System.out.println("============================");
                            System.out.println("1)View Specific Customer Accounts");
                            System.out.println("2)View all Customer Accounts");
                            System.out.println("3)Approve a Customer Account");
                            System.out.println("4)View all Transactions");
                            System.out.println("5)Exit");
                            System.out.println("Enter your choice(1-5) : ");

                            empl = Integer.parseInt(scanner.nextLine());


                            switch (empl){
                                case 1:

                                    System.out.println("============================");
                                    System.out.println("============================");
                                    System.out.println("Please Enter Specific Customer ID");
                                    System.out.println("============================");
                                    int emp1 = scan2.nextInt();
                                    scan2.nextLine();
                                    System.out.println("============================");
                                    System.out.println("============================");
                                    System.out.println("Please Enter Specific Customer Name");
                                    System.out.println("============================");
                                    String emp2 = scan2.nextLine();
                                    InfoCollectService infoCollectService2 = new InfoCollectServiceImpl();
                                    try {
                                        Employee employee= infoCollectService2.userLookup(emp1,emp2);
                                    } catch (SqlException e) {
                                        System.out.println("The Employee ID and Password entered does not match our records");

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
                    System.out.println("=============The================");
                    System.out.println("=============Bank===============");
                    System.out.println("==============Of================");
                    System.out.println("===========Kenneth==============");
                    System.out.println("================================");
                    System.out.println("================================");
                    System.out.println("  \"A Happy Home for Your Money\"  ;)");
                    System.out.println("=================================");
                    System.out.println("================================");
                    System.out.println("=================================");
                    System.out.println("=================================");
                    System.out.println("===================================");
                    System.out.println("==================================");
                    System.out.println("Please enter your first name");
                    String login_name =scan3.nextLine();
                    System.out.println("Please enter your age");
                    String login_age =scan3.nextLine();
                    System.out.println("Please enter your initial deposit amount");
                    Integer login_deposit =scan3.nextInt();
                    scan3.nextLine();
                    System.out.println("Please enter your password");
                    String login_pass =scan3.nextLine();
                    long randomNum = (long)(Math.random() * 900);
                    //randomNum=customer_id;
                    System.out.println("Thank You! Your information will be viewed and either approved or rejected by our staff");

                    break;



                case 3:
                    System.out.println("Thanks for using the App :) ");
                    break;
                default:
                    System.out.println("Invalid Input!!!!!! Your choice should be between 1-9 only........");

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
        //c1.setAccount_balance();
        System.out.println("============================");
        System.out.println("1)View Checkings Account");
        System.out.println("2)View Savings Account");
        System.out.println("3)Deposit into Checkings");
        System.out.println("3)Deposit into Savings");
        System.out.println("4)Exit");
        System.out.println("Enter your choice(1-4) : ");


        /*BankServiceDAOImpl test = new BankServiceDAOImpl();
            Customer customer = new Customer();
        //System.out.println(customer.getAccount_id(1000));
        //System.out.println(read.getCustomer_name());
        try {customer= test.getCustomerById(102);
            //System.out.println(test.getCustomerById());
        } catch (SqlException e) {
            e.printStackTrace();

        }
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
            System.out.println("oops");*/

        }
    }
