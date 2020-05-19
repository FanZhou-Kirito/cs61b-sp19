public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}

	public static Body[] readBodies(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		Body[] planets = new Body[N];
		for (int i = 0; i < N; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass  = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets; 
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Body[] planets = NBody.readBodies(filename);
		int N = planets.length;
		double R = NBody.readRadius(filename);

		double time = 0.0;

		/** For a finishing touch, play the theme to 2001: A Space Odyssey using StdAudio 
		 *  and the file 2001.mid. 
		 */
		StdAudio.play("./audio/2001.mid");

		/** Enables double buffering.
		 * A animation technique where all drawing takes place on the offscreen canvas.
		 * Only when you call show() does your drawing get copied from the
		 * offscreen canvas to the onscreen canvas, where it is displayed
		 * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

		/** Sets up the universe so it goes from
		 * -100, -100 up to 100, 100 */
	    StdDraw.setScale(-R, R);

		while (time <= T) {
			double[] xForces = new double[N];
			double[] yForces = new double[N];

			for (int i = 0; i < N; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			
			StdDraw.clear();
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (int i = 0; i < N; i++) {
				planets[i].draw();
			}
		    StdDraw.show();

			time += dt;
		}
   		
   		/** When the simulation is over, i.e. when you’ve reached time T, you should 
   		 *  print out the final state of the universe in the same format as the input. 
   		 */

   		StdOut.printf("%d\n", N);
   		StdOut.printf("%.2e\n", R);
   		for (int i = 0; i < N; i++) {
   			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", 
   						  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
   						  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
   		}
	}
}