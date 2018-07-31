// @ Sasikaladevi Kumarasamy
// this is a child class which extends to Car class
package lab11part1;

public class UsedCar extends Car{
	private double mileage;
	// default constructor
	public UsedCar() {
	}
	// constructor that accepts 4 arguments
	public UsedCar(String makeOfCar, String modelOfCar, int yearOfMake, double priceOfCar,double mileage) {
		super( makeOfCar,  modelOfCar, yearOfMake, priceOfCar);
		this.setMileage(mileage);
	}
	// getter and setter for the class variable
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return "(Used) "+ super.toString()+", Mileage - "+mileage+" miles.";
	}

}
