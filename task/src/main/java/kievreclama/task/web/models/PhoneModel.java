package kievreclama.task.web.models;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

/**
*
* @author firsachi
*/
public class PhoneModel {
	
	private int id;
	
	@NotBlank(message = "{error.null}")
	@Min(value = 3, message  = "{error.minimumSize}")
	private String number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneModel [id=" + id + ", number=" + number + "]";
	}

}
