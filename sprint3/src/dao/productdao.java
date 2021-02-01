package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.Product;


public class ProductDao {
	
	Connection con = null;
	boolean flag;
	int pid;
	PreparedStatement c=null;
	ResultSet rs=null;
	boolean flagCheck = true;
	
	public void start() throws ClassNotFoundException, SQLException
	{
		if(flagCheck)
		{
			con = ResourceDB.getDbConnection();
			System.out.println("Connection Is Esatablished " + con);
			System.out.println();
			flagCheck=false;
		}
	}
	
	public int AddProduct(Product p) throws SQLException, ClassNotFoundException
	{
		start();
		boolean flag = true;
		try {
		Connection con = null;
		PreparedStatement C = con.prepareStatement("select pid from Product where pid = (select max(pid) from product)");
		ResultSet rs = C.executeQuery();
		int pid = 0;
		while(rs.next())
		{
			pid = rs.getInt(1);
			pid++;
		}
		C = con.prepareStatement("select pname from product");
		rs = C.executeQuery();
		while(rs.next())
		{
			if(rs.getString(1).equals(p.getPname()))
			{
				System.out.println("Product Already In Database : "+p.getPname());
				flag = false;
			}
		}
		if(flag)
		{
			p.setPid(pid);
			PreparedStatement ps = con.prepareStatement("insert into Product values(?,?,?)");
			ps.setInt(1,p.getPid() );
			ps.setString(2, p.getPname());
			ps.setFloat(3, p.getPrice());
			int res = ps.executeUpdate();
			return res;
		}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Realeated Error : " + e);
			return 0;
		}
		return 0;
	}

	public int updateProduct(Product p) throws SQLException, ClassNotFoundException
	{
		start();
		PreparedStatement c;
		int flag1 = 0;
		flag=true;
		boolean flag2=false;
		try
		{
			c = con.prepareStatement("select pid from Product");
			rs = c.executeQuery();
			while(rs.next())
			{
				pid = rs.getInt(1);
				if(pid == p.getPid())
				{
					flag2=true;
				}
			}
			if(!flag2)
				System.out.println("Product Id Not Found");
			c = con.prepareStatement("select pname from product");
			rs = c.executeQuery();
			while(rs.next())
			{
				if(rs.getString(1).equals(p.getPname()))
				{
					System.out.println("Product Already In Database : "+p.getPname());
					flag = false;
				}
			}
			if(flag && flag2)
			{
				c = con.prepareStatement("update Product set price = ?,pname = ? where pid = ?");
				c.setFloat(1, p.getPrice());
				c.setString(2, p.getPname());
				c.setInt(3, p.getPid());
				flag1 = c.executeUpdate();
				return flag1;
			}
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return flag1;
	}
	public int deleteProduct(int pid) throws SQLException, ClassNotFoundException
	{
		start();
		
		int flag1 = 0;
		flag=true;
		boolean flag2=false;
		try
		{
			c = con.prepareStatement("select pid from Product");
			rs = c.executeQuery();
			while(rs.next())
			{
				int piddemo = rs.getInt(1);
				if(piddemo == pid)
				{
					flag2=true;
				}
			}
			if(!flag2)
				System.out.println("Product Id Not Found");
			if(flag2)
			{
				c = con.prepareStatement("delete from Product where pid = ?");
				c.setInt(1, pid);
				int flag = c.executeUpdate();
				return flag;
			}
			else
				return 0;
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
			
	}
	
	public ArrayList displayProduct() throws SQLException, ClassNotFoundException
	{
		start();
		PreparedStatement c = con.prepareStatement("select * from Product");
		ResultSet rs = c.executeQuery();
		ArrayList<Product> demoProduct = new ArrayList<>();
		while(rs.next())
		{
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			demoProduct.add(p);
		}
		return demoProduct;
		
	}
}
