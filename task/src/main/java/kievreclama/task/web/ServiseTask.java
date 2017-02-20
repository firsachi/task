package kievreclama.task.web;

import java.util.List;

public abstract class ServiseTask<T> {
	
	public abstract void save(T value);
	public abstract void update(T value);
	public abstract void delete(T value);
	public abstract List<T> getList(String namedQery);
}
