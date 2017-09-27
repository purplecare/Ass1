public class Employee {
	private  String name;
	private int hr;
	private double rate;
	private  Address[] address_list;
	
	public Employee(String name, int hr, double rate, Address[] address_list){
		this.name = name;
		this.hr = hr;
		this.rate = rate;
		this.address_list = address_list;
		
	}
	
	public String toString(){
		return "Name: " + name + "; Hours: " + hr + "; Rate: " + rate + "; Address:( " + address_list[0] + "); Other Address:( " + address_list[1] + ")";
	}
}