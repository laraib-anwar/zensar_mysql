package bean;

public class Product  implements java.io.Serializable 
	{ 
		public int pid; 
		public String pname;
		public int price;
		public Product() {} 

		public Product(int pid, String pname, int price)
		{}
		
		
	public void setId(int pid) 
    { 
        this.pid = pid; 
    } 

	public int getId() 
    { 
        return pid; 
    } 
	
	public void setpName(String pname) 
    { 
        this.pname = pname; 
    } 

	public String getpName() 
    { 
        return pname; 
    } 
	public void setPrice(int price) 
    { 
        this.price = price; 
    } 

	public int getPrice() 
    { 
        return price; 
    } 
	
}  
