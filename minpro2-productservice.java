package Service;

import java.io.*;
import java.util.List;
import Main.ProductOperation;
import bean.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductService { 
	

	public static  ArrayList<Product> addProduct()
    { 
		ArrayList<Product> list =new ArrayList<>();
		list.add(new Product(101,"xyz",120));
		list.add(new Product(102,"ABC",210));
		return(list);
	} 
	
	public static void updateProduct() 
	{
		ArrayList<Product> list = null ;
		list.set(0, new Product(104, "lmn",250));
	}
	
	public static void deleteProduct()
	{
		ArrayList<Product> list = null ;
		list.remove(new Product(102,"abc",210));
	}
	
	public static ArrayList<Product> displayAllProduct()
	{
		ArrayList<Product> list =new ArrayList<Product>();
		list.add(new Product(101,"xyz",120));
		list.add(new Product(102,"abc",210));
		return (list);
	}
		
	
		public ArrayList<Product> retrieveProduct()
		{
			ArrayList<Product> list =new ArrayList<Product>();
			list.add(new Product(101,"xyz",120));
			list.add(new Product(102,"abc",210));
			
			return (list);
			 
			
			   
		}
		
	

} 
