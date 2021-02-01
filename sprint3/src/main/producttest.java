package main;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Product;
import service.ProductService;


public class ProductTest
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int i;
		int id;
		float price;
		boolean flag = true,checkFlag=true;
		int a = 1001;
		int num;
		int tmp;
		int option=0;
		String name = null;
		ArrayList<Product> pr = new ArrayList<>();
		
		ProductService ps = new ProductService();
			
		ps.init();
		
		do
		{
			System.out.println("Choose Your Option :");
			System.out.println("1) Add New Product :");
			System.out.println("2) Update existing Product :");
			System.out.println("3) Delete Product");
			System.out.println("4) 20% of Actual price");
			System.out.println("5) Display all Product by Name (Sort By Ascending Order:)");
			System.out.println("6) Display all Product by Name (Sort By Descending Order:");
			System.out.println("7) Display all Product by Price (Sort By Ascending Order:");
			System.out.println("8) Display all Product by Price (Sort By Descending Order: ");
			
			option = sc.nextInt();
			
			
			switch(option)
			{
				case 1:
						System.out.println("Enter New Product Name :");
						name = sc.next();
						System.out.println("Enter Product's Price :");
						price = sc.nextFloat();
						ArrayList<Product> list = ps.displayAllProduct();
						for(Product p : list)
						{
							if(p.getPname().equals(name))
								checkFlag=false;
						}
						Product prod = new Product();
						prod.setPid(a);
						prod.setPname(name);
						prod.setPrice(price);
						if(checkFlag)                 
						{
							id = ps.addProduct(prod);
							System.out.println();
							System.out.println("Your ID is "+id);
							System.out.println();
						}
						else
						{
							System.out.println();
							System.out.println("This product is already Registerd");
							System.out.println();
						} 
						                                    
						break;
				case 2:
						System.out.println("Enter Your Product Id :");
						id = sc.nextInt();
		
						System.out.println("Enter Product's Price :");
						price = sc.nextFloat();
						
						Product prod2 = new Product(id,name,price);
						num = ps.updateProduct(prod2);
						if(num>0) 
						{
								System.out.println("Price Updated Successfully...");
						}
						else
						{
							System.out.println("Product Not Updated Properly.");
						}
							
						break;
				case 3:
						System.out.println("Enter Your Product Id :");
						id = sc.nextInt();
						num = ps.deleteProduct(id);
						if(num>0)
						{
						     System.out.println("Product Deleted Successfully...");
						}
						else
						{
							System.out.println("Product Not Updated Properly.");
							
						}
						break;
				case 4:
						System.out.println();
						ps.displayAllProduct().stream().forEach(p9->System.out.println("Product Id : "+p9.getPid()+" Product Name : "+p9.getPname()+" Price : "+p9.getPrice()+" Margin Price : "+p9.getPrice()*0.2));
						System.out.println();
						break;
				case 5:
						System.out.println();
						ps.displayAllProductNameAsc().stream().forEach(p1->System.out.println(p1));
						System.out.println();
						break;
				case 6:
						System.out.println();
						ps.displayAllProductNameDsc().stream().forEach(p2->System.out.println(p2));
						System.out.println();
						break;
				case 7:
						System.out.println();
						ps.displayAllProductPriceAsc().stream().forEach(p3->System.out.println(p3));
						System.out.println();
						break;
				case 8:
						System.out.println();
						ps.displayAllProductPriceDsc().stream().forEach(p4->System.out.println(p4));
						System.out.println();
						break;
				
				default:
						System.out.println("Enter the correct option :");
			}
			
		}while(flag);
		
		System.out.println("test 1");
	}
}
