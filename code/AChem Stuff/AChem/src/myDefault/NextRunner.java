package myDefault;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NextRunner {
	public static ArrayList<Particle> Particles = new ArrayList<>();
	public static final double electronMass = 0.000544617022596;
	public static final double protonMass = 1; // masses relative to protons
	public static final double hardScale = 1;
	public static final int threadPoolSize = 12;
	public static ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize);
	private static double speedMult = 100000;
	public static int unit = 100000000;
	private static int totParts = 70;
	public static Random rand = new Random(4);
	public static ArrayList<String> molecules = new ArrayList<>();
	public static boolean automove = true;

	public static void main(String[] args) {
		try {
			test4();
		} catch (Exception a) {
		} catch (Throwable g) {

		}
	}

	private static void sugar() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		
		//The ring
		for(double i = 0; i<5;i++) {
			Particle temp = new Particle(new double[] { 0.4*Math.cos(i*3/Math.PI)*unit * hardScale,0.4* Math.sin(i*3/Math.PI)*unit * hardScale, 0},1.0, protonMass);
			temp.maxBonds = 4;
			Particles.add(temp);
		}
		Particle temp = new Particle(new double[] { 0.4*Math.cos(5.0*3/Math.PI)*unit * hardScale,0.4* Math.sin(5.0*3/Math.PI)*unit * hardScale, 0},1.0, protonMass);
		temp.maxBonds = 2;
		Particles.add(temp);
		
		//Hydrogen attached to carbon
		for(int i = 0; i<5;i++) {
			temp = new Particle(new double[] { 0.3*Math.cos(i*3/Math.PI)*unit * hardScale,0.3* Math.sin(i*3/Math.PI)*unit * hardScale, 0.3},1.0, protonMass);
			temp.maxBonds = 1;
			Particles.add(temp);
		}
		
