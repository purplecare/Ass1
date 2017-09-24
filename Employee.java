public class Employee {
	private  String name;
	private int hr;
	private double rate;
	private  Address[] address_list= new Address[5];
	
	public Employee(String name, int hr, double rate, Address[] address_list){
		this.name= name;
		this.hr=hr;
		this.rate=rate;
		this.address_list= address_list;
		
	}
	public String toString(){
		return this.name+this.hr+this.rate+this.address_list;
	}

}