import java.awt.Window.Type;

public class TestEmployee {
	public static void main (String[] args){
		Employee Emp_1;
		Address[] Addlist= new Address[5];
		Address Add1= new Address("Queen",48,"K1P1N2");
		Addlist[0]=Add1;
		Address Add2= new Address("King Edward",800,"K1N6N5");
		Addlist[1]=Add2;
		Emp_1=new Employee ("Falco",40,15.50, Addlist);
		
		System.out.println(Emp_1);
		System.out.println(Addlist[0]);
		;
	}
	
	
}
