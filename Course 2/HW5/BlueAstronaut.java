import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
	private int numTasks;
	private int taskSpeed;
	
	public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
		super(name, susLevel);
		this.numTasks = numTasks;
		this.taskSpeed = taskSpeed;
	}
	
	public BlueAstronaut(String name) {
		this(name, 15, 6, 10);
	}
	
	public void emergencyMeeting() {
		if (this.isFrozen()) {
			return;
		}
		
		Arrays.sort(Player.getPlayers());
		Player Sus1 = null;
		Player Sus2 = null;
		for (int i = Player.getPlayers().length - 1; i >= 0; i--) {
			if (!(Player.getPlayers()[i].isFrozen())) {
				if (Sus1 == null) {
					Sus1 = Player.getPlayers()[i];
				} else if (Sus2 == null){
					Sus2 = Player.getPlayers()[i];
					break;
				}
			}
		}
		if (Sus2 == null || Sus1.getSusLevel() != Sus2.getSusLevel()) {
			Sus1.setFrozen(true);
		}
		
		gameOver();
		return;
	}
	
	public void completeTask() {
		if (this.isFrozen() || numTasks == 0) {
			return;
		}
		
		if (this.taskSpeed > 20) {
			numTasks -= 2;
		} else {
			numTasks -= 1;
		}
		
		if (numTasks <= 0) {
			numTasks = 0;
			System.out.println("I have completed all my tasks");
			setSusLevel((int) (getSusLevel() * 0.5));
		}
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof BlueAstronaut) {
			BlueAstronaut ba = (BlueAstronaut) o;
			if (ba.getName().equals(getName()) && ba.getSusLevel() == getSusLevel()
					&& getTaskSpeed() == ba.getTaskSpeed() && ba.isFrozen() == isFrozen()
					&& getNumTasks() == ba.getNumTasks()) {
				res = true;
			}
		}
		return res;
	}
	
	public String toString() {
		String res = super.toString() + " I have " + numTasks + " left over.";
		if (getSusLevel() > 15) {
			res = res.toUpperCase();
		}
		return res;
	}
	
	public int getTaskSpeed() {return taskSpeed;};
	public int getNumTasks() {return numTasks;};
	public void setTaskSpeed(int taskSpeed) {this.taskSpeed = taskSpeed;};
	public void setNumTasks(int numTasks) {this.numTasks = numTasks;};
	
}
