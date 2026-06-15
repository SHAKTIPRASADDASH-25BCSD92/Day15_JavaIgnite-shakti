/*
A shopping mall has:

Available Parking Slots = 3

Multiple cars arrive simultaneously.

Each car is represented by a separate thread.

Requirements
Create a shared ParkingLot class.
Initially:
slots = 3
When a car arrives:
If a slot is available:
Park the car
Reduce available slots
Print:
Car 1 Parked
Available Slots: 2
Otherwise:
No Parking Available for Car 4
Use synchronization to prevent incorrect slot allocation.
Create at least 6 car threads.

Instructions - 
Create Class ParkingLot

    availableSlots ← 3

    synchronized Method parkCar(carName)

        IF availableSlots > 0

            Print carName + " Parked"

            availableSlots ← availableSlots - 1

            Print "Available Slots: " + availableSlots

        ELSE

            Print "No Parking Available for " + carName

        END IF


Create Class CarThread

    ParkingLot parkingLot
    carName

    Method run()

        parkingLot.parkCar(carName)


Main Method

    Create ParkingLot object

    Create Car1 thread till Car6 thread
    Start Car1 till  Car6


*/
package java_internship_day15;

class Parkinglot {
	int availableslots = 3;
	synchronized void parkCar(String carname) {
		if(availableslots > 0) {
			System.out.println("Sucessfully parked : " +carname);
			availableslots--;
			System.out.println("Available slots :" +availableslots);
		}
		else {
			System.out.println("Cant park...slots fulled !!");
		}
	}
}

class Carthread extends Thread {
	Parkinglot parkinglot;
	String carname;
	
	Carthread(Parkinglot parkinglot, String carname) {
		this.parkinglot = parkinglot;
		this.carname = carname;
	}
	public void run() {
		parkinglot.parkCar(carname);
	}
}
public class Parking_lot_Management_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parkinglot parkinglot = new Parkinglot();
		Carthread car1 = new Carthread(parkinglot, "Car 1");
		Carthread car2 = new Carthread(parkinglot, "Car 2");
		Carthread car3 = new Carthread(parkinglot, "Car 3");
		Carthread car4 = new Carthread(parkinglot, "Car 4");
		Carthread car5 = new Carthread(parkinglot, "Car 5");
		Carthread car6 = new Carthread(parkinglot, "Car 6");
		car1.start();
		car2.start();
		car3.start();
		car4.start();
		car5.start();
		car6.start();
	}

}
