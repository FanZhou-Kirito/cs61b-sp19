/**
 *  Tests calcDistance
 */
public class my_test {

    /**
     *  Tests calcDistance.
     */
    public static class Body {
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
            double xxPosDiff = this.xxPos - b.xxPos;
            double yyPosDiff = this.yyPos - b.yyPos;
            //double distSquare = Math.pow(xxPosDiff, 2) + Math.pow(yyPosDiff, 2);
            double distSquare = xxPosDiff*xxPosDiff + yyPosDiff*yyPosDiff;
            double dist = Math.sqrt(distSquare);
            return dist;
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
            this.xxPos = yP;
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

        /** Your Body class should NOT have a main method, because 
          * we’ll never run the Body class directly (i.e. we will 
          * never run java Body). Also, all methods should be non-static. 
          */
    }

    public static void main(String[] args) {
        checkCalcDistance();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks the Body class to make sure calcDistance works.
     */
    private static void checkCalcDistance() {
        System.out.println("Checking calcDistance...");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b3 = new Body(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        checkEquals(b1.calcDistance(b2), 1.0, "calcDistance()", 0.01);
        checkEquals(b1.calcDistance(b3), 5.0, "calcDistance()", 0.01);
    }
}
