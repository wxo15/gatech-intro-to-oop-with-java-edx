public class Cat extends Pet {
	private int miceCaught;
	
	public Cat(String name, double health, int painLevel, int miceCaught) {
		super(name, health, painLevel);
		
		if (miceCaught < 0) {
			this.miceCaught = 0;
		} else {
			this.miceCaught = miceCaught;
		}
	}
	
	public Cat(String name, double health, int painLevel) {
		this(name, health, painLevel, 0);
	}
	
	public int getMiceCaught() { return this.miceCaught; };
	
	public int treat() {
		
		int initialPainLevel = getPainLevel();
		double initialHealth = getHealth();
		
		this.heal();
		
		if (miceCaught < 4) {
			return (int) Math.ceil((initialPainLevel*2)/initialHealth);
		} else if (miceCaught >= 4 && miceCaught <= 7) {
			return (int) Math.ceil(initialPainLevel/initialHealth);
		} else {
			return (int) Math.ceil(initialPainLevel/(initialHealth*2));
		}
	}
	
	public void speak() {
		super.speak();
		String res = "";
		for (int i = 0; i < getMiceCaught(); i++) {
			if (res.equals("")) {
				res ="meow";
			} else {
				res += " meow";
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
			if (o instanceof Cat) {
				Cat c = (Cat) o;
				if (c.getMiceCaught() == this.getMiceCaught()) {
					return true;
				}
			}
		}
		return false;
	}
	
}