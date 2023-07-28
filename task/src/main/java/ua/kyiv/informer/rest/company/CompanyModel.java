package ua.kyiv.informer.rest.company;

import informer.rest.model.CompanyModelSmall;
import informer.rest.model.DepartmentModel;

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
