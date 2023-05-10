package ua.kyiv.informer.rest.department;

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
	
	public Builder newBuilder() {
		return new DepartmentFormModel().new Builder();
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
		return "DepartmentFormModel [id=" + id + ", name=" + name + ", disable=" + disable + "companies=" + companies + "]";
	}
	
public class Builder {
		
		private Builder() {
		}
		
		public Builder setId(int id) {
			DepartmentFormModel.this.id = id;
			return this;
		}
		
		public Builder setName(String name) {
			DepartmentFormModel.this.name = name;
			return this;
		}
		
		public Builder setDisable(boolean disable) {
			DepartmentFormModel.this.disable = disable;
			return this;
		}
		
		public Builder setCompanies(List<Integer> companies) {
			DepartmentFormModel.this.companies = companies;
			return this;
		}
		
		public DepartmentFormModel build() {
			return DepartmentFormModel.this;
		}
	}

}
