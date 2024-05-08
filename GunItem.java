package shady_main;

public class GunItem extends Item{
	MainPlayer joel;
	
	GunItem(String name, MainPlayer joel) {
		super(name, joel);
	}

	@Override
	public void use() {
		joel.useItem(name);
		UI.printNormal("Bang!!");
	}

	@Override
	public void acquire() {
		UI.printNormal("Identified gun location. Acquiring gun..");
	}

	@Override
	public void complete() {
		UI.printNormal("Gun is ready for use.");
	}

}
