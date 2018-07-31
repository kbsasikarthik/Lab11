//@ Sasikaladevi Kumarasamy

package lab11part1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Car> cars = new ArrayList<>();
		
		// add the objects created from Car class and UsedCar class to an ArrayList
		cars.add(new Car("Chevy", "Malibu",2018,26999));	
		cars.add(new Car("Chevy", "Impala",2018,35999));
		cars.add(new Car("Ford", "Fusion",2018,32000));
		cars.add(new UsedCar("Honda","Odyssey",2012,15698,126586));
		cars.add(new UsedCar("Honda","Civic",2002,5900,225750));
		cars.add(new UsedCar("Dodge","Durango",2005,7432,175984));
		cars.add(new UsedCar("Chevy","Malibu",2010,12585,106148));
		
		
		String usedOrNew=""; 
		boolean isValid = false;
		int userOption=0, carChoice=0;
		
		while(!isValid) {
			menuOptions(); // list the menu options 
			try {
				// get the menu selection 
				userOption = Validator.getInteger(sc, "Please select an option from the menu:(1,2,3,4,5)  ", 1, 5);
				if(userOption==1) {
					listCars(cars); // lists the minimal details of the cars from the ArrayList
				}else if(userOption==2) {
					usedOrNew = Validator.getRegExString(sc,"Would you like to add a New or Used car? : ", "new|used");
					if(usedOrNew.equalsIgnoreCase("new")) {
						addNewCar(sc,cars); // an instance of Car class created with user input will be added to the ArrayList 
					}
					else if(usedOrNew.equalsIgnoreCase("used")) {
						addUsedCar(sc,cars);// adds an instance of UsedCar with user entered details into the ArrayList
					}
					sc.nextLine();
				}else if(userOption==3) {
					listCars(cars);
					carChoice = Validator.getInteger(sc, "Please pick a car to remove from the list : ");
					try {
						System.out.println("The car " +cars.get(carChoice-1).getMakeOfCar()+" "+cars.get(carChoice-1).getModelOfCar()+" will been removed from the inventory!");
						System.out.println("Please press any key to continue.");
						sc.nextLine();
						cars.remove(carChoice-1);// removes the details of the user selected car from the ArrayList
						System.out.println("The selected car has been successfully removed!");;
						sc.nextLine();
	
					} catch (IndexOutOfBoundsException ex) {
						System.out.println("Invalid choice!");// If the index is out of bounds, this exception is thrown
					}
				}else if(userOption ==4) {
					listCars(cars);
					lookUp(sc, cars); // user entered car's details will be shown
					sc.nextLine();
				}else if(userOption ==5) {
					break;
				}
			}catch(InputMismatchException ex) { // catches the InpustMisMatch Exception
				System.out.println("Invalid input. Please try again.");
				continue;
			}
			// check with the user if wanted to shop again
			isValid = Validator.continueOrNot(sc,"Do you want to shop again? (y/n): ","[yY]");
			sc.nextLine();
		}
		sc.close();
		System.out.println("\nThanks for shopping with us!!!");
	} // end of main method
	
	
		
	// user defined method to list the menu options
	private static void menuOptions() {
		System.out.println("\nMenu Options\n~~~~ ~~~~~~~");
		System.out.println("1.List Cars\n2.Add a Car\n3.Remove a Car\n4.Lookup car details\n5.Quit\n");
	}
	
	// user defined method to look up details of the car of user's choice 
	private static void lookUp(Scanner sc, ArrayList<Car> cars) {
		int carChoice=Validator.getInteger(sc,"Please pick a car from the list: ", 1, cars.size());
		for(int i=0; i<cars.size();i++) {
			if(carChoice==(i+1) && cars.get(i) instanceof UsedCar) {
				System.out.println(((UsedCar)cars.get(i)).toString());
			} else if (carChoice==(i+1) && cars.get(i) instanceof Car) {
				System.out.println("(New) "+cars.get(i).toString());
			}
		}
	}
	
	// user defined method to add a new car to the list
	private static void addNewCar(Scanner sc,ArrayList<Car> cars) {
		System.out.println("Please enter the following details:");
		String make = Validator.getString(sc, "Make: ");
		String model =Validator.getString(sc,"Model: ");
		int year =Validator.getInteger(sc,"Year: ");
		double price =Validator.getDouble(sc, "Price: ");
		cars.add(new Car(make,model,year,price));
	}
	
	// user defined method to add a used car to the list
	private static void addUsedCar(Scanner sc, ArrayList<Car> cars) {
		System.out.println("Please enter the following details:");
		String make = Validator.getString(sc, "Make: ");
		String model =Validator.getString(sc,"Model: ");
		int year =Validator.getInteger(sc,"Year: ");
		double price =Validator.getDouble(sc, "Price: ");
		double mileage = Validator.getDouble(sc,"Mileage : ");
		cars.add(new UsedCar(make,model,year,price, mileage));		
	}
	
	// lists the details of car from the ArrayList
	private static void listCars(ArrayList<Car> cars) {
		for(int i=0; i<cars.size();i++) {
			System.out.println(i+1+") "+cars.get(i).getMakeOfCar() +" "+cars.get(i).getModelOfCar()+" "+cars.get(i).getYearOfMake());				
		}
	}

}// end of class
