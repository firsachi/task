package informer.model;

import java.util.List;
import java.util.Objects;

import ua.kyiv.informer.ui.company.CompanyModel;

public class DepartmentModel extends DepartmentCoreModel {
	
	private List<CompanyModel> companies;

	public List<CompanyModel> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyModel> companies) {
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
		DepartmentModel other = (DepartmentModel) obj;
		return Objects.equals(companies, other.companies);
	}

	@Override
	public String toString() {
		return "DepartmentModel [companies=" + companies + "]";
	}

}
