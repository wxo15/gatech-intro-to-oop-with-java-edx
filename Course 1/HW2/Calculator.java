import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
    	Scanner myObj = new Scanner(System.in);
    	String inputs;
    	System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = myObj.nextLine();
    	switch(validateOperation(operation)) {
			case 1:
				System.out.println("Enter two integers:");
				inputs = myObj.nextLine();
				try {
					int a = Integer.parseInt(inputs.split(" ")[0]);
					int b = Integer.parseInt(inputs.split(" ")[1]);
					if (operation.toLowerCase().equals("add")) {
						System.out.println("Answer: " + (a + b));
					} else {
						System.out.println("Answer: " + (a - b));
					}
				} catch (Exception e) {
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			case 2:
				System.out.println("Enter two doubles:");
				inputs = myObj.nextLine();
				try {
					double c = Double.parseDouble(inputs.split(" ")[0]);
					double d = Double.parseDouble(inputs.split(" ")[1]);
					if (operation.toLowerCase().equals("multiply")) {
						System.out.printf("Answer: %,.2f", (c * d));
					} else {
						if (d == 0) {
							throw new ArithmeticException();
						} else {
							System.out.printf("Answer: %,.2f", (c / d));
						}
					}
				} catch (Exception e) {
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			case 3:
				System.out.println("Enter two words:");
				inputs = myObj.nextLine();
				try {
					String e = inputs.split(" ")[0];
					String f = inputs.split(" ")[1];
					int comp = e.compareToIgnoreCase(f);
					if (comp < 0) {
						System.out.println("Answer: " + e + " comes before " + f + " alphabetically.");
					} else if (comp > 0) {
						System.out.println("Answer: " + f + " comes before " + e + " alphabetically.");
					} else {
						System.out.println("Answer: Chicken or Egg.");
					}
				} catch (Exception e) {
					System.out.println("Invalid input entered. Terminating...");
				}
				break;
			default:
				System.out.println("Invalid input entered. Terminating...");
				break;
    	}
        myObj.close();
    }
    
    private static int validateOperation(String operation) {
    	// return -1 if invalid, 1 if expecting integers, 2 if expecting doubles, 3 if expecting strings
    	switch(operation.toLowerCase()) {
			case "add":
			case "subtract":
				return 1;
			case "multiply":
			case "divide":
				return 2;
			case "alphabetize":
				return 3;
			default:
				return -1;
		}
    }
}
