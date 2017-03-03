package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Employee;
import kievreclama.task.web.models.EmployeeModel;

@Component
public class EmployeeTransformer {

	public EmployeeModel entityToModel(Employee entity) {
		EmployeeModel model = new EmployeeModel();
		model.setId(entity.getId());
		model.setDepartment(entity.getDepartment().getName());
		model.setEmail(entity.getEmail());
		model.setEnterprise(entity.getEnterprise().getName());
		model.setName(entity.getName());
		model.setSurname(entity.getSurname());
		model.setPatronymic(entity.getPatronymic());
		model.setPhone(entity.getPhone().getNumber());
		model.setPost(entity.getPost().getName());
		model.setRemove(entity.getRemove());
		model.setRoom(entity.getRoom().getNumberRoom());
		return model;
	}

	public Employee modelToEntity(EmployeeModel model){
		Employee employee = new Employee();
		return employee;
	}
}
