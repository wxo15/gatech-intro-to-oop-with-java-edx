import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic {
	
	private File patientFile;
	private int day;
	
	public Clinic(File file) {
		patientFile = file;
	}
	
	public Clinic(String fileName) {
		this( new File(fileName) );
	}
	
	public String nextDay(File f) throws FileNotFoundException {
		Scanner myObj = new Scanner(System.in);
		String inputs = "";
		double health = 0;
		int painLevel = 0;
		int timeTaken = 0;
		Pet myPet;
		Scanner fileScan = new Scanner(f);
		String timeOut;
		int lineCount = 0;
		boolean success = false;
		String[] tokens = null;
		String res = "";
		String line;
		day++;
		
		while (fileScan.hasNextLine()) {
			line = fileScan.nextLine();
			tokens = line.split(",");
			System.out.println("Consultation for " + tokens[0] + " the " + tokens[1] + " at " + (tokens[3]).toString() + ".\nWhat is the health of " + tokens[0] + "?");
			
			if (!tokens[1].equals("Dog") && !tokens[1].equals("Cat")) {
				throw new InvalidPetException();
			}
			
			success = false;
			while (!success) {
				try {
					inputs = myObj.nextLine();
					health = Double.valueOf(inputs);
					success = true;
				} catch (Exception e) {
					System.out.println("Please enter a number");
				}
			}
			
			
			success = false;
			while (!success) {
				try {
					System.out.println("On a scale of 1 to 10, how much pain is " + tokens[0] + " in right now?");
					inputs = myObj.nextLine();
					painLevel = Integer.valueOf(inputs);
					success = true;
				} catch (Exception e) {
					System.out.println("Please enter a number");
				}
			}
			
			if (!res.equals("")) {
				res += "\n";
			}
			
			if (tokens[1].equals("Dog")) {
				myPet = new Dog(tokens[0], health, painLevel, Double.valueOf(tokens[2]));
				((Dog)myPet).speak();
				timeTaken = ((Dog)myPet).treat();
				timeOut = addTime(tokens[3],timeTaken);
				res += tokens[0] + "," + tokens[1] + "," + ((Dog)myPet).getDroolRate() + ",Day " + day + "," + tokens[3]+ "," + timeOut + "," + health + "," + painLevel;
			} else {
				myPet = new Cat(tokens[0], health, painLevel, Integer.valueOf(tokens[2]));
				((Cat)myPet).speak();
				timeTaken = ((Cat)myPet).treat();
				timeOut = addTime(tokens[3],timeTaken);
				res += tokens[0] + "," + tokens[1] + "," + ((Cat)myPet).getMiceCaught() + ",Day " + day + "," + tokens[3]+ "," + timeOut + "," + health + "," + painLevel;
			}
			
			lineCount ++;
		}
		
		if (myObj != null) {
			myObj.close();
		}
		if (fileScan != null) {
			fileScan.close();
		}
		
		return res;
	}
	
	public String nextDay(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		return nextDay(f);
	}
	
	public boolean addToFile(String patientInfo) {
		Scanner fileScan = null;
		PrintWriter pw = null;
		try {
			fileScan = new Scanner(patientFile);
			String line;
			String[] tokens;
			String[] newTokens;
			Pet myPet, oldPets = null;
			Integer linecount = 0;
			String res = "";
			boolean added = false;
			newTokens = patientInfo.split(",");
			if (newTokens[1].equals("Dog")) {
				myPet = new Dog(newTokens[0], Double.valueOf(newTokens[6]), Integer.valueOf(newTokens[7]), Double.valueOf(newTokens[2]));
			} else {
				myPet = new Cat(newTokens[0], Double.valueOf(newTokens[6]), Integer.valueOf(newTokens[7]), Integer.valueOf(newTokens[2]));
			}
			while (fileScan.hasNextLine()) {
				line = fileScan.nextLine();
				tokens = line.split(",");
				if (tokens[1].equals("Dog")) {
					oldPets = new Dog(tokens[0], Double.valueOf(tokens[6]), Integer.valueOf(tokens[7]), Double.valueOf(tokens[2]));
				} else if (tokens[1].equals("Cat")){
					oldPets = new Cat(tokens[0], Double.valueOf(tokens[6]), Integer.valueOf(tokens[7]), Integer.valueOf(tokens[2]));
				}
				
				if (!res.equals("")) {
					res += "\n";
				}
				
				if (oldPets.equals(myPet)) {
					res += line;
					res += "," + newTokens[3] + "," + newTokens[4] + "," + newTokens[5] + "," + newTokens[6] + "," + newTokens[7];
					added = true;
					
				} else {
					res += line;
				}
				linecount++;
			}
			if (!added) {
				if (!res.toString().equals("")) {
					res += "\n";
				}
				res += newTokens[0] + "," + newTokens[1] + "," + newTokens[2]+ "," + newTokens[3] + "," + newTokens[4] + "," + newTokens[5] + "," + newTokens[6] + "," + newTokens[7];
			}
			pw = new PrintWriter(new FileWriter(patientFile, false));  
			pw.write(res.toString());
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fileScan != null) {
				fileScan.close();
			}
		}
	}
	
	private String addTime (String timeIn, int treatmentTime) {
		int hour, min;
		hour = Integer.valueOf(timeIn.substring(0, 2));
		min = Integer.valueOf(timeIn.substring(2, 4));
		min += treatmentTime;
		while (min >= 60) {
			min -= 60;
			hour += 1;
		} ;
		String res, h, m = "";
		h = Integer.toString(hour);
		m = Integer.toString(min);
		if (h.length() == 1) {
			res = "0" + h;
		} else {
			res = h;
		}
		if (m.length() == 1) {
			res += "0" + m;
		} else {
			res += m;
		}
		
		return res;
	}
}
