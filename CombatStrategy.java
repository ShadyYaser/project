package shady_main;

public abstract class CombatStrategy {
	MainPlayer joel;
	
	CombatStrategy(MainPlayer joel){
		this.joel = joel;
	}
	
	public abstract void action();
	
}
