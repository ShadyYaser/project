package shady_main;

public class AttackStrategy extends CombatStrategy{
	
	AttackStrategy(MainPlayer joel) {
		super(joel);
	}

	@Override
	public void action() {
		UI.printNormal("You chose to attack infected.");
	}

}
