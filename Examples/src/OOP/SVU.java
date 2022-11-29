package OOP;

public class SVU extends Car {

	private int extraLoad;
	private int extraSit;
	public SVU(int extraLoad,int extraSit) {
		super();//call the father constructor
		this.extraLoad=extraLoad;
		this.extraSit=extraSit;
	}
	public int getExtraLoad() {
		return extraLoad;
	}
	public void setExtraLoad(int extraLoad) {
		this.extraLoad = extraLoad;
	}
	public int getExtraSit() {
		return extraSit;
	}
	public void setExtraSit(int extraSit) {
		this.extraSit = extraSit;
	}
	@Override
	public String toString() {
		return "SVU ExtraLoad= " + getExtraLoad() + ", ExtraSit= " + getExtraSit() + ", Wheels= "
				+ getWheels() + ", Length= " + getLength() + ", Width= " + getWidth() + ", Motor= "
				+ getMotor() + ", Weight= " + getWeight();
	}
	
	
}
