package ua.kyiv.informer.rest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



/**
*
* @author firsachi
*/
public class PhoneModel {
	
	private int id;
	
	@NotBlank(message = "{error.null}")
	@Pattern(regexp = "([0-9]{3,12})", message  = "{error.minimumSize}" )
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