package ua.kyiv.informer.rest;

import jakarta.validation.constraints.Pattern;

public class RoomModel {
	
	private int id;
	
	@Pattern(regexp = "[0-9]{3}")
	private String numberRoom;

	public int getId() {
		return id;
	}

	public String getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(String numberRoom) {
		this.numberRoom = numberRoom;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RoomModel [id=" + id + ", numberRoom=" + numberRoom + "]";
	}

}
