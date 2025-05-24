package myDefault;

import java.util.ArrayList;
import java.util.Random;

public class Particle {
	public double[] position = new double[3];
	public double charge = 0.0;
	public double mass = 0;
	public ArrayList<Particle> bonded = new ArrayList<>();
	public int maxBonds = 0;
	public int bondDistance = 2;
	public double volitility = 0.00001;
	public double[] velocity = new double[3];
	public Random randy = new Random(0);
	public boolean unbreakableBond = false;

	public Particle(double[] pos, double charg, double mas) {
		position = pos;
		charge = charg;
		mass = mas;
	}

	public double[] forceExerted(Particle otherPart) {
		double dis = dist(otherPart);
		if (dis == 0) {
			System.out.println("zero");
			return new double[] { 0.0, 0.0, 0.0 };
		}
		if (otherPart.charge != charge) {
			return new double[] { charge * otherPart.charge * (position[0] - otherPart.position[0]) / (dis * dis),
					charge * otherPart.charge * (position[1] - otherPart.position[1]) / (dis * dis),
					charge * otherPart.charge * (position[2] - otherPart.position[2]) / (dis * dis) };
		} else {
			double alterSelfAtract = 0.95;
			return new double[] {
					alterSelfAtract * charge * otherPart.charge * (position[0] - otherPart.position[0]) / (dis * dis),
					alterSelfAtract * charge * otherPart.charge * (position[1] - otherPart.position[1]) / (dis * dis),
					alterSelfAtract * charge * otherPart.charge * (position[2] - otherPart.position[2]) / (dis * dis) };
		}
	}

	private double dist(Particle otherPart) {
		return Math.sqrt(Math.pow(position[0] - otherPart.position[0], 2)
				+ Math.pow(position[2] - otherPart.position[2], 2) + Math.pow(position[1] - otherPart.position[1], 2));
	}

	public double[] force(Particle otherPart) {
		double dis = dist(otherPart);
		if (dis == 0) {
			System.out.println("zero");
			return new double[] { 0.0, 0.0, 0.0 };
		}
		if (maxBonds < bonded.size() && !unbreakableBond && !otherPart.unbreakableBond) {
			otherPart.bonded.remove(this);
			bonded.remove(otherPart);
		}
		if (dis < bondDistance * 17000000 * 2 && dis > bondDistance * 5000000 * 2) {

			if (bonded.size() + 1 <= maxBonds && !bonded.contains(otherPart)
					&& otherPart.bonded.size() + 1 <= otherPart.maxBonds && !otherPart.bonded.contains(this)) {
				bonded.add(otherPart);
				otherPart.bonded.add(this);
			}
			if (bonded.contains(otherPart)) {
				if (Math.abs(velocity[0]) + Math.abs(velocity[2]) + Math.abs(velocity[1]) > 500) {
					velocity = new double[] { velocity[0] * 0.99995, velocity[1] * 0.99995, velocity[2] * 0.99995 };
				}
				if (randy.nextDouble() < volitility && !unbreakableBond && !otherPart.unbreakableBond) {
					bonded.remove(otherPart);
					otherPart.bonded.remove(this);
				}
			}
		} else {
			if (!unbreakableBond && !otherPart.unbreakableBond) {
				otherPart.bonded.remove(this);
				bonded.remove(otherPart);
			}
		}
		double multi = 1;
		if (bonded.contains(otherPart)) {
			multi = dis / 1000;
		}
//		if (dis < bondDistance*11000000 * 2) {
//			return new double[] { multi*(position[0] - otherPart.position[0]) / (dis * dis),
//					multi*(position[1] - otherPart.position[1]) / (dis * dis),
//					multi*(position[2] - otherPart.position[2]) / (dis * dis) };
//		} else if(dis < bondDistance*18000000 * 2) {
//			return new double[] { -multi*(position[0] - otherPart.position[0]) / (dis * dis),
//					-multi*(position[1] - otherPart.position[1]) / (dis * dis),
//					-multi*(position[2] - otherPart.position[2]) / (dis * dis) };
//		} else if(dis < bondDistance*25000000 * 2){
//			if(maxBonds==bonded.size() || otherPart.maxBonds==otherPart.bonded.size()) {
//			return new double[] {0,0,0};
//		}
//		
//		return new double[] { attract*multi*(position[0] - otherPart.position[0]) / (dis * dis),
//				attract*multi*(position[1] - otherPart.position[1]) / (dis * dis),
//				attract*multi*(position[2] - otherPart.position[2]) / (dis * dis) };
//	}
		if (dis < bondDistance * 11000000 * 3
				&& ((bonded.size() == maxBonds && otherPart.bonded.size() == otherPart.maxBonds)
						&& !bonded.contains(otherPart))) {
			return new double[] { 20 * multi * (position[0] - otherPart.position[0]) / (dis * dis),
					20 * multi * (position[1] - otherPart.position[1]) / (dis * dis),
					20 * multi * (position[2] - otherPart.position[2]) / (dis * dis) };
		} else if (dis < bondDistance * 11000000 * 2) {

			return new double[] { multi * (position[0] - otherPart.position[0]) / (dis * dis),
					multi * (position[1] - otherPart.position[1]) / (dis * dis),
					multi * (position[2] - otherPart.position[2]) / (dis * dis) };
		} else {
//			if(maxBonds==bonded.size() || otherPart.maxBonds==otherPart.bonded.size()) {
//				return new double[] {0,0,0};
//			}

			return new double[] { -multi * (position[0] - otherPart.position[0]) / (dis * dis),
					-multi * (position[1] - otherPart.position[1]) / (dis * dis),
					-multi * (position[2] - otherPart.position[2]) / (dis * dis) };
		}
	}

}
