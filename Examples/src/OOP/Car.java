package OOP;

public class Car {
	
	private int wheels;
	private int length;
	private int width;
	private int motor;
	private int weight;
	
	public Car(int wheels, int length, int width, int motor, int weight) {
		this.wheels=wheels;
		this.length=length;
		this.width=width;
		this.motor=motor;
		this.weight=weight;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getMotor() {
		return motor;
	}

	public void setMotor(int motor) {
		this.motor = motor;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	

}
