
public abstract class Design5  {
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
	  
	 /* public Design5(char type, double xOrRho, double yOrTheta)
	  {
	    if(type != 'C' && type != 'P')
	      throw new IllegalArgumentException();
	    this.xOrRho = xOrRho;
	    this.yOrTheta = yOrTheta;
	    typeCoord = type;
	  }
	  */
	  
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
		
	  /**
	   * Converts Polar coordinates to Cartesian coordinates.
	   */
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

	   public String toString()
  {
    return "Stored as " + (typeCoord == 'C' 
       ? "Cartesian  (" + getX() + "," + getY() + ")"
       : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
	  

}
