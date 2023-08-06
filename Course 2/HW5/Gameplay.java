public class Gameplay {
    
    public static void main(String[] args) {
    	String[] nums = new String[5];
    	for (String num : nums) {
    	    System.out.println(num.toUpperCase());
    	}
        BlueAstronaut b1 = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut b2 = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut b3 = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut b4 = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut r1 = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut r2 = new RedAstronaut("Suspicious Person", 100, "expert");
        
        System.out.println(b3.toString());
        b3.emergencyMeeting();
        System.out.println(b3.toString());
        
        //1
        r1.sabotage(b1);
        System.out.println(b1.getSusLevel());
        System.out.println(b1.isFrozen());
        // 2
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        r1.freeze(r2);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        // 3
        r1.freeze(b3);
        System.out.println(r1.getSusLevel());
        System.out.println(b3.isFrozen());
        // 4
        b3.emergencyMeeting();
        System.out.println(r2.toString());
        // 5
        r2.emergencyMeeting();
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        // 6
        b1.emergencyMeeting();
        System.out.println(r2.toString());
        // 7
        b2.completeTask();
        System.out.println(b2.toString());
        // 8
        b2.completeTask();
        System.out.println(b2.toString());
        // 9
        b2.completeTask();
        System.out.println(b2.toString());
        // 10
        r1.freeze(b4);
        System.out.println(b4.isFrozen());
        System.out.println(r1.getSusLevel());
        // 11
        r1.sabotage(b1);
        System.out.println(b1.getSusLevel());
        r1.sabotage(b1);
        System.out.println(b1.getSusLevel());
        // 12
        r1.freeze(b1);
        System.out.println(b1.isFrozen());
        // 13
        // b4.emergencyMeeting();
        // System.out.println(r1.isFrozen());
        // 14
        r1.sabotage(b2);
        System.out.println(b2.getSusLevel());
        r1.sabotage(b2);
        System.out.println(b2.getSusLevel());
        r1.sabotage(b2);
        System.out.println(b2.getSusLevel());
        r1.sabotage(b2);
        System.out.println(b2.getSusLevel());
        r1.sabotage(b2);
        System.out.println(b2.getSusLevel());
        // 15
        r1.freeze(b2);
        System.out.println(b2.isFrozen());
    }
}