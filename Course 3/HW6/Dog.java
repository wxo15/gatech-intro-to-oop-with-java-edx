
public class Dog extends Pet {
	private double droolRate;
	
	public Dog(String name, double health, int painLevel, double droolRate) {
		super(name, health, painLevel);
		
		if (droolRate <= 0) {
			this.droolRate = 0.5;
		} else {
			this.droolRate = droolRate;
		}
	}
	
	public Dog(String name, double health, int painLevel) {
		this(name, health, painLevel, 5.0);
	}
	
	public double getDroolRate() { return this.droolRate; };
	
	public int treat() {
		
		int initialPainLevel = getPainLevel();
		double initialHealth = getHealth();
		this.heal();
		
		if (droolRate < 3.5) {
			return (int) Math.ceil((initialPainLevel*2)/initialHealth);
		} else if (droolRate >= 3.5 && droolRate < 7.5) {
			return (int) Math.ceil(initialPainLevel/initialHealth);
		} else {
			return (int) Math.ceil(initialPainLevel/(initialHealth*2));
		}
		
	}
	
	public void speak() {
		super.speak();
		String res = "";
		for (int i = 0; i < getPainLevel(); i++) {
			if (res.equals("")) {
				res ="bark";
			} else {
				res += " bark";
			}
		}
		if (getPainLevel() > 5) {
			System.out.println(res.toUpperCase());
		} else {
			System.out.println(res);
		}
	}
	
	public boolean equals(Object o) {
		boolean res = super.equals(o);
		if (res) {
			if (o instanceof Dog) {
				Dog d = (Dog) o;
				if (d.getDroolRate() == this.getDroolRate()) {
					return true;
				}
			}
		}
		return false;
	}
}
