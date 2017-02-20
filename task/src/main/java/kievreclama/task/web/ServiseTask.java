package kievreclama.task.web;

import antlr.collections.List;

public abstract class ServiseTask<T> {
	
	abstract void save(T value);
	abstract void update(T value);
	abstract void delete(T value);
	abstract List getList();
}
