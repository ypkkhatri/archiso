package com.yog.fw.core.init;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Yougeshwar
 * 
 * */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.yog.fw", "com.yog.mt"})
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		MappingJackson2HttpMessageConverter ob = new MappingJackson2HttpMessageConverter();
		ob.setPrefixJson(true);
		ob.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		ob.setObjectMapper(objectMapper);
		return ob;
	}
	
//	@Bean
//	public MessageSource messageSource() {
//	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//	    messageSource.setBasename("messages");
//	    return messageSource;
//	}
}

