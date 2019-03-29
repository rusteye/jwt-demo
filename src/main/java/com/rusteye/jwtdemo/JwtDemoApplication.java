package com.rusteye.jwtdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class JwtDemoApplication extends WebMvcConfigurationSupport{

	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

//	@Bean
//    public FilterRegistrationBean<JwtFilter> jwtFilter() {
//        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/api/*");
//        return registrationBean;
//    }
	
	@Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/**");
        super.addInterceptors(registry);
    }
}
