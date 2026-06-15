/*
Create:

Interface
NotificationService

Method:

sendMessage()

Implement:

EmailNotification
SMSNotification

Create:

OrderService
Requirements

Inject notification service using:

Constructor Injection
When order is placed:

Order Confirmed
Notification Sent
Concepts Tested
Dependency Injection
Interface
Loose Coupling

Instructions -
Create Interface NotificationService

    Method:
        sendMessage()


Create Class EmailNotification

    Implement NotificationService

    Override sendMessage()

        Print:
            "Email Notification Sent"


Create Class SMSNotification

    Implement NotificationService

    Override sendMessage()

        Print:
            "SMS Notification Sent"


Create Class OrderService

    Variable:
        NotificationService notificationService

    Constructor(NotificationService notificationService)

        this.notificationService = notificationService

    Method placeOrder()

        Print:
            "Order Confirmed"

        notificationService.sendMessage()


Main Method

    Create EmailNotification object

    Create OrderService object
    Inject EmailNotification through constructor

    Call placeOrder()


    Create SMSNotification object

    Create OrderService object
    Inject SMSNotification through constructor

    Call placeOrder()

*/
package java_internship_day15;
import java.util.*;
interface Notificationservice {
	public void sendmessage();
}

class Emailnotification implements Notificationservice {
	public void sendmessage() {
		System.out.println("Notification sent through email");
	}	
}
class Smsnotification implements Notificationservice {
	public void sendmessage() {
		System.out.println("Notification sent by sms");
	}	
}
class Orderservice {
	Notificationservice notificationservice;
	Orderservice(Notificationservice notificationservice) {
		this.notificationservice = notificationservice;
	}
	void placeorder() {
		System.out.println("Your order is confirmed !");
		notificationservice.sendmessage();
	}
}
public class Online_Food_Order_Notification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emailnotification email = new Emailnotification();
		Orderservice ord1 = new Orderservice(email);
		ord1.placeorder();
		
		Smsnotification sms = new Smsnotification();
		Orderservice ord2 = new Orderservice(sms);
		ord2.placeorder();
	}

}
