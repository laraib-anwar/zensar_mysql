package com;

public class MyBank extends AccountIntialization implements Bank
{
	public void withdraw(int Account_no1, float Amount1)
	{
		if(account!=0)
		{
			for(int i=0;i<10;i++)
			{
				if(account[i].getAccno()==Account_no1)
				{
					if(500.0f< (account[i].getAmount()-Amount1))
					{
						account[i].setAmount(account[i].getAmount()-Amount1);
						System.out.println("\n Amount Withdrawn Successfully");
						break;
					}
					else
					{
						throw new ArithmeticException("\nMaintain minimum 500 balance");
						
					}
				}
			}
		}
		else
		{
			System.out.println("\n Create Account First");
		}
	}
	public void deposit(int Account_no1, float Ammount1)
	{
		if(account!=0)
		{

			for(int i=0;i<10;i++)
			{
				if(account[i].getAccno()==accno1)
				{
					if(ammount1<50000)
					{
						account[i].setAmount(account[i].getAmount() + Amount1);
						System.out.println("\n Amount Deposited");
						break;
					}
					else
					{
						System.out.println("\n Can deposit more than 500RS. amount: ");
						break;
					}
				}
			}
		}
		else
		{
			throw new ArithmeticException("\n Create Account first");
		}

	}
	public void checkBalance(int Account_no1)
	{
		if(account!=0)
		{
			for(int i=0;i<10;i++)
			{
				if(account[i].getAccno()== Account_no1 )
				{
					
					System.out.println("\n Balance : "+account[i].getAmount());
					break;
				}
			}
		}
		else
		{
			throw new ArithmeticException("\nAccount not created");
		}
	}

	public void transfer(int fromAccount_no , int Trans_AccNo, float Amount)
	{
		if(account!=0)
		{

			for(int i=0;i<10;i++)
			{
				if(account[i].getAccount_no()==fromAccount_no)
				{
					for(int j=0;j<10;j++)
					{
						if(account[j].getAccount_no()==toAccount_no)
						{
							if(500.0f < (account[i].getAmount()-Amount))
							{
								account[i].setAmount(account[i].getAmount()-Amount);
								account[j].setAmount(account[j].getAmount()+Amount);
								break;
							}
							else
							{
								System.out.println("\n You don't have enough balance ");
							}
						}
					}
					break;
				}
			}
		}
		else
		{
			System.out.println("\n Create Account First");
		}
	}
}
