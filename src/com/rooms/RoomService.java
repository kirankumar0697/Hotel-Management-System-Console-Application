package com.rooms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.clientinfo.BookigDetails;
import com.hotelsystem.Menu;

public class RoomService {

	public static void roomDetails(int i, Set<Room> hotelRooms, List<BookigDetails> bookingDetails) throws ParseException
    {
        switch (i) {
            case 1:System.out.println("Number of beds : 1\nAC : Yes\nCharge per day:2000 ");
                break;        
            case 2:System.out.println("Number of beds : 2\nAC : Yes\nCharge per day:3500 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        Menu.getMenu(hotelRooms, bookingDetails);
    }
	
	public static boolean isRoomAvailable(int roomType, Set<Room> hotelRooms, List<BookigDetails> bookingDetails) throws ParseException {
		
		boolean flag = true;
		if(roomType == 1) {
			
			System.out.print("Available Single rooms are: \n");			
			Set<Room> availableRooms = hotelRooms.stream().filter(s -> s.getNumOfBeds() == 1 && Boolean.TRUE.equals(s.isAvailable())).collect(Collectors.toSet());			
			if(availableRooms.isEmpty()) {
				return false;
			}
			for(Room sRooms : availableRooms) {
				System.out.print(sRooms.getRoomId() + " ");
			}
						
		} else if(roomType ==2 ) {
			
			System.out.print("Available Double rooms are: \n");			
			Set<Room> availableRooms = hotelRooms.stream().filter(s -> s.getNumOfBeds() == 2 && Boolean.TRUE.equals(s.isAvailable())).collect(Collectors.toSet());			
			if(availableRooms.isEmpty()) {
				return false;
			}
			for(Room sRooms : availableRooms) {
				System.out.print(sRooms.getRoomId() + " ");
			}
			
		} else {
			System.out.println("Enter valid option\n");
			Menu.getMenu(hotelRooms, bookingDetails);
		}
				
		return true;
	}

	public static void bookRoom(int roomBookingNum, Set<Room> hotelRooms, List<BookigDetails> bookingDetails) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		hotelRooms.stream().filter(r -> r.getRoomId() == roomBookingNum).forEach(c -> c.setAvailable(false));
		BookigDetails bookDetails = new BookigDetails();
		bookDetails.setBoookingId(BookigDetails.getGeneratedId()+1);
		System.out.println("Enter Your Name: ");
		bookDetails.setName(sc.next());
		System.out.println("Enter Mobile Number: ");
		bookDetails.setMobNo(sc.nextInt());
		System.out.println("Enter Your Address: ");
		bookDetails.setAddress(sc.next());		
		bookDetails.setRoomBooked(roomBookingNum);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter CheckIn Date: ");		
		String inDate = sc.next();		
	    bookDetails.setCheckIn(formatter.parse(inDate));
		System.out.println("Enter CheckOut Date: ");
		String outDate = sc.next();
		bookDetails.setCheckOut(formatter.parse(outDate));	    
		bookingDetails.add(bookDetails);
		System.out.println("Room " + roomBookingNum + " is booked. \nYour Booking Details are - \n" + bookDetails + "\nArigato!");
	}

	public static void checkOut(int checkOutRoomNum, Set<Room> hotelRooms, List<BookigDetails> bookingDetails) {
		
		hotelRooms.stream().filter(room -> room.getRoomId() == checkOutRoomNum).forEach(room -> room.setAvailable(true));
		System.out.println("\nArigato Gozaimus!\nPlease visit again... :-)");
	}

	public static void bookingModification(int choice2, int oldRoomNum, Set<Room> hotelRooms, List<BookigDetails> bookingDetails) throws ParseException {

		Scanner sc = new Scanner(System.in);
		if(choice2 == 1) {
			hotelRooms.stream().filter(room -> room.getRoomId() == oldRoomNum).forEach(booking -> booking.setAvailable(true));
			System.out.println("Yo have been checked out. Thank You. \nPlease visit again");
		} else if(choice2 ==2) {
			System.out.println("\nSelect What modification do you want to do: 1.Change Room 2.Change CheckOut Date");
			int modifChoice = sc.nextInt();
			if(modifChoice == 1) {
				System.out.println("\nPlease select room type: \n1.Single Room \n2.Double Room\n");				
				int roomType = sc.nextInt();
				boolean availability = isRoomAvailable(roomType, hotelRooms, bookingDetails);
				if(availability) {
					System.out.println("\n\nWhich Room number would you like to book ");
					int newRoomNum = sc.nextInt();
					hotelRooms.stream()
						.filter(room -> room.getRoomId() == oldRoomNum || room.getRoomId() == newRoomNum)
						.forEach(room -> room.setAvailable(!room.isAvailable()));
					System.out.println("\nEnjoy new Room: " + newRoomNum);
				} else {
					System.out.println("\nRoom is not available");
				}
			} else if(modifChoice == 2) {
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
				System.out.println("Enter CheckOut Date: ");		
				String inDate = sc.next();
				Date newCheckOutDate = formatter.parse(inDate);
				bookingDetails.stream().filter(room -> room.getRoomBooked() == oldRoomNum).forEach(room -> room.setCheckOut(newCheckOutDate));
			    System.out.println("Checkout date has been updated!");
			}
			
		}
		
	}	 
}
