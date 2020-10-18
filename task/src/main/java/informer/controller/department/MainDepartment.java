/**
 * 
 */
package informer.controller.department;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import informer.model.DepartmentModel;
import informer.service.DepartmentService;

/**
 * @author firsov
 *
 */
public abstract class MainDepartment {
	
	protected DepartmentModel departmentModel;
	
	@Autowired
	protected DepartmentService departmentService;

	@PostConstruct
	private void init() {
		this.departmentModel = new DepartmentModel();
	}
	
	@ModelAttribute("department")
	public DepartmentModel departmentAttribute() {
		return this.departmentModel;
	}
	
}
