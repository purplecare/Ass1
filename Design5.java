
public abstract class Design5  {
	
	//Instance variables ************************************************

	/**
	 * Contains C(artesian) or P(olar) to identify the type of
	 * coordinates that are being dealt with.
	 */
	public char typeCoord;
	
	/**
	* Contains the current value of X or RHO depending on the type
	* of coordinates.
	*/
	public double xOrRho;
	  
	/**
	* Contains the current value of Y or THETA value depending on the
	* type of coordinates.
	*/
	public double yOrTheta;
	
	/**
	* Calculates the distance in between two points using the Pythagorean
	* theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	*
	* @param pointA The first point.
	* @param pointB The second point.
	* @return The distance between the two points.
	*/
        public double getDistance(Design5 pointB)
        {
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
        }
	
	/**
	* Rotates the specified point by the specified number of degrees.
	* Not required until E2.30
	*
	* @param point The point to rotate
	* @param rotation The number of degrees to rotate the point.
	* @return The rotated image of the original point.
	*/
        public abstract Design5 rotatePoint(double rotation);

	
	 //Instance methods **************************************************
	
	public double getX()
	{
		if(typeCoord == 'C') 
			return xOrRho;
		else 
			return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
	}
	  
	public double getY()
	{
		if(typeCoord == 'C') 
			return yOrTheta;
		else 
			return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
	}
	  
	public double getRho()
	{
		if(typeCoord == 'P') 
			return xOrRho;
		else 
			return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
	}
	  
	public double getTheta()
	{
		if(typeCoord == 'P')
			return yOrTheta;
		else 
			return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
	}
	
	/**
	* Converts Storage coordinates to Polar coordinates.
	*/
	public abstract void convertStorageToPolar();
		
	/**
	* Converts Polar coordinates to Cartesian coordinates.
	*/
	public abstract void convertStorageToCartesian();

	public String toString()
	{
		return "Stored as " + (typeCoord == 'C' 
		? "Cartesian  (" + getX() + "," + getY() + ")"
		: "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
	}

}
