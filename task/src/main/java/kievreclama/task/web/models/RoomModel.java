package kievreclama.task.web.models;

public class RoomModel {
	
	private int id;
	
	private Integer numberRoom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNumberRoom() {
		return numberRoom;
	}

	public void setNumberRoom(Integer numberRoom) {
		this.numberRoom = numberRoom;
	}

	@Override
	public String toString() {
		return "RoomModel [id=" + id + ", numberRoom=" + numberRoom + "]";
	}
	
	
	
}
