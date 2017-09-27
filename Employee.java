public class Employee {
<<<<<<< HEAD
	private String name;
	private int hr;
	private double rate;
	private Address[] addressList = new Address[5];
	public Employee(String name, int hr, double rate, Address[] addressList){
		this.name = name;
		this.hr = hr;
		this.rate = rate;
		this.addressList = addressList;
	}
	public static void main(String[] args) {
		Employee o1 = new Employee("Falcao", 40, 15.50, addressList);
	}
	//new Address("Queen",48,"K1P1N2"),new Address("King Edward",800,"K1N6N5")
=======
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

>>>>>>> 2b9d6c16ff983ec468a4c067e9f15d5bf1f03adf
}