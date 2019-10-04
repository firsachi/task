package kievreclama;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import kievreclama.task.configurations.WebMvcConfiguration;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfiguration.class };
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
