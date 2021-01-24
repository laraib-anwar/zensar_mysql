package com;
import java.util.Scanner;


public class BankTransactionApp 
{
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String ch,Name;
		int Account_no,Trans_AccNo;
		float Amount;
		boolean flag=true;
		
		
		MyBank mybank = new MyBank();
		do
		{
			System.out.println();
			System.out.println("1.Create New Account");
			System.out.println("\b a.Default Details");
			System.out.println("\b b.Name and Amount to Deposit");
			System.out.println("2.Check Account Balance");
			System.out.println("3.Withdraw the Amount");
			System.out.println("4.Deposit the Amount");
			System.out.println("5.Transfer the Amount");
			System.out.println("6.Exit");
			System.out.println("Please enter the option you want to select:");
			System.out.println();

			ch = sc.next();

			switch(ch)
			{
				case "a":
							mybank.accountCreate();
							break;
				case "b":
							System.out.println("Please Enter Your Name and Amount to Deposit(and Amount should be greater then 500:");
							Name = sc.next();
							Amount = sc.nextFloat();
							mybank.accountCreate(Name,Amount);
							break;
				case "2":
							System.out.println(" Enter Your Account Number:");
							Account_no = sc.nextInt();
							mybank.checkBalance(Account_no);
							break;
				case "3":
							System.out.println(" Enter Your Account Number:");
							Account_no = sc.nextInt();
							System.out.println(" Enter Amount To Be Withdraw:");
							Amount = sc.nextFloat();
							mybank.withdraw(Account_no,Amount);
							break;
				case "4":
							System.out.println(" Enter Your Account Number:");
							Account_no = sc.nextInt();
							System.out.println("Enter Amount To Be Deposited:");
							Amount = sc.nextFloat();
							mybank.deposit(Account_no, Amount);
							break;
				case "5":
							System.out.println(" Enter Your Account Number:");
							Account_no = sc.nextInt();
							System.out.println(" Enter Transfer Account Number:");
							Trans_AccNo = sc.nextInt();
							System.out.println(" Enter Amount To Be Transfer");
							Amount = sc.nextFloat();
							mybank.transfer(Account_no,Trans_AccNo,Amount);
							break;
				case "6":
							System.out.println("Thank You For Chossing our Bank..!Please visit again..");
							flag=false;
							break;
				default:
							System.out.println("Select correct option");

							break;
			}
		}while(flag);
	}
}
