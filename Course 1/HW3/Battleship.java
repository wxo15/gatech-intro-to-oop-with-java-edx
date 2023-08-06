import java.util.Scanner;

public class Battleship {
	public char[][][] players = new char[2][5][5];
	public char[][][] targetHistory = new char[2][5][5];
	public int[] hits = new int[2];
	
    public static void main(String[] args) {
    	Scanner myObj = new Scanner(System.in);
    	//String inputs;
    	System.out.println("Welcome to Battleship!");
    	Battleship myGame = new Battleship();
        myGame.promptCoordinate(1, myObj);
        myGame.promptCoordinate(2, myObj);
        int turn = 1;
        System.out.println("");
        do {
        	turn = myGame.promptAttempt(turn, myObj);
        } while (turn != 0);
        System.out.println("");
        System.out.println("Final boards:");
        System.out.println("");
        printBattleShip(myGame.players[0]);
        System.out.println("");
        printBattleShip(myGame.players[1]);
        myObj.close();
    }
    
    public void promptCoordinate(int playerNumber, Scanner myObj) {
    	System.out.println("");
    	System.out.println("PLAYER " + playerNumber + ", ENTER YOUR SHIPS’ COORDINATES.");
    	String inputs;
    	int a, b;
    	for (int i = 0; i < 5; i++) {
    		for (int j = 0; j < 5; j++) {
    			players[playerNumber - 1][i][j] = '-';
    			targetHistory[playerNumber - 1][i][j] = '-';
    		}
    	}
    	
    	int i = 1;
    	do {
    		System.out.println("Enter ship " + i + " location:");
    		inputs = myObj.nextLine();
    		try {
    			a = Integer.parseInt(inputs.split(" ")[0]);
    			b = Integer.parseInt(inputs.split(" ")[1]);
    			if (a > 4 || a < 0 || b > 4 || b < 0 ) {
    				System.out.println("Invalid coordinates. Choose different coordinates.");
    			} else {
    				if (players[playerNumber - 1][a][b] == '@') {
    					System.out.println("You already have a ship there. Choose different coordinates.");
    				} else {
    					players[playerNumber - 1][a][b] = '@';
            			i += 1;
    				}
    			}
    		} catch (Exception e) {
    			System.out.println("Invalid coordinates. Choose different coordinates.");
    		}
    	} while ( i <= 5 );
    	
    	printBattleShip(players[playerNumber - 1]);
    	return;
    	
    }
    
    public int promptAttempt(int playerNumber, Scanner myObj) {
    	
    	System.out.println("Player " + playerNumber + ", enter hit row/column:");
    	String inputs;
    	int a, b;
    	int result = playerNumber;
		inputs = myObj.nextLine();
		boolean printflag = true;
		try {
			a = Integer.parseInt(inputs.split(" ")[0]);
			b = Integer.parseInt(inputs.split(" ")[1]);
			if (a > 4 || a < 0 || b > 4 || b < 0 ) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				printflag = false;
			} else {
				if (targetHistory[2 - playerNumber][a][b] != '-') {
					System.out.println("You already fired on this spot. Choose different coordinates.");
					printflag = false;
				} else if (players[2 - playerNumber][a][b] == '@') {
					System.out.println("PLAYER " + playerNumber + " HIT PLAYER " + (3 - playerNumber) + "’s SHIP!");
					players[2 - playerNumber][a][b] = 'X';
					targetHistory[2 - playerNumber][a][b] = 'X';
					result = 3 - playerNumber;
					hits[playerNumber - 1]++;
				} else if (players[2 - playerNumber][a][b] == '-') {
					System.out.println("PLAYER " + playerNumber + " MISSED!");
					players[2 - playerNumber][a][b] = 'O';
					targetHistory[2 - playerNumber][a][b] = 'O';
					result = 3 - playerNumber;
				} else {
					System.out.println("Invalid coordinates. Choose different coordinates.");
					printflag = false;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid coordinates. Choose different coordinates.");
			printflag = false;
		}
		
		if (printflag) {
			printBattleShip(targetHistory[2 - playerNumber]);
			if (hits[playerNumber - 1] == 5) {
				System.out.println("PLAYER "+playerNumber+" WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
				return 0;
			}
			System.out.println("");
		}
		
    	return result;
    	
    }
    
    // Use this method to print game boards to the console.
 	private static void printBattleShip(char[][] player) {
 		System.out.print("  ");
 		for (int row = -1; row < 5; row++) {
 			if (row > -1) {
 				System.out.print(row + " ");
 			}
 			for (int column = 0; column < 5; column++) {
 				if (row == -1) {
 					System.out.print(column + " ");
 				} else {
 					System.out.print(player[row][column] + " ");
 				}
 			}
 			System.out.println("");
 		}
 	}
    
}
