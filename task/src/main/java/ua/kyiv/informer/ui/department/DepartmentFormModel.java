package ua.kyiv.informer.ui.department;

import java.util.List;
import java.util.Objects;

public class DepartmentFormModel extends DepartmentCoreModel {

	private List<Integer> multiCompany;

	public List<Integer> getMultiCompany() {
		return multiCompany;
	}

	public void setMultiCompany(List<Integer> multiCompany) {
		this.multiCompany = multiCompany;
	}
	
	public Builder newBuilder() {
		return new DepartmentFormModel().new Builder();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(multiCompany);
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
		return Objects.equals(multiCompany, other.multiCompany);
	}

	@Override
	public String toString() {
		return "DepartmentFormModel [id=" + id + ", name=" + name + ", disable=" + disable + "companies=" + multiCompany + "]";
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
			DepartmentFormModel.this.multiCompany = companies;
			return this;
		}
		
		public DepartmentFormModel build() {
			return DepartmentFormModel.this;
		}
	}

}
