import java.util.Random;
public class Design2RandPointTest {
	public static void main(String[] args){
		
		int count=0;
		
		Random randint = new Random();
		int randType;
		char type;
		
		int xorRho;
		int yorTheata;
		
		Design2 pointB = new Design2('C',3,4);		//Creating New Point
		
		long start= System.currentTimeMillis();		//Start Timer
		
		while (count<10000){
			
			randType=randint.nextInt(1);
			
			if (randType == 0)
				type='C';
			else
				type='P';
			
			xorRho=randint.nextInt(20);
			yorTheata=randint.nextInt(20);
			
			Design2 point = new Design2(type,xorRho,yorTheata);
			
			/**
			 * Random methods to run
			 */
			if (type == 'C')
				point = point.rotatePoint(randType);
			else
				point.getDistance(pointB);
			System.out.println("Working...");
			count++; 
		}
		
		long end= System.currentTimeMillis();
		System.out.println("time: "+ (end-start)+"ms");
	}

}	
