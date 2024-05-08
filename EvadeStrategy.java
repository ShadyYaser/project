package shady_main;

public class EvadeStrategy extends CombatStrategy{

	EvadeStrategy(MainPlayer joel) {
		super(joel);
	}

	@Override
	public void action() {
		UI.printNormal("You chose to run away from infected.");
		
	}

}
