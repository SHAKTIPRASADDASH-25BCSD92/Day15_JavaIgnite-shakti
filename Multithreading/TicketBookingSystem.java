/*
Ticket Booking System

A movie theater has:

Total Seats = 5

Create:

Multiple booking threads
Requirements
Each thread tries to book seats.
If seats are available, booking succeeds.
Otherwise print:
Booking Failed

Concepts Tested
Threads
Shared Resource
Synchronized Method

Instructions - 
Create class Theater

    Variable:
        totalSeats = 5

    synchronized method bookSeat(int seats)

        If totalSeats >= seats

            Print:
                ThreadName + " Booking Successful"

            totalSeats = totalSeats - seats

            Print remaining seats

        Else

            Print:
                ThreadName + " Booking Failed"


Create class BookingThread extends Thread

    Theater theater
    int seatsRequired

    Constructor receives:
        theater
        seatsRequired

    run()

        theater.bookSeat(seatsRequired)


Main Method

    Create Theater object

    Create Thread1 -> wants 2 seats
    Create Thread2 -> wants 2 seats
    Create Thread3 -> wants 2 seats

    Start Thread1
    Start Thread2
    Start Thread3


Possible Output

    Thread1 Booking Successful
    Remaining Seats = 3

    Thread2 Booking Successful
    Remaining Seats = 1

    Thread3 Booking Failed
*/
package java_internship_day15;

class Threater {
	int totalseats = 5;
	synchronized void bookseat(int seats,String threadname) {
		if(totalseats >= seats) {
			System.out.println(threadname + ": Booking Sucessful");
			totalseats = totalseats - seats;
			System.out.println("Remaing seats: "+totalseats);
		}
		else {
			System.out.println(threadname + ": Booking failed");
		}
	}
}
class bookingthread extends Thread {
	Threater threater;
	int seatsreq;
	String threadname;
	bookingthread(Threater threater ,int seatsreq,String threadname) {
		this.seatsreq=seatsreq;
		this.threater=threater;
		this.threadname = threadname;
	}
	public void run() {
		threater.bookseat(seatsreq,threadname);
	}
}
public class TicketBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Threater threater = new Threater();
		bookingthread t1 = new bookingthread(threater,2,"Thread1");
		bookingthread t2 = new bookingthread(threater,2,"Thread2");
		bookingthread t3 = new bookingthread(threater,2,"Thread3");

		t1.start();
		t2.start();
		t3.start();
	}

}
