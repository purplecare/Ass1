
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
	  
	 
	  

}
