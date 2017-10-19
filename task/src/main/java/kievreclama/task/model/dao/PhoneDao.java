package kievreclama.task.model.dao;

import java.util.Set;

import kievreclama.task.entity.Phone;

public interface PhoneDao {

	void add(Phone phone);
	Set<Phone> getAll();
	void upadte(Phone phone);
	Phone byId(int id);
}
