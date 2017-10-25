package kievreclama.task.web.models;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class RoomModel {
	
	private int id;
	
	@NotBlank(message = "{error.null}")
	@Pattern(regexp = "([0-9]{3})", message  = "{error.sizeRoom}" )
	private String numberRoom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(String numberRoom) {
		this.numberRoom = numberRoom;
	}

	@Override
	public String toString() {
		return "RoomModel [id=" + id + ", numberRoom=" + numberRoom + "]";
	}
	
}
