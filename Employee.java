public class Employee {
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
}