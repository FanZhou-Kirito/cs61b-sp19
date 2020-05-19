public class Body {
	/** Its current x position. */
  public double xxPos;

	/** Its current y position. */
	public double yyPos;

	/** Its current velocity in the x direction. */
	public double xxVel;

	/** Its current velocity in the y direction. */
	public double yyVel;

	/** Its mass. */
	public double mass;

	/** The name of the file that corresponds to the image that 
	 *  depicts the body (for example, jupiter.gif) 
	 */
  public String imgFileName;

  /** Start by adding a method called "calcDistance" that 
    * calculates the distance between two "Body"s. */
  public double calcDistance(Body b) {
    double xxPosDiff = b.xxPos - this.xxPos;
    double yyPosDiff = b.yyPos - this.yyPos;
    double rSquare = Math.pow(xxPosDiff, 2) + Math.pow(yyPosDiff, 2);
    //double distSquare = xxPosDiff*xxPosDiff + yyPosDiff*yyPosDiff;
    double r = Math.sqrt(rSquare);
    return r;
  }

  /** The next method that you will implement is calcForceExertedBy. The 
    * calcForceExertedBy method takes in a Body, and returns a double 
    * describing the force exerted on this body by the given body. 
    */
  static final double G = 6.67E-11;

  public double calcForceExertedBy(Body b) {
    double r = this.calcDistance(b);
    double F = (G*this.mass*b.mass)/(Math.pow(r,2));
    return F;
  }

  /** The next two methods that you should write are "calcForceExertedByX"
    * and "calcForceExertedByY". these two methods describe the force 
    * exerted in the X and Y directions, respectively. Remember to check 
    * your signs!  
    */
  public double calcForceExertedByX(Body b) {
    double xxPosDiff = b.xxPos - this.xxPos;    
    double Fx = (this.calcForceExertedBy(b)*xxPosDiff)/this.calcDistance(b);
    return Fx;
  }
  public double calcForceExertedByY(Body b) {
    double yyPosDiff = b.yyPos - this.yyPos;    
    double Fy = (this.calcForceExertedBy(b)*yyPosDiff)/this.calcDistance(b);
    return Fy;
  }

  /** Write methods "calcNetForceExertedByX" and "calcNetForceExertedByY" 
    * that each take in an array of Bodys and calculates the net X and net 
    * force exerted by all bodies in that array upon the current Body. */
  public double calcNetForceExertedByX(Body[] bb) {
    double Fnetx = 0.0;
    for (Body b : bb) {
      if (!(this.equals(b))) {
        Fnetx = Fnetx + this.calcForceExertedByX(b);
      }
    }
    return Fnetx;
  }

  public double calcNetForceExertedByY(Body[] bb) {
    double Fnety = 0.0;
    for (Body b : bb) {
      if (!(this.equals(b))) {
        Fnety = Fnety + this.calcForceExertedByY(b);
      }
    }
    return Fnety;   
  }

  /** Write a method update(dt, fX, fY) that uses the steps above to update 
    * the body’s position and velocity instance variables (this method does 
    * not need to return anything). */
  public void update(double dt, double fX, double fY) {
    double aX = fX/this.mass;
    double aY = fY/this.mass;
    this.xxVel = this.xxVel + dt*aX;
    this.yyVel = this.yyVel + dt*aY;
    this.xxPos = this.xxPos + dt*this.xxVel;
    this.yyPos = this.yyPos + dt*this.yyVel;
  }

  /** add in two Body constructors that can initialize an 
    *  instance of the Body class.
    */
  /**  The first instance of the Body class can represent a 
    *  planet, star, or various objects in this universe. 
    */
  public Body(double xP, double yP, double xV, double yV, 
    	        double m, String img) {
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
  }

    /** The second constructor should take in a Body object and 
      * initialize an identical Body object (i.e. a copy).  
      */
  public Body(Body b) {
    this.xxPos = b.xxVel;
    this.yyPos = b.yyPos;
    this.xxVel = b.xxVel;
    this.yyVel = b.yyVel;
    this.mass = b.mass;
    this.imgFileName = b.imgFileName;
  }

  /** Add one last method to the Body class, draw, that uses the 
   *  StdDraw API mentioned above to draw the Body’s image at the 
   *  Body’s position.   
   */
  public void draw() {
    StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
  }

  /** Your Body class should NOT have a main method, because 
   * we’ll never run the Body class directly (i.e. we will 
   * never run java Body). Also, all methods should be non-static. 
   */
}