public class Address {
	String street;
	int number;
	String postal;
	public Address(String street, int number, String postal){
		this.street=street;
		this.number=number;
		this.postal=postal;
	}
	public String toString(){
		return this.street +this.number+this.postal;
	}

}