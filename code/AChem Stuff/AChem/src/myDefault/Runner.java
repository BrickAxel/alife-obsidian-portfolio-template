package myDefault;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {
	public static ArrayList<Particle> Particles = new ArrayList<>();
	public static final double electronMass = 0.000544617022596;
	public static final double protonMass = 1; //masses relative to protons
	public static final double hardScale = 1000000;
	public static final int threadPoolSize = 12;
	public static ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize);
	
	
	public static void main(String[] args) {
		
		test5();
	}
	
	private static void test5() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		Random rand = new Random(42);
		int numElecs = 3000;
		int devy = 200000000;
		
		for (int i = 0; i < 2*numElecs; i++) {
			Particles.add(
					new Particle(new double[] { rand.nextDouble(-devy,devy)+9500+hardScale*500, rand.nextDouble(-devy,devy)+5000+hardScale*500, rand.nextDouble(-devy,devy)+9500+hardScale*500 },
							-1.0/numElecs, electronMass/numElecs));
		}
		Particles.add(new Particle(new double[] { 9500+hardScale*500, 5000+hardScale*500, 9500+hardScale*500},
				1.0, protonMass));
		Particles.getLast().velocity= new double[]{0.0,-100.0,0.0};
		Particles.add(new Particle(new double[] { 130000000+hardScale*500, 5000+hardScale*500, 9500+hardScale*500},
				1.0, protonMass));
		long lastTime = System.currentTimeMillis();
		while (true) {
			
			ArrayList<Future<?>> futures = new ArrayList<>();;
			for (int k = 0; k< threadPoolSize;k++) {
				Integer K =k;
				futures.add(threadPool.submit(()->{
					//System.out.println("before");
					for(int p = K; p<Particles.size();p=p+threadPoolSize) {
						changeVel(Particles.get(p));
					}
					//System.out.println("after");
				}));
			}

			for (int k = 0; k< threadPoolSize;k++) {
				try {
					futures.remove(0).get();
					//System.out.println("here");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for (int k = 0; k< threadPoolSize;k++) {
				Integer K =k;
				futures.add(threadPool.submit(()->{
					//System.out.println("before");
					for(int p = K; p<Particles.size();p=p+threadPoolSize) {
						move(Particles.get(p));
					}
					//System.out.println("after");
				}));
			}

			for (int k = 0; k< threadPoolSize;k++) {
				try {
					futures.remove(0).get();
					//System.out.println("here");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			Viewer.myComponent.newSquares(Particles);
//			try {
//				TimeUnit.MILLISECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			seer.update();
			long currentTime =  System.currentTimeMillis();
			System.out.println(currentTime-lastTime);
			lastTime= currentTime;
		}

	}
	
	private static void test4() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		Random rand = new Random(42);
		int numElecs = 3;
		int devy = 20000000;
		
		for (int i = 0; i < 10*numElecs; i++) {
			Particles.add(
					new Particle(new double[] { rand.nextDouble(-5*devy,5*devy)+9500+hardScale*500, rand.nextDouble(-5*devy,5*devy)+5000+hardScale*500, rand.nextDouble(-5*devy,5*devy)+9500+hardScale*500 },
							-1.0/numElecs, electronMass/numElecs));
		}
		Particles.add(new Particle(new double[] { 9500+hardScale*500, 5000+hardScale*500, 9500+hardScale*500},
				1.0, protonMass));
		Particles.getLast().velocity= new double[]{0.0,-100.0,0.0};
		Particles.add(new Particle(new double[] { 50000000+hardScale*500, 5000+hardScale*500, 9500+hardScale*500},
				1.0, protonMass));
		Particles.add(new Particle(new double[] { 70000000+hardScale*500, 70000000+hardScale*500, 9500+hardScale*500},
				8.0, 8*protonMass));
		int k = 0;
		while (true) {
			k++;
			for (Particle part : Particles) {
				changeVel(part);
			}
			for (Particle part : Particles) {
				move(part);
			}

			Viewer.myComponent.newSquares(Particles);
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seer.update();
		}

	}

	private static void test3() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		Random rand = new Random(42);
		int numElecs = 50;
		int devy = 20000000;
		
		for (int i = 0; i < 3*numElecs; i++) {
			Particles.add(
					new Particle(new double[] { rand.nextDouble(-devy,devy)+9500+hardScale*500, rand.nextDouble(-devy,devy)+5000+hardScale*500, rand.nextDouble(-devy,devy)+9500+hardScale*500 },
							-1.0/numElecs, electronMass/numElecs));
		}
		Particles.add(new Particle(new double[] { 9500+hardScale*500, 5000+hardScale*500, 9500+hardScale*500},
				1.0, protonMass));
		Particles.getLast().velocity= new double[]{0.0,-100.0,0.0};
		Particles.add(new Particle(new double[] { 50000000+hardScale*500, 5000+hardScale*500, 9500+hardScale*500},
				1.0, protonMass));
		int k = 0;
		while (true) {
			k++;
			for (Particle part : Particles) {
				changeVel(part);
			}
			for (Particle part : Particles) {
				move(part);
			}

			Viewer.myComponent.newSquares(Particles);
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seer.update();
		}

	}

	private static void test2() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		Random rand = new Random(42);
		for (int i = 0; i < 100; i++) {
			Particles.add(
					new Particle(new double[] { rand.nextDouble(1000), rand.nextDouble(1000), rand.nextDouble(1000) },
							(i % 2) * 2 - 1, ((((i % 2.0) * 100.0 + 1.0)) / 100000000.0)));
		}

		int k = 0;
		while (true) {
			k++;
			for (Particle part : Particles) {
				changeVel(part);
			}
			for (Particle part : Particles) {
				move(part);
			}

			Viewer.myComponent.newSquares(Particles);
//			try {
//				TimeUnit.MILLISECONDS.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			seer.update();
		}

	}

	public static void test1() {
		Viewer seer = new Viewer();
		seer.myComponent.scale = 1;
		seer.main(null);
		Particle partA = new Particle(new double[] { 50, 51, 0 }, -1, 1);
		Particles.add(partA);

		Particle partB = new Particle(new double[] { 39, 29, 0 }, 1, 1);
		Particles.add(partB);

		Particle partC = new Particle(new double[] { 39, 48, 0 }, 1, 1);
		Particles.add(partC);

		int k = 0;
		while (true) {
			k++;
			for (Particle part : Particles) {
				changeVel(part);
			}
			for (Particle part : Particles) {
				move(part);
			}
			System.out.println("A: " + partA.position[0] + " " + partA.position[1] + " " + partA.position[2]);
			System.out.println("B: " + partB.position[0] + " " + partB.position[1] + " " + partB.position[2]);

			System.out.println("A: " + partA.velocity[0] + " " + partA.velocity[1] + " " + partA.velocity[2]);
			System.out.println("B: " + partB.velocity[0] + " " + partB.velocity[1] + " " + partB.velocity[2] + "\n");
			Viewer.myComponent.newSquares(Particles);
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seer.update();
		}

	}

	private static void move(Particle part) {
		for (int i = 0; i < 3; i++) {
			part.position[i] = part.velocity[i] + part.position[i];
		}
	}

	private static void changeVel(Particle part) {
		double[] nextVel = new double[] {0,0,0};
		for (Particle otherParts : Particles) {
			if (part != otherParts) {
				double[] velShift = part.forceExerted(otherParts);
				for (int i = 0; i < 3; i++) {
					nextVel [i]= nextVel[i] + velShift[i];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			part.velocity[i]= 10000000*nextVel[i]/part.mass + part.velocity[i];
		}
	}
}
