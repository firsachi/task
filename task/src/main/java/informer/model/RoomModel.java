package informer.model;

import javax.validation.constraints.Pattern;

import informer.service.RoomService;
import informer.validator.unique.Unique;

public class RoomModel {
	
	private int id;
	
	@Pattern(regexp = "[0-9]{3}")
	@Unique(service = RoomService.class, fieldName = "numberRoom")
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
