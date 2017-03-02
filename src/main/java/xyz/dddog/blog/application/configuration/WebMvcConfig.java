package xyz.dddog.blog.application.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import xyz.dddog.blog.application.aop.UserSessionArgumentResolver;
import xyz.dddog.blog.application.aop.UserSessionInterceptor;
import xyz.dddog.blog.domain.repository.AccountRepository;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSessionInterceptor());
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UserSessionArgumentResolver(accountRepository));
	}
}
