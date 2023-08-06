public class Frog {
	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet;
	private static String species = "Rare Pepe";
	
	public Frog (String name, int age, double tongueSpeed) {
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
		isFroglet = (age > 1 && age < 7);
	}
	
	public Frog (String name, double ageInYears, double tongueSpeed) {
		this(name, (int) (ageInYears * 12), tongueSpeed);
	}
	
	public Frog (String name) {
		this(name, 5, 5);
	}
	
	public void grow(int numMonth) {
		for (int i = 0; i < numMonth; i ++) {
    		this.grow();
    	}
		
	}
	
	public void grow() {
		age += 1;
		if (age <= 12) {
			tongueSpeed += 1;
		} else if (age > 30) {
			tongueSpeed -= 1;
			if (tongueSpeed < 5) {
				tongueSpeed = 5;
			}
		}
		isFroglet = (age > 1 && age < 7);
	}
	
	public void eat(Fly fly) {
		if (fly.isDead()) {
			return;
		}
		if (fly.getSpeed() < tongueSpeed) {
			if (fly.getMass() >= 0.5 * age) {
				grow();
			}
			fly.setMass(0);
		} else {
			fly.grow(1);
		}
	}
	
	public String toString() {
    	String result = "";
    	if (isFroglet) {
    		result = "My name is " + name + " and I’m a rare froglet! I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    	} else {
    		result = "My name is " + name + " and I’m a rare frog. I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    	}
    	return result;
    }
	
	public String getname() { return name; };
    
    public int getAge() { return age; };
    
    public double getTongueSpeed() { return tongueSpeed; };
    
    public boolean getisFroglet() { return isFroglet; };
    
    public String getSpecies() { return species; };
    
    public void setname(String name) { this.name = name; };
    
    public void setAge(int age) { 
    	this.age = age;
    	isFroglet = (age > 1 && age < 7);
    };
    
    public void setTongueSpeed(double tongueSpeed) { this.tongueSpeed = tongueSpeed; };
    
    //public void setisFroglet(boolean isFroglet) { this.isFroglet = isFroglet; };
    public void setSpecies(String species) { Frog.species = species; } ;
}