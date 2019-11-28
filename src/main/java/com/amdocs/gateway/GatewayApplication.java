package com.amdocs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.amdocs.gateway.config.RequestFilter;

/**
 * The Class GatewayApplication.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	/**
	 * Simple filter.
	 *
	 * @return the request filter
	 */
	@Bean
	public RequestFilter simpleFilter() {
		return new RequestFilter();
	}
	
	/**
	 * Gets the rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	public RestTemplate getRestTemplate() {
	   return new RestTemplate();
	}

}
