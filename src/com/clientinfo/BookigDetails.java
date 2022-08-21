package com.clientinfo;

import java.util.Date;

public class BookigDetails {

	private int boookingId;
	private String name;
	private int mobNo;
	private String address;
	private int roomBooked;
	private Date checkIn;
	private Date checkout;
	private static int generatedId = 0;
	
	public BookigDetails() {
		super();
	}

	public BookigDetails(int boookingId, String name, int mobNo, String address, int roomBooked, Date checkIn,
			Date checkout) {
		super();
		this.boookingId = boookingId;
		this.name = name;
		this.mobNo = mobNo;
		this.address = address;
		this.roomBooked = roomBooked;
		this.checkIn = checkIn;
		this.checkout = checkout;
	}

	public int getBoookingId() {
		return boookingId;
	}

	public void setBoookingId(int boookingId) {
		this.boookingId = boookingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobNo() {
		return mobNo;
	}

	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkout;
	}

	public void setCheckOut(Date checkout) {
		this.checkout = checkout;
	}

	public static int getGeneratedId() {
		return generatedId;
	}

	public int getRoomBooked() {
		return roomBooked;
	}

	public void setRoomBooked(int roomBooked) {
		this.roomBooked = roomBooked;
	}

	@Override
	public String toString() {
		return "BookigDetails [boookingId=" + boookingId + ", name=" + name + ", mobNo=" + mobNo + ", address="
				+ address + ", roomBooked=" + roomBooked + ", checkIn=" + checkIn + ", checkout=" + checkout + "]";
	}
	
}
