import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
	private String skill;
	
	public RedAstronaut(String name, int susLevel, String skill) {
		super(name, susLevel);
		this.skill = skill.toLowerCase();
	}
	
	public RedAstronaut(String name) {
		this(name, 15, "experienced");
	}

	public void emergencyMeeting() {
		if (this.isFrozen()) {
			return;
		}
		
		Arrays.sort(Player.getPlayers());
		Player Sus1 = null;
		Player Sus2 = null;
		for (int i = Player.getPlayers().length - 1; i >= 0; i--) {
			if (!this.equals(Player.getPlayers()[i]) && !(Player.getPlayers()[i].isFrozen())) {
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
	
	@Override
	public void freeze(Player p) {
		if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
			return;
		}
		if (this.getSusLevel() < p.getSusLevel()) {
			p.setFrozen(true);
		} else {
			this.setSusLevel(getSusLevel() * 2);
		}
		gameOver();
		return;		
	}

	@Override
	public void sabotage(Player p) {
		if (p instanceof Impostor || this.isFrozen() || p.isFrozen()) {
			return;
		}
		if (this.getSusLevel() < 20) {
			p.setSusLevel((int) (p.getSusLevel() * 1.5));
		} else {
			p.setSusLevel((int) (p.getSusLevel() * 1.25));
		}
		return;
		
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof RedAstronaut) {
			RedAstronaut ra = (RedAstronaut) o;
			if (ra.getName().equals(getName()) && ra.getSusLevel() == getSusLevel()
					&& getSkill().equals(ra.getSkill()) && ra.isFrozen() == isFrozen()) {
				res = true;
			}
		}
		return res;
	}
	
	public String toString() {
		String res = super.toString() + " I am an " + skill + " player!";
		if (getSusLevel() > 15) {
			res = res.toUpperCase();
		}
		return res;
	}
	
	public String getSkill() {return skill;}
	public void setSkill(String s) {this.skill = s;}

	
}