//		//oxygens off carbon
//		for(int i = 0; i<4;i++) {
//			temp = new Particle(new double[] { 0.3*Math.cos(i*3/Math.PI)*unit * hardScale,0.3* Math.sin(i*3/Math.PI)*unit * hardScale, -0.3},1.0, protonMass);
//			temp.maxBonds = 2;
//			Particles.add(temp);
//		}
//		
//		//hydrogens off oxygen
//		for(int i = 0; i<4;i++) {
//			temp = new Particle(new double[] { 0.3*Math.cos(i*3/Math.PI)*unit * hardScale,0.3* Math.sin(i*3/Math.PI)*unit * hardScale, 1.3},1.0, protonMass);
//			temp.maxBonds = 1;
//			Particles.add(temp);
//		}
//		
//		//one off carbon 
//		temp = new Particle(new double[] { 0.3*Math.cos(5*3/Math.PI)*unit * hardScale,0.3* Math.sin(5*3/Math.PI)*unit * hardScale, -1},1.0, protonMass);
//		temp.maxBonds = 4;
//		Particles.add(temp);
//		
//		//one off oxygen 
//		temp = new Particle(new double[] { 0.3*Math.cos(5*3/Math.PI)*unit * hardScale,0.3* Math.sin(5*3/Math.PI)*unit * hardScale, -2},1.0, protonMass);
//		temp.maxBonds = 2;
//		Particles.add(temp);
//		
//		//3 hydrogen 
//		temp = new Particle(new double[] { 0.3*Math.cos(5.5*3/Math.PI)*unit * hardScale,0.3* Math.sin(5*3/Math.PI)*unit * hardScale, -2},1.0, protonMass);
//		temp.maxBonds = 1;
//		Particles.add(temp);
//		temp = new Particle(new double[] { 0.3*Math.cos(4.5*3/Math.PI)*unit * hardScale,0.3* Math.sin(5*3/Math.PI)*unit * hardScale, -2},1.0, protonMass);
//		temp.maxBonds = 1;
//		Particles.add(temp);
//		temp = new Particle(new double[] { 0.3*Math.cos(5*3/Math.PI)*unit * hardScale,0.3* Math.sin(5*3/Math.PI)*unit * hardScale, -3},1.0, protonMass);
//		temp.maxBonds = 1;
//		Particles.add(temp);
		


	long lastTime = System.currentTimeMillis();
	int w = 0;while(true)
	{
		w++;
		if (w > 100000 && w % 10000 == 0) {
			HashStyle Hash = new HashStyle(Particles);
			for (String book : Hash.library) {
				if (!molecules.contains(book)) {
					molecules.add(book);
					rebonding(book);
				}
			}
			System.out.println((w / 10000) - 10);
			for (String mole : molecules) {
				System.out.println(mole);
			}
		}

		for (Particle p : Particles) {
			changeVel(p);
		}
		for (Particle p : Particles) {
			move(p);
		}

		Viewer.myComponent.newSquares(Particles);
		Viewer.myComponent.newLines(Particles);
		seer.update();
		long currentTime = System.currentTimeMillis();
		// System.out.println(currentTime-lastTime);
		lastTime = currentTime;
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	}

	private static void test4() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		for (int i = -1; i < 2; i+=2) {
			for (int j = -1; j < 2; j+=2) {
				for (int k = -1; k < 2; k+=2) {
					Particle temp = new Particle(new double[] {0.5*i * unit * hardScale,0.5*j*unit * hardScale, 0.5*k*unit*hardScale }, 1.0, protonMass);
					Particles.add(temp);
					temp.maxBonds = 3;
				}
			}
		}
		

		long lastTime = System.currentTimeMillis();
		int w = 0;
		while (true) {
			w++;
			if (w > 100000 && w % 10000 == 0) {
				HashStyle Hash = new HashStyle(Particles);
				for (String book : Hash.library) {
					if (!molecules.contains(book)) {
						molecules.add(book);
						rebonding(book);
					}
				}
				System.out.println((w / 10000) - 10);
				for (String mole : molecules) {
					System.out.println(mole);
				}
			}

			for (Particle p : Particles) {
				changeVel(p);
			}
			for (Particle p : Particles) {
				move(p);
			}

			Viewer.myComponent.newSquares(Particles);
			Viewer.myComponent.newLines(Particles);
			seer.update();
			long currentTime = System.currentTimeMillis();
			// System.out.println(currentTime-lastTime);
			lastTime = currentTime;
//			try {
//				TimeUnit.MILLISECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

	private static void test3() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		for (int i = -totParts / 4; i < totParts / 4; i++) {
			Particle temp = new Particle(new double[] { 0.5*i * unit * hardScale,-0*unit * hardScale, 0 }, 1.0, protonMass);
			Particles.add(temp);
			temp.maxBonds = 3;
		}
		for (int i = -totParts / 4; i < totParts / 4; i++) {
			Particle temp = new Particle(new double[] {0.5* i * unit * hardScale,-0.5*unit * hardScale, 0.1}, 1.0, protonMass);
			temp.unbreakableBond=true;
			Particles.add(temp);
			temp.maxBonds = 1;
//			temp = new Particle(new double[] { 0.5*i * unit * hardScale,0.5*unit * hardScale, 0}, 1.0, protonMass);
//			temp.unbreakableBond=true;
//			Particles.add(temp);
//			temp.maxBonds = 1;
		}
		

		long lastTime = System.currentTimeMillis();
		int w = 0;
		while (true) {
			w++;
			if (w > 100000 && w % 10000 == 0) {
				HashStyle Hash = new HashStyle(Particles);
				for (String book : Hash.library) {
					if (!molecules.contains(book)) {
						molecules.add(book);
						rebonding(book);
					}
				}
				System.out.println((w / 10000) - 10);
				for (String mole : molecules) {
					System.out.println(mole);
				}
			}

			for (Particle p : Particles) {
				changeVel(p);
			}
			for (Particle p : Particles) {
				move(p);
			}

			Viewer.myComponent.newSquares(Particles);
			Viewer.myComponent.newLines(Particles);
			seer.update();
			long currentTime = System.currentTimeMillis();
			// System.out.println(currentTime-lastTime);
			lastTime = currentTime;
//			try {
//				TimeUnit.MILLISECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

	private static void test2() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		Particle temp = new Particle(new double[] { rand.nextDouble(0, 15) * unit * hardScale,
				rand.nextDouble(0, 10) * unit * hardScale, 0 }, 1.0, protonMass);
//		temp.maxBonds = 3;
//		Particles.add(temp);
		for (int i = 0; i < totParts; i++) {
			temp = new Particle(new double[] { rand.nextDouble(0, 5) * unit * hardScale,
					rand.nextDouble(0, 5) * unit * hardScale, rand.nextDouble(0, 5) * unit * hardScale }, 1.0, protonMass);
			temp.maxBonds = 2;
			Particles.add(temp);
		}

		long lastTime = System.currentTimeMillis();
		int w = 0;
		while (true) {
			w++;
			if (w > 100000 && w % 10000 == 0) {
				HashStyle Hash = new HashStyle(Particles);
				for (String book : Hash.library) {
					if (!molecules.contains(book)) {
						molecules.add(book);
						rebonding(book);
					}
				}
				System.out.println((w / 10000) - 10);
				for (String mole : molecules) {
					System.out.println(mole);
				}
			}

			for (Particle p : Particles) {
				changeVel(p);
			}
			for (Particle p : Particles) {
				move(p);
			}

			Viewer.myComponent.newSquares(Particles);
			Viewer.myComponent.newLines(Particles);
			seer.update();
			long currentTime = System.currentTimeMillis();
			// System.out.println(currentTime-lastTime);
			lastTime = currentTime;
//			try {
//				TimeUnit.MILLISECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

	private static void test1() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		for (int i = 0; i < totParts/2; i++) {
			Particle temp = new Particle(new double[] { rand.nextDouble(-5, 5) * unit * hardScale,
					rand.nextDouble(-5, 5) * unit * hardScale, rand.nextDouble(-5, 5) * unit * hardScale }, 1.0, protonMass);
			temp.unbreakableBond=true;
			Particles.add(temp);
			temp.maxBonds = 1;
		}
		for (int i = 0; i < totParts / 2; i++) {
			Particle temp = new Particle(new double[] { rand.nextDouble(-5, 5) * unit * hardScale,
					rand.nextDouble(-5, 5) * unit * hardScale, rand.nextDouble(-5, 5) * unit * hardScale }, 1.0, protonMass);
			Particles.add(temp);
			temp.maxBonds = rand.nextInt(1, 5);
		}

		long lastTime = System.currentTimeMillis();
		int w = 0;
		while (true) {
			if(automove) {
				AL.upDown=AL.upDown+0.0001;
				//AL.leftRight=AL.leftRight+0.000005;
			}
			w++;
			if (w > 100000 && w % 10000 == 0) {
				HashStyle Hash = new HashStyle(Particles);
				for (String book : Hash.library) {
					if (!molecules.contains(book)) {
						molecules.add(book);
						rebonding(book);
					}
				}
				System.out.println((w / 10000) - 10);
				for (String mole : molecules) {
					System.out.println(mole);
				}
			}

			for (Particle p : Particles) {
				changeVel(p);
			}
			for (Particle p : Particles) {
				move(p);
			}

			Viewer.myComponent.newSquares(Particles);
			Viewer.myComponent.newLines(Particles);
			
			seer.update();
			long currentTime = System.currentTimeMillis();
			// System.out.println(currentTime-lastTime);
			lastTime = currentTime;
//			try {
//				TimeUnit.MILLISECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

	}

	private static void rebonding(String book) {
		// TODO Auto-generated method stub

	}

	private static void changeVel(Particle part) {
		double[] nextVel = new double[] { 0, 0, 0 };
		for (Particle otherParts : Particles) {
			if (part != otherParts) {
				double[] velShift = part.force(otherParts);
				for (int i = 0; i < 3; i++) {
					nextVel[i] = nextVel[i] + velShift[i];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			part.velocity[i] = speedMult * nextVel[i] / part.mass + part.velocity[i];
		}
	}

	private static void move(Particle part) {
		for (int i = 0; i < 3; i++) {
			part.position[i] = part.velocity[i] + part.position[i];
		}

	}
}
