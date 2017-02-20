package kievreclama.task.web.transformers;

public abstract class MainTransformer<T> {
	
	private T entity; 
	
	abstract T modelToEntity(T model);
	abstract T entityTomadel(T entity);

}
