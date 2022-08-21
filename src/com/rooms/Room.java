package com.rooms;

public class Room {

	private int roomId;
	private int numOfBeds;
	boolean available;	
	
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Room(int roomId, int numOfBeds, boolean available) {
		this.roomId = roomId;
		this.numOfBeds = numOfBeds;
		this.available = available;
	}

	

	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public int getNumOfBeds() {
		return numOfBeds;
	}


	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", numOfBeds=" + numOfBeds + ", available=" + available + "]";
	}
	
	
		
}
