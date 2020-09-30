package kievreclama.task.web.models;

import javax.validation.constraints.Size;

public class PositionModel {
	
	private int id;
	
	@Size(min = 2, max = 150)
	private String name;
	
	private String heft;
	
	private boolean disable;
	
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
	
	public String getHeft() {
		return heft;
	}
	
	public void setHeft(String heft) {
		this.heft = heft;
	}
	
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	@Override
	public String toString() {
		return "PositionModel [id=" + id + ", name=" + name + ", heft=" + heft + ", remove=" + disable + "]";
	}
	
}
