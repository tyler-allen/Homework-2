

public class Cylinder {
   private final double radius;    // doesn't change after Cylinder is constructed   
   private final double height; // doesn't change after Cylinder is constructed

   private double waterHeight;  
   
    /*
     * Constructor 
     * Initially waterHeight = 0
     * 
     * If any value is less than or equal to 0, 
     * set radius and height to 1 and print "ERROR Cylinder"
     */
    public Cylinder(double radius, double height){
        this.waterHeight = 0;
        if (radius > 0 && height > 0){
            this.radius = radius;
            this.height = height;
        }
        else{
            this.radius = 1;
            this.height = 1;
            System.out.println("ERROR Cylinder");
        }
    }
    
    // Constructor
	// set waterHeight to 0
	// set radius and height to 1
    public Cylinder(){
        this.waterHeight = 0;
        this.radius = 0;
        this.height = 0;
    }
    
    // getRadius: returns the radius of the Cylinder
    public double getRadius(){return this.radius;}
    
    // getHeight: returns the height of the Cylinder
    public double getHeight(){return this.height;}
    
    // getVolume: returns the total volume of the cylinder (divided by PI)
    public double getVolume(){return this.height * Math.pow(this.radius, 2);}

    // getWaterVolume: returns the volume of water in the cylinder (divided by PI)
    public double getWaterVolume(){return this.waterHeight * Math.pow(this.radius, 2);}
    
	// toString: returns a String describing the cylinder
	//   for example, for the Cylinder with radius=10, height=12, waterHeight=4
	//   the String will be "Cylinder(volume=1200pi, waterVolume=400pi)",
	// that is the total volume and current water volume
    public String toString() {
		final String pi = "\u03c0";
        return "Cylinder(volume=" + getVolume() + pi + ", waterVolume=" + getWaterVolume() + pi + ")"; 
        
    }
    
    public void setWaterHeight(double height){
        if (height >= 0)
            this.waterHeight = height;
    }

    // pourWaterFrom
	// Move water from other into this Cylinder.
	// If you would overflow this Cylinder, *only* move the volume
	// of water that would fill this Cylinder to the top.
    public void pourWaterFrom(Cylinder other){
        if (this.getVolume() - this.getWaterVolume() >= other.getWaterVolume()){
            this.setWaterHeight(other.getWaterVolume() / Math.pow(this.radius, 2) + this.waterHeight);
            other.setWaterHeight(0);
        }
        else{
            other.setWaterHeight((other.getWaterVolume() / Math.pow(other.getRadius(), 2)) - ((this.getVolume() - this.getWaterVolume()) / Math.pow(other.getRadius(), 2)));
            this.fillToTop();
        }
    }

    // completely fills this Cylinder with water
    public void fillToTop() {
            waterHeight = height;	
    }
}
