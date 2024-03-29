package ua.kyiv.informer.old;

import org.springframework.stereotype.Component;
import ua.kyiv.informer.logic.entity.*;
import ua.kyiv.informer.rest.employee.EmployeeModel;

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
        model.setPhone(entity.getPhone().getPhoneNumber());
        model.setIdPost(entity.getPosition().getId());
        model.setPost(entity.getPosition().getNamePosition());
        model.setDisable(entity.getDisable());
        model.setIdRoom(entity.getRoom().getId());
        model.setRoom(entity.getRoom().getNumberRoom());
        model.setLogin(entity.getLogin());
        model.setPassword(entity.getPassword());
        return model;
    }

    public Employee modelToEntity(EmployeeModel model){
        Employee employee = new Employee();
        employee.setId(model.getId());
        Department department = new Department();
        department.setId(model.getIdDepartment());
        employee.setDepartment(department);
        employee.setEmail(model.getEmail());
        employee.setEnterprise(new Company(model.getIdEnterprise()));
        employee.setName(model.getName());
        employee.setPatronymic(model.getPatronymic());
        employee.setSurname(model.getSurname());
        employee.setPhone(new Phone(model.getIdPhone()));
        Position post = new Position();
        post.setId(model.getIdPost());
        employee.setPosition(post);
        employee.setDisable(model.isDisable());
        employee.setRoom(new Room(model.getIdRoom()));
        employee.setLogin(model.getLogin());
        employee.setPassword(model.getPassword());
        return employee;
    }
}
