package com.hotelsystem;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.clientinfo.BookigDetails;
import com.rooms.Room;

public interface Menu {

	public static void getMenu(Set<Room> hotelRooms, List<BookigDetails> bookingDetails) throws ParseException {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("\n\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.My Alert\n5.Checkout\n6.Modification/Cancellation\n");
		choice = sc.nextInt();
		MakeChoices.makeChoice(choice, hotelRooms, bookingDetails);
		sc.close();
	}
}
