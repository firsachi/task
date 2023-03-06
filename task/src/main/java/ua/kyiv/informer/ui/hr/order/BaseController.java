package ua.kyiv.informer.ui.hr.order;

import org.springframework.beans.factory.annotation.Autowired;

import ua.kyiv.informer.logic.service.MainService;

public abstract class BaseController<T extends MainService> {
	
	@Autowired
	private T servieApp;
	
	public T getService() {
		return servieApp;
	}

}
