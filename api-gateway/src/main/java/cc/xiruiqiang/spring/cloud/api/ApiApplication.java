package cc.xiruiqiang.spring.cloud.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import cc.xiruiqiang.spring.cloud.api.filter.AccessFilter;

@EnableZuulProxy
@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiApplication.class).web(true).run(args);
	}
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}