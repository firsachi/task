package ua.kyiv.informer.old.model;

public class DepartmentModel {
	
	private int id;
	
	private String name;
	
	private String phone;
	
	private String fax;
	
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

	@Override
	public String toString() {
		return "DepartmentModel [id=" + id + ", name=" + name + ", phone=" + phone + ", fax=" + fax + "]";
	}
	
}
