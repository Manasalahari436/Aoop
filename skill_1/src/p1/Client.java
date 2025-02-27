package p1;

//AOOP Skill LAb Program1.java

//Singleton Pattern: Game Level Manager
class GameLevelManager {
 private static GameLevelManager instance;
 private String level;

 private GameLevelManager() {
     this.level = "Easy"; // Default level
 }

 public static GameLevelManager getInstance() {
     if (instance == null) {
         instance = new GameLevelManager();
     }
     return instance;
 }

 public void setLevel(String level) {
     this.level = level;
 }

 public String getLevel() {
     return level;
 }
}

//Factory Pattern: Vehicle Factory for Ride-Sharing App
abstract class Vehicle {
 public abstract void requestRide();
}

class Car extends Vehicle {
 public void requestRide() {
     System.out.println("Car ride requested!");
 }
}

class Bike extends Vehicle {
 public void requestRide() {
     System.out.println("Bike ride requested!");
 }
}

class Scooter extends Vehicle {
 public void requestRide() {
     System.out.println("Scooter ride requested!");
 }
}

class VehicleFactory {
 public static Vehicle getVehicle(String type) {
     if (type.equalsIgnoreCase("car")) return new Car();
     else if (type.equalsIgnoreCase("bike")) return new Bike();
     else if (type.equalsIgnoreCase("scooter")) return new Scooter();
     return null;
 }
}

//Abstract Factory Pattern: Ride Factory
interface RideFactory {
 Vehicle createVehicle();
}

class CarFactory implements RideFactory {
 public Vehicle createVehicle() {
     return new Car();
 }
}

class BikeFactory implements RideFactory {
 public Vehicle createVehicle() {
     return new Bike();
 }
}

class ScooterFactory implements RideFactory {
 public Vehicle createVehicle() {
     return new Scooter();
 }
}

//Main class to test the implementation
public class  Client {
 public static void main(String[] args) {
     // Singleton: Game Level Manager
     GameLevelManager levelManager = GameLevelManager.getInstance();
     System.out.println("Current Game Level: " + levelManager.getLevel());
     levelManager.setLevel("Hard");
     System.out.println("Updated Game Level: " + levelManager.getLevel());

     // Factory Pattern: Requesting a ride
     Vehicle vehicle = VehicleFactory.getVehicle("bike");
     if (vehicle != null) {
         vehicle.requestRide();
     }

     // Abstract Factory Pattern: Creating vehicles
     RideFactory carFactory = new CarFactory();
     Vehicle myCar = carFactory.createVehicle();
     myCar.requestRide();

     RideFactory bikeFactory = new BikeFactory();
     Vehicle myBike = bikeFactory.createVehicle();
     myBike.requestRide();
 }
}