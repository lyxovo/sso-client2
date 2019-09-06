package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig implements WebMvcConfigurer{
	/**
	 * addInterceptors:添加拦截
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		System.out.println("1223");
        //可以new 多个自定义的拦截器，实现多个拦截器拦截。也可以使用注入对象方式。
		HandlerInterceptor interceptor=new MyInterceptor();
		registry.addInterceptor(interceptor)
//		http://localhost:8082/order/queryOrder?0.4569781863447935
		.addPathPatterns("/order/**")
		//.addPathPatterns("/login*","/login/login*","/login/toLogin*")//拦截路径
        .excludePathPatterns("/index/**");//表示不拦截，放行，即不会进入我们定义的拦截器。
		System.out.println("1223");
	}
	
}