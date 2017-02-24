package kievreclama.task.web;

import java.util.List;

public abstract class ServiseTask<T> {
	
	public abstract void save(T value);
	public abstract void update(T value);
	public abstract void delete(int id);
	public abstract T getId(int id);
	public abstract List<T> getList(String namedQery);
}
