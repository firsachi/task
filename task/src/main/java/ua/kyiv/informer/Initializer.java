package ua.kyiv.informer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ua.kyiv.informer.config.ThymeleafConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ThymeleafConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


}
