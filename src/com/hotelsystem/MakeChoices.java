package com.hotelsystem;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.alerts.Alert;
import com.clientinfo.BookigDetails;
import com.rooms.Room;
import com.rooms.RoomService;

public class MakeChoices {
	
	Map<Double, List<BookigDetails>> cl = new HashMap<>();
	
	public static void makeChoice(int choice, Set<Room> hotelRooms, List<BookigDetails> bookingDetails) throws ParseException {
		boolean availability;
		int choice2;
		Scanner sc = new Scanner(System.in);
		switch(choice) {
		case 1: System.out.println("\nDisplay room details:");
				System.out.println("\nChoose room type :\n1.Single Room \n2.Double Room\n");
        		choice2 = sc.nextInt();
        		RoomService.roomDetails(choice2, hotelRooms, bookingDetails);
        		break;
		case 2: System.out.println("\nChecking for availability...");
				System.out.println("\nPlease select room type: \n1.Single Room \n2.Double Room\n");				
				choice2 = sc.nextInt();
				availability = RoomService.isRoomAvailable(choice2, hotelRooms, bookingDetails);
				if(!availability) {
					System.out.println("\nRooms are not available. We are sorry...");
				}
				break;
		case 3: System.out.println("\nBook a room:");
				System.out.println("\nPlease select room type: \n1.Single Room \n2.Double Room\n");				
				choice2 = sc.nextInt();
				availability = RoomService.isRoomAvailable(choice2, hotelRooms, bookingDetails);
				if(availability) {
					System.out.println("\n\nWhich Room number would you like to book ");
					int roomBookingNum = sc.nextInt();
					RoomService.bookRoom(roomBookingNum, hotelRooms, bookingDetails);
				} else {
					System.out.println("\nRoom is not available");
				}				
				break;
		case 4: System.out.println("\nChecking for Alerts...");
				Alert.roomsAvailable(hotelRooms);
				Alert.todaysCheckout(bookingDetails);
				break;
		case 5: System.out.println("\nYou are checking out...\n");
				System.out.println("\nEnter checkout Room Number: ");
				int checkOutRoomNum = sc.nextInt();
				RoomService.checkOut(checkOutRoomNum, hotelRooms, bookingDetails);
				break;
		case 6: System.out.println("\nEnter 1.Cancellation 2.Modification \n");
				choice2 = sc.nextInt();
				System.out.println("\nEnter Room Number: \n");
				int oldRoomNo = sc.nextInt();
				RoomService.bookingModification(choice2, oldRoomNo, hotelRooms, bookingDetails);
				break;
		default: System.out.println("We Appriciate you to make Valid choices!");
		
		}
		Menu.getMenu(hotelRooms, bookingDetails);
		sc.close();
	}
	
}
