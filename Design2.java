
public class Design2 extends Design5 {
	  
	public Design2(char type, double xOrRho, double yOrTheta) {
		if(type == 'C'){
			this.xOrRho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
			this.yOrTheta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
		} else if ( type == 'P') {
			this.xOrRho = xOrRho;
			this.yOrTheta = yOrTheta;
		} else
			throw new IllegalArgumentException();    	
		typeCoord = type;
	}
	  
	//Instance methods **************************************************
	public double getX() { 
		return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
	}
	
	public double getY() { 
	      return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
	}
	  
	public double getRho() {
		return xOrRho;
	}
	  
	public double getTheta() {
		return yOrTheta;
	}
	
	public Design2 rotatePoint(double rotation)
        {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new Design2('C',
		(Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
		(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
        }
	
	public double getDistance(Design5 pointB)
        {
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
        }
	
	public void convertStorageToPolar()
	{
		if(typeCoord != 'P')
		{
			//Calculate RHO and THETA
			double temp = getRho();
			yOrTheta = getTheta();
			xOrRho = temp;

			typeCoord = 'P';  //Change coord type identifier
		}
	}
	
	public void convertStorageToCartesian()
	{
		if(typeCoord != 'C')
		{
			//Calculate X and Y
			double temp = getX();
			yOrTheta = getY();
			xOrRho = temp;

			typeCoord = 'C';	//Change coord type identifier
		}
	}
	  
	 
	  

}
