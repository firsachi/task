package informer.model;

import java.util.List;
import java.util.Objects;

public class DepartmentFormModel extends DepartmentCoreModel {

	private List<Integer> companies;

	public List<Integer> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Integer> companies) {
		this.companies = companies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(companies);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentFormModel other = (DepartmentFormModel) obj;
		return Objects.equals(companies, other.companies);
	}

	@Override
	public String toString() {
		return "DepartmentFormModel [id=" + id + ", name=" + name + ", phone=" + phone + ", atsGroup=" + atsGroup
				+ ", disable=" + disable + "companies=" + companies + "]";
	}

}
