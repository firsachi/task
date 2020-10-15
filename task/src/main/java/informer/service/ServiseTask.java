package informer.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class ServiseTask<T> {
	
	public abstract void save(T value);
	public abstract void update(T value);
	public abstract T getId(int id);
	public abstract List<T> getList(String namedQery);
}
