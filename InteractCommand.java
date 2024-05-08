package shady_main;

public class InteractCommand implements Command{
	
	MainPlayer joel = MainPlayer.getInstance();
	
	InteractCommand(MainPlayer joel){
		this.joel = joel;
	}
	
	@Override
	public void execute() {
		joel.askDocNicely();
	}

	@Override
	public String getName() {
		return "Ask Doctor nicely to make a cure.";
	}

}
