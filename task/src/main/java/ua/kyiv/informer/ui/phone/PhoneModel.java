package ua.kyiv.informer.ui.phone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
*
* @author firsachi
*/
public class PhoneModel {
	
	private int id;
	
	@NotBlank(message = "{error.null}")
	@Pattern(regexp = "([0-9]{3,12})", message  = "{error.minimumSize}" )
	private String numberPhone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PhoneModel that = (PhoneModel) o;
		return id == that.id && Objects.equals(numberPhone, that.numberPhone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numberPhone);
	}

	@Override
	public String toString() {
		return "PhoneModel{" +
				"id=" + id +
				", numberPhone='" + numberPhone + '\'' +
				'}';
	}
}
