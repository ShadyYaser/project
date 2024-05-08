package shady_main;

public class MedkitItem extends Item{
	MainPlayer joel;
	
	MedkitItem(String name, MainPlayer joel) {
		super(name, joel);
	}

	@Override
	public void use() {
		joel.useItem(name);
		UI.printNormal("ouch....");
	}

	@Override
	public void acquire() {
		UI.printNormal("Identified Medkit.. acquiring it");
	}

	@Override
	public void complete() {
		UI.printNormal("Medkit is ready for use.");
	}

}
