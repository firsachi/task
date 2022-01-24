package informer.rest.model;

import java.util.List;

public class CompanyModel extends CompanyModelSmall {
	
	private List<DepartmentModel> departments;

	public List<DepartmentModel> getDepartments() {
		return departments;
	}

	public void setDepartments(List<DepartmentModel> departments2) {
		this.departments = departments2;
	}
	
}
