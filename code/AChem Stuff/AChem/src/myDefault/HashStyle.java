package myDefault;

import java.util.ArrayList;

public class HashStyle {
	public static ArrayList<String> library = new ArrayList<>();

	public HashStyle(ArrayList<Particle> particles) {
		ArrayList<Particle> temp = (ArrayList<Particle>) particles.clone();
		String lib = "";
		for (int i = 0; i < particles.size(); i++) {
			if (temp.contains(particles.get(i))) {
				lib = build(particles.get(i), temp);
			}
			if (!library.contains(lib)) {
				library.add(lib);
			}
		}
		
	}

	private String build(Particle particle, ArrayList<Particle> temp) {
		//System.out.println(temp.size());
		String struct = "[" + particle.maxBonds;
		for (int i = 0; i < particle.maxBonds - particle.bonded.size(); i++) {
			struct = struct + "+";
		}
		for (Particle connection : particle.bonded) {
			if (temp.contains(connection)) {
				temp.remove(connection);
				struct = struct + build(connection, temp);
			}
		}
		return struct + "]";
	}
}
