package ua.kyiv.informer.ui.company;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class CompanyModel {

	private int id;

	@NotBlank
	private String nameCompany;
	
	private boolean disable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disable, id, nameCompany);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyModel other = (CompanyModel) obj;
		return disable == other.disable && id == other.id && Objects.equals(nameCompany, other.nameCompany);
	}

	@Override
	public String toString() {
		return "CompanyModel [id=" + id + ", nameCompany=" + nameCompany + ", disable=" + disable + "]";
	}

}
