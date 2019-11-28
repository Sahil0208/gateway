package com.amdocs.gateway.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amdocs.gateway.bean.Product;

@Service
public class RestService {
	@Autowired
	private RestTemplate restTemplate;

	public Product getProduct(long productId) {
		String url = Constants.INVENTORY_SERVICE_URL + "/inventory/product?productId=" + productId;
		return restTemplate.exchange(url, HttpMethod.GET, null, Product.class).getBody();
	}
}
