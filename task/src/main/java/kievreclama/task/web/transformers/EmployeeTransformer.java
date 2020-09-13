package kievreclama.task.web.transformers;

import org.springframework.stereotype.Component;

import kievreclama.task.entity.Company;
import kievreclama.task.entity.Department;
import kievreclama.task.entity.Employee;
import kievreclama.task.entity.Phone;
import kievreclama.task.entity.Post;
import kievreclama.task.entity.Room;
import kievreclama.task.web.models.EmployeeModel;

@Component
public class EmployeeTransformer {

	public EmployeeModel entityToModel(Employee entity) {
		EmployeeModel model = new EmployeeModel();
		model.setId(entity.getId());
		model.setIdDepartment(entity.getDepartment().getId());
		model.setDepartment(entity.getDepartment().getName());
		model.setEmail(entity.getEmail());
		model.setIdEnterprise(entity.getEnterprise().getId());
		model.setEnterprise(entity.getEnterprise().getName());
		model.setName(entity.getName());
		model.setSurname(entity.getSurname());
		model.setPatronymic(entity.getPatronymic());
		model.setIdPhone(entity.getPhone().getId());
		model.setPhone(entity.getPhone().getNumber());
		model.setIdPost(entity.getPost().getId());
		model.setPost(entity.getPost().getName());
		model.setDisable(entity.getRemove());
		model.setIdRoom(entity.getRoom().getId());
		model.setRoom(entity.getRoom().getNumberRoom());
		return model;
	}

	public Employee modelToEntity(EmployeeModel model){
		Employee employee = new Employee();
		employee.setId(model.getId());
		employee.setDepartment(new Department(model.getIdDepartment()));
		employee.setEmail(model.getEmail());
		employee.setEnterprise(new Company(model.getIdEnterprise()));
		employee.setName(model.getName());
		employee.setPatronymic(model.getPatronymic());
		employee.setSurname(model.getSurname());
		employee.setPhone(new Phone(model.getIdPhone()));
		employee.setPost(new Post(model.getIdPost()));
		employee.setRemove(model.isDisable());
		employee.setRoom(new Room(model.getIdRoom()));
		return employee;
	}
}
