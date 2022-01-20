package informer.model;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public abstract class DepartmentCoreModel {
	
	protected int id;
	
	@NotBlank
	protected String name;
	
	@NotBlank
	@Pattern(regexp = "[0-9]{3}(-| |)[0-9]{2}(-| |)[0-9]{2}")
	protected String phone;
	
	@NotBlank
	@Pattern(regexp = "[0]{1}|[0-9]{3}")
	protected String atsGroup;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAtsGroup() {
		return atsGroup;
	}

	public void setAtsGroup(String atsGroup) {
		this.atsGroup = atsGroup;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atsGroup, disable, id, name, phone);
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
		return Objects.equals(atsGroup, other.atsGroup) && disable == other.disable && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "DepartmentCoreModel [id=" + id + ", name=" + name + ", phone=" + phone + ", atsGroup=" + atsGroup
				+ ", disable=" + disable + "]";
	}

}
