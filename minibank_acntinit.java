package com;

import com.Account;

abstract class AccountIntialization
{
	public static int Account_no=0,AccountCopy=0;
	public static int AccNo = 101;
	public static int AccNoCopy = 101;
	public Account account[] = new Account[10];
	public String Name;
	public float Amount;
	public static int i=0,j=0;

	public void accountCreate()
	{
		if(account<10)
		{
			Name = "Unknown";
			Amount = 500;
			account[i] = new Account(AccNo,Name,Amount);
			AccNo++;
			i++;
			account++;
		}
		else
		{
			AccountCopy=1;
			System.out.println("\n Account Capacity Already Reached To Limit");
		}
	}

	public void accountCreate(String Name, float Amount)
	{
		if(AccountCopy<10)
		{
			if(Amount>500.0f)
			{
				this.Name = Name;
				this.Amount = Amount;
				account[j].setAccno(this.AccNoCopy );
				account[j].setName(this.Name);
				account[j].setAmount(this.Amount);
				System.out.println("Name : " + account[j].getName());
				System.out.println("Account Number : " + account[j].getAccno());
				AccNoCopy ++;
				AccountCopy++;
				j++;
			}
			else
			{
				throw new ArithmeticException("\nDeposited amount should be greater than 500"); 
			}
		}
		else
		{
			throw new ArithmeticException("\n Account Capacity Already Reached To Limit");
		}
	}

	abstract void transfer(int fromAccNo , int Trans_AccNo, float Amount);
}
