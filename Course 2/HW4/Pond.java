//import java.util.Scanner;

public class Pond {
    public static void main(String[] args) {
    	Frog fg1 = new Frog("Peepo");
    	Frog fg2 = new Frog("Pepe", 10, 15);
    	Frog fg3 = new Frog("Peepaw", 4.6, 5);
    	Frog fg4 = new Frog("PewPew");
    	
    	Fly fly1 = new Fly(1, 3);
    	Fly fly2 = new Fly(6);
    	Fly fly3 = new Fly(10);
    	// 1
    	fg1.setSpecies("1331 Frogs");
    	// 2
    	System.out.println(fg1.toString());
    	// 3
    	fg1.eat(fly2);
    	// 4
    	System.out.println(fly2.toString());
    	// 5
    	fg1.grow(8);
    	// 6
    	fg1.eat(fly2);
    	// 7
    	System.out.println(fly2.toString());
    	// 8
    	System.out.println(fg1.toString());
    	// 9
    	System.out.println(fg4.toString());
    	// 10
    	fg3.grow(4);
    	// 11
    	System.out.println(fg3.toString());
    	// 12
    	System.out.println(fg2.toString());
    }
}
