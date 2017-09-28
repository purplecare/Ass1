
public class Design3 extends Design5 {
	
	public Design3(char type, double xOrRho, double yOrTheta) {
		if(type == 'C') {
			this.xOrRho = xOrRho;
			this.yOrTheta = yOrTheta;
		} else if ( type == 'P') {
		    this.xOrRho = (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
		    this.yOrTheta = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
		} else {
			throw new IllegalArgumentException();
		}
		    	
		typeCoord = type;
	}
	
	 //Instance methods **************************************************
	public double getX() { 
		return  xOrRho;
	}
	  
	public double getY() {    
		return yOrTheta ;
	}
	  
	public double getRho() {
		return Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
	}
	  
	public double getTheta() {
		return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	}
	
	public Design3 rotatePoint(double rotation)
        {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new Design3('C',
		(Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
		(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
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
