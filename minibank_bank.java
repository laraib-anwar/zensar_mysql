package com;

public interface Bank
{
	void withdraw(int Account_no, float Amount);
	void deposit(int Account_no, float Amount);
	void checkBalance(int Account_no);
}
