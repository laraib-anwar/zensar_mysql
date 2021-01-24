package Main;

import java.util.ArrayList;
import java.util.Scanner;



import Service.*;
import bean.Product;


public class ProductOperation {

	private Object displayAllProduct;

	public static void main(String[] args) {
		int count=0;
		Scanner sc =new Scanner(System.in);
		ProductService PS=new ProductService();
		 ArrayList<Product> arr = PS.retrieveProduct();
		 	ProductService.displayAllProduct();
		 	ArrayList<Product> list =displayAllProduct.list;
		 	System.out.println(list);   
		 

	}

}
