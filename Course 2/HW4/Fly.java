public class Fly {
    private double mass;
    private double speed;
	
    public Fly(double mass, double speed) {
    	this.mass = mass;
    	this.speed = speed;
    }
    
    public Fly(double mass) {
    	this(mass, 10);
    }
    
    public Fly() {
    	this(5, 10);
    }
    
    public double getMass() { return mass; };
    
    public double getSpeed() { return speed; };
    
    public void setMass(double mass) { this.mass = mass; };
    
    public void setSpeed(double speed) { this.speed = speed; };
    
    public String toString() {
    	String result = "I’m a speedy fly with " + String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
    	if (mass == 0) {
    		result = "I’m dead, but I used to be a fly with a speed of " + String.format("%.2f", speed) + ".";
    	}
    	return result;
    }
    
    public void grow(int addMass) {
    	for (int i = 0; i < addMass; i ++) {
    		mass += 1;
    		if (mass <= 20) {
    			speed += 1;
    		} else {
    			speed -= 0.5;
    		}
    	}
    }
    
    public boolean isDead() {return (mass == 0);};
	
}
