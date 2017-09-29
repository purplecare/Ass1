
import java.io.IOException;
import java.util.Random;
public class Design5Test {
	//Class Instance Variables *****************************************************
	/**
	 * Generate a Random number to choose between C or P
	 */
	static Random randInt = new Random();
	static int randType;
	static int randDesign;
	static char type;
	static String design;
	static Design5 point;
	
	/**
	 * Variables to Determine Performance
	 */
	static long start;
	static long end;
	
	
	//Class methods *****************************************************

	/**
	* This method is responsible for the creation of the PointCP
	* object.  This can be done in two ways; the first, by using the
	* command line and running the program using <code> java 
	* PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
	* </code> and the second by getting the program to prompt the user.
	* If the user does not enter a valid sequence at the command line,
	* the program will prompte him or her.
	*
	* @param args[0] The coordinate type.  P for polar and C for
	*                cartesian.
	* @param args[1] The value of X or RHO.
	* @param args[2] The value of Y or THETA.
	*/
	public static void main(String[] args)
	{
		Design2 PointB= new Design2('C',3,4);
		int methodNum=0;
		String[] ResultList= new String[9];
		while (methodNum<9){
			long start= System.currentTimeMillis();
			for (int w = 0; w < 1500000; w++) {
				
				//Creating a random Type C or P
				randType = randInt.nextInt(2);
				if (randType == 0)
					type = 'C';
				else
					type = 'P';
				
				//Creating Random Points
				randType = randInt.nextInt(50);
				randDesign = randInt.nextInt(50);
				
				//System.out.println("Cartesian-Polar Coordinates Conversion Program");
	
				// Check if the user input coordinates from the command line
				// If he did, create the PointCP object from these arguments.
				// If he did not, prompt the user for them.
				
				
				try
				{
					if (w > 750000) {
						point = new Design2(type, randType, randDesign);
						design = "Design 2";
					}
					else {
						point = new Design3(type, randType, randDesign);
						design = "Design 3";
					}
				}
				catch(Exception e)
				{
					// If we arrive here, it is because either there were no
					// command line arguments, or they were invalid
					if(args.length != 0)
						System.out.println("Invalid arguments on command line");
	
					try
					{
						point = getInput();
					}
					catch(IOException ex)
					{
						System.out.println("Error getting input. Ending program.");
						return;
					}
				}
				
				/**
				 * Random methods to run
				 */
				
				
				if (methodNum == 0){
					point = point.rotatePoint(randType);
					System.out.println("\nWorking0\n" + design);
				}
				else if(methodNum==1) {
					point.getDistance(PointB);
					System.out.println("\nWorking1\n" + design);
	
				}
				else if(methodNum==2){
					point.convertStorageToPolar();
					System.out.println("\nWorking2\n" + design);
	
				}
				else if(methodNum==3){
					point.convertStorageToCartesian();
					System.out.println("\nWorking3\n" + design);
				}
				else if(methodNum==4){
					point.getX();
					System.out.println("\nWorking4\n" + design);
				}
				else if(methodNum==5){
					point.getY();
					System.out.println("\nWorking5\n" + design);
				}
				else if(methodNum==6){
					point.getTheta();
					System.out.println("\nWorking6\n" + design);
				}
				else if(methodNum==7){
					point.getRho();
					System.out.println("\nWorking7\n" + design);
	
				}
				else if(methodNum==8){
					point.toString();
					System.out.println("\nWorking8\n");
				}
				
				
						
				
				
				
			}
			long end = System.currentTimeMillis();
			Runtime runtime= Runtime.getRuntime();
			long UsedMemory= runtime.totalMemory()-runtime.freeMemory();
			String UsedM= new Long(UsedMemory).toString()+"mb";
			String Result=("time: "+ (end-start) + "ms "+ UsedM);
			ResultList[methodNum]=Result;
			methodNum+=1;
		}
		for (String r:ResultList){
			System.out.println(r);
		}
	}

	/**
	 * This method obtains input from the user and verifies that
	 * it is valid.  When the input is valid, it returns a PointCP
	 * object.
	 *
	 * @return A PointCP constructed using information obtained 
	 *         from the user.
	 * @throws IOException If there is an error getting input from
	 *         the user.
	 */
	private static Design2 getInput() throws IOException
	{
		byte[] buffer = new byte[1024];  //Buffer to hold byte input
		boolean isOK = false;  // Flag set if input correct
		String theInput = "";  // Input information

		//Information to be passed to the constructor
		char coordType = 'A'; // Temporary default, to be set to P or C
		double a = 0.0;
		double b = 0.0;

		// Allow the user to enter the three different arguments
		for (int i = 0; i < 3; i++)
		{
		while (!(isOK))
			{
				isOK = true;  //flag set to true assuming input will be valid

				// Prompt the user
				if (i == 0) // First argument - type of coordinates
				{
					System.out.print("Enter the type of Coordinates you "
					+ "are inputting ((C)artesian / (P)olar): ");
				}
				else // Second and third arguments
				{
					System.out.print("Enter the value of " 
					  + (coordType == 'C' 
					    ? (i == 1 ? "X " : "Y ")
					    : (i == 1 ? "Rho " : "Theta ")) 
					  + "using a decimal point(.): ");
				}

				// Get the user's input      

				// Initialize the buffer before we read the input
				for(int k=0; k<1024; k++)
					buffer[k] = '\u0020';        

				System.in.read(buffer);
				theInput = new String(buffer).trim();

				// Verify the user's input
				try
				{
					if (i == 0) // First argument -- type of coordinates
					{
						if (!((theInput.toUpperCase().charAt(0) == 'C') || (theInput.toUpperCase().charAt(0) == 'P'))) //See if P or C
						{
							//Invalid input, reset flag so user is prompted again
							isOK = false;
						}
						else
						{
							coordType = theInput.toUpperCase().charAt(0);
						}
					}
					else  // Second and third arguments
					{
						//Convert the input to double values
						if (i == 1)
							a = Double.valueOf(theInput).doubleValue();
						else
							b = Double.valueOf(theInput).doubleValue();
					}
				}
				catch(Exception e)
				{
					System.out.println("Incorrect input");
					isOK = false;  //Reset flag as so not to end while loop
				}
			}

			//Reset flag so while loop will prompt for other arguments
			isOK = false;
			}
		//Return a new PointCP object
		return (new Design2 (coordType, a, b));
	}
}

