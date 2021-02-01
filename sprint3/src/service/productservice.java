package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bean.Product;
import dao.ProductDao;

public class ProductService {
	Integer pid;

	ProductDao pod = new ProductDao();
		
	public void init() throws ClassNotFoundException, SQLException {
		pod.start();
	}

	public ArrayList<Product> displayAllProduct() {
		return null;
		
		
	}

	public int addProduct(Product prod) throws ClassNotFoundException, SQLException {
		int pid = pod.AddProduct(prod);	
		return pid;
	}

	public int updateProduct(Product prod2) throws ClassNotFoundException, SQLException{
		Product prod = null;
		int status = pod.updateProduct(prod);
		return status;
	}

	public int deleteProduct(int id) throws ClassNotFoundException, SQLException {

		int id1 = pod.deleteProduct(pid);
		return id1;
	}


	public Collection<Product> displayAllProductNameAsc() throws ClassNotFoundException, SQLException {
		Comparator<Product> sortName = (Product p1, Product p2)->p1.getPname().compareTo(p2.getPname());
		
		return (ArrayList<Product>) pod.displayProduct().stream().sorted(sortName).collect(Collectors.toList());
	
	}

	public Collection<Product> displayAllProductNameDsc() throws ClassNotFoundException, SQLException {
		Comparator<Product> sortName = (Product p1, Product p2)->p2.getPname().compareTo(p1.getPname());
		
		return (ArrayList<Product>) pod.displayProduct().stream().sorted(sortName).collect(Collectors.toList());
	
	}

	public Collection<Product> displayAllProductPriceAsc() throws ClassNotFoundException, SQLException {

        Comparator<Product> sortName = (Product p1, Product p2)->(int)(p1.getPrice()-p2.getPrice());
		
		return (ArrayList<Product>) pod.displayProduct().stream().sorted(sortName).collect(Collectors.toList());
	
	}

	public Collection<Product> displayAllProductPriceDsc() throws ClassNotFoundException, SQLException {
		 Comparator<Product> sortName = (Product p1, Product p2)->(int)(p2.getPrice()-p1.getPrice());
			
		 return (ArrayList<Product>) pod.displayProduct().stream().sorted(sortName).collect(Collectors.toList());
}

	

	

}
