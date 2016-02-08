package com.yog.fw.core.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Yougeshwar
 * 
 * */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebAppConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
//	public class AppInitializer implements WebApplicationInitializer {
//	public void onStartup(ServletContext container) throws ServletException {
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(WebAppConfig.class);
//		ctx.setServletContext(container);
//
//		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
//
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//	}

}
