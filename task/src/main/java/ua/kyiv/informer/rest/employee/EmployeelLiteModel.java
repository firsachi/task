package ua.kyiv.informer.rest.employee;

import java.util.Objects;

import javax.validation.constraints.Size;

public class EmployeelLiteModel {
	
	private int id;
	
	@Size(min = 2, max = 150)
    private String surname;
	
	@Size(min = 2, max = 150)
    private String name;
	
	@Size(min = 2, max = 150)
    private String patronymic;

	public EmployeelLiteModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	public String getFullName() {
		return this.surname + " " + this.name + " " + this.patronymic;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, patronymic, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeelLiteModel other = (EmployeelLiteModel) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(patronymic, other.patronymic)
				&& Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "EmployeelLiteModel [id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ "]";
	}
	
}
