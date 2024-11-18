package jp.co.sss.shop.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.co.sss.shop.filter.Message02Filter;
import jp.co.sss.shop.filter.Message03Filter;

@Configuration
public class FilterConfig implements WebMvcConfigurer {
	@Bean
	public FilterRegistrationBean<Message02Filter> configMessage02Filter() {
		FilterRegistrationBean<Message02Filter> bean = new FilterRegistrationBean<Message02Filter>();
		bean.setFilter(new Message02Filter());
		bean.setOrder(2);
//		bean.addUrlPatterns("/items/*");
		return bean;
	}

	@Bean
	public FilterRegistrationBean<Message03Filter> configMessage03Filter() {
		FilterRegistrationBean<Message03Filter> bean = new FilterRegistrationBean<Message03Filter>();
		bean.setFilter(new Message03Filter());
		bean.setOrder(1);
		return bean;
	}
}