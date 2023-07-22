package ua.kyiv.informer.ui.department;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

public class DepartmentCoreModel {
	
	protected int id;
	
	@NotBlank
	protected String name;
	
	protected boolean disable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disable, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentCoreModel other = (DepartmentCoreModel) obj;
		return disable == other.disable && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "DepartmentCoreModel [id=" + id + ", name=" + name + ", disable=" + disable + "]";
	}

}
