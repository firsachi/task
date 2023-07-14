package ua.kyiv.informer.ui.position;

import jakarta.validation.constraints.Size;

import java.util.Objects;

public class PositionModel {
	
	private int id;
	
	@Size(min = 2, max = 150)
	private String namePosition;
	
	private String heft;
	
	private boolean disable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}

	public String getHeft() {
		return heft;
	}

	public void setHeft(String heft) {
		this.heft = heft;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disable, heft, id, namePosition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionModel other = (PositionModel) obj;
		return disable == other.disable && Objects.equals(heft, other.heft) && id == other.id
				&& Objects.equals(namePosition, other.namePosition);
	}

	@Override
	public String toString() {
		return "PositionModel [id=" + id + ", namePosition=" + namePosition + ", heft=" + heft + ", disable=" + disable
				+ "]";
	}
	
}
