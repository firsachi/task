package ua.kyiv.informer.ui.hr.order;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController<T> {
	
	@Autowired
	private T servieApp;
	
	public T getService() {
		return servieApp;
	}

}
