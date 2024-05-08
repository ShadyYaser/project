package shady_main;

public class ThreatenCommand implements Command{
	
	MainPlayer joel = MainPlayer.getInstance();
	
	ThreatenCommand(MainPlayer joel){
		this.joel = joel;
	}
	
	@Override
	public void execute() {
		joel.threatenDoc();
	}

	@Override
	public String getName() {
		return "Threaten Doctor to make a cure.";
	}

}
