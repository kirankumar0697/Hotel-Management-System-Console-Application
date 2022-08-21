package com.alerts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.clientinfo.BookigDetails;
import com.rooms.Room;

public class Alert {

	public static void roomsAvailable(Set<Room> hotelRooms) {
		
		System.out.print("Available Single rooms are: \n");			
		hotelRooms.stream().filter(s -> s.getNumOfBeds() == 1 && Boolean.TRUE.equals(s.isAvailable())).forEach(System.out::println);
		System.out.print("Available Double rooms are: \n");			
		hotelRooms.stream().filter(s -> s.getNumOfBeds() == 2 && Boolean.TRUE.equals(s.isAvailable())).forEach(System.out::println);
	}
	
	public static void todaysCheckout(List<BookigDetails> bookingDetails) throws ParseException {
		
		System.out.print("Rooms having checkout today: \n");		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		Date currenDate=new SimpleDateFormat("dd/MM/yyyy").parse(date.format(formatter));  
		bookingDetails.stream().filter(cl -> cl.getCheckOut().equals(currenDate)).forEach(System.out::println);
	}
}
