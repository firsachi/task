package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Department;
import kievreclama.task.web.models.DepartmentModel;

@Component
public class DepartmentTransformer{

	public Department modelToEntity(DepartmentModel model) {
		Department department = new Department();
		department.setId(model.getId());
		department.setName(model.getName());
		department.setPhone(model.getPhone());
		department.setFax(model.getFax());
		department.setRemove(model.getRemove());
		return department;
	}

	public DepartmentModel entityToModel(Department entity) {
		DepartmentModel departmentModel = new DepartmentModel();
		departmentModel.setId(entity.getId());
		departmentModel.setName(entity.getName());
		departmentModel.setPhone(entity.getPhone());
		departmentModel.setFax(entity.getFax());
		departmentModel.setRemove(entity.getRemove());
		return departmentModel;
	}
	
	
}
