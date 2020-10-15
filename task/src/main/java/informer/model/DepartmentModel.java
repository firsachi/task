package informer.model;

import org.springframework.stereotype.Component;

@Component
public class DepartmentModel {
	
	private int id;
	private String name;
	private String phone;
	private String fax;
	private boolean remove;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public boolean getRemove() {
		return remove;
	}
	
	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	@Override
	public String toString() {
		return "DepartmentModel [id=" + id + ", name=" + name + ", phone=" + phone + ", fax=" + fax + ", remove="
				+ remove + "]";
	}
	
}
