// @ Sasikaladevi Kumarasamy
// this is the parent class
package lab11part1;

public class Car {
	private String makeOfCar;
	private String modelOfCar;
	private int yearOfMake;
	private double priceOfCar;
	
	// default constructor
	public Car() {
	}
	
	// constructor that has 4 arguments
	public Car(String makeOfCar, String modelOfCar, int yearOfMake, double priceOfCar) {
		this.makeOfCar = makeOfCar;
		this.modelOfCar = modelOfCar;
		this.yearOfMake = yearOfMake;
		this.priceOfCar = priceOfCar;
	}
	
	// getters and setters for the variables
	public String getMakeOfCar() {
		return makeOfCar;
	}
	public void setMakeOfCar(String makeOfCar) {
		this.makeOfCar = makeOfCar;
	}
	public String getModelOfCar() {
		return modelOfCar;
	}
	public void setModelOfCar(String modelOfCar) {
		this.modelOfCar = modelOfCar;
	}
	public int getYearOfMake() {
		return yearOfMake;
	}
	public void setYearOfMake(int yearOfMake) {
		this.yearOfMake = yearOfMake;
	}
	public double getPriceOfCar() {
		return priceOfCar;
	}
	public void setPriceOfCar(double priceOfCar) {
		this.priceOfCar = priceOfCar;
	}
	
	@Override
	
	public String toString() {
		return String.format("%-10s %-10s %d\t$%.2f",makeOfCar,modelOfCar,yearOfMake, priceOfCar );
		
	}
	
	
	

}
