package com.hotelsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.clientinfo.BookigDetails;
import com.rooms.Room;

public class WelcomeHotel {
	
	public static void main(String[] args){
		
		try {
		//RoomService roomService = new RoomService();
		Set<Room> hotelRooms = new HashSet<>(5);
		
		hotelRooms.add(new Room(101, 1, true));
		hotelRooms.add(new Room(102, 1, true));
		hotelRooms.add(new Room(103, 1, true)); 
		hotelRooms.add(new Room(104, 1, true));
		hotelRooms.add(new Room(201, 2, true)); 
		hotelRooms.add(new Room(202, 2, true));
		hotelRooms.add(new Room(203, 2, true)); 
		hotelRooms.add(new Room(204, 2, true));
		
		List<BookigDetails> bookingDetails = new ArrayList<>();
		System.out.println("************Welcome To Hotel************");
		Menu.getMenu(hotelRooms, bookingDetails);
		System.gc();
		}catch(Exception e) {
			System.out.println("Something went wrong." + e);
		}
	}
}
