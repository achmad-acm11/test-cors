package com.example.test_cors;

import com.example.test_cors.middleware.JwtAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TestCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCorsApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//						.allowedHeaders("*")
//						.allowCredentials(false);;
//			}
//		};
//	}
//	@Bean
//	public FilterRegistrationBean<JwtAuthFilter> jwtFilter() {
//		FilterRegistrationBean<JwtAuthFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new JwtAuthFilter());
//		registrationBean.addUrlPatterns("/api/v1/*");
//		registrationBean.setOrder(1);
//
//		return registrationBean;
//	}
}
