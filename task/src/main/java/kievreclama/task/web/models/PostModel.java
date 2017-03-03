package kievreclama.task.web.models;

public class PostModel {
	
	private int id;
	private String name;
	private String heft;
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
	
	public String getHeft() {
		return heft;
	}
	
	public void setHeft(String heft) {
		this.heft = heft;
	}
	
	public boolean getRemove() {
		return remove;
	}
	
	public void setRemove(boolean remove) {
		this.remove = remove;
	}
	
	
}
