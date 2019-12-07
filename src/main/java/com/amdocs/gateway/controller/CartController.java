package com.amdocs.gateway.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.gateway.bean.CartSummary;
import com.amdocs.gateway.bean.Product;
import com.amdocs.gateway.util.Constants;
import com.amdocs.gateway.util.Response;
import com.amdocs.gateway.util.RestService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private RestService restService;

	private Map<String, Object> session = new HashMap<>();

	@SuppressWarnings("unchecked")
	@PostMapping("/add")
	public ResponseEntity<Object> addToCart(@RequestParam long productId) {
		if (productId > 0) {
			if (session.get(Constants.CART) == null) {
				List<Product> cartItems = new ArrayList<>();
				Product product = restService.getProduct(productId);
				if (product != null) {
					cartItems.add(product);
					session.put(Constants.CART, cartItems);
				}
				return Response.doResponse(true, true, HttpStatus.OK);
			} else {
				List<Product> cartItems = (List<Product>) session.get(Constants.CART);
				int index = exists(productId, cartItems);
				if (index > -1) {
					return Response.doResponse("Product already in cart", false, HttpStatus.OK);
				} else {
					Product product = restService.getProduct(productId);
					if (product != null) {
						cartItems.add(product);
						session.put(Constants.CART, cartItems);
					}
				}
				return Response.doResponse(true, true, HttpStatus.OK);
			}
		} else {
			return Response.doResponse("Please select product", false, HttpStatus.OK);
		}

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/cartSummary")
	public ResponseEntity<Object> getCartItem() {
		List<Product> cartItems = (List<Product>) session.get(Constants.CART);
		if (cartItems == null)
			return Response.doResponse(null, true, HttpStatus.OK);
		CartSummary cartSummary = new CartSummary();
		cartSummary.setCartItems(cartItems);
		double price = 0;
		for (Product item : cartItems) {
			price = price + item.getPrice();
		}
		cartSummary.setTaxAmount(price * cartSummary.getTax() / 100);
		cartSummary.setTotal(price);
		cartSummary.setGrandTotal(price + cartSummary.getTaxAmount() + cartSummary.getShippingChares());
		return Response.doResponse(cartSummary, true, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Object> remove(@PathVariable("productId") long productId) {
		List<Product> cartItems = (List<Product>) session.get(Constants.CART);
		int index = this.exists(productId, cartItems);
		cartItems.remove(index);
		session.put(Constants.CART, cartItems);
		return Response.doResponse(true, true, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/checkCart")
	public ResponseEntity<Object> checkCart() {
		List<Product> cartItems = (List<Product>) session.get(Constants.CART);
		int cartCounter = 0;
		if (cartItems != null && !cartItems.isEmpty())
			cartCounter = cartItems.size();
		return Response.doResponse(cartCounter, true, HttpStatus.OK);
	}

	private int exists(long productId, List<Product> cartItems) {
		if (cartItems == null || cartItems.isEmpty())
			return -1;
		for (int i = 0; i < cartItems.size(); i++) {
			if (cartItems.get(i).getProductId() == productId) {
				return i;
			}
		}
		return -1;
	}

	@PostMapping("/logout.do")
	public ResponseEntity<Object> logOut() {
		session.clear();
		return Response.doResponse(true, true, HttpStatus.OK);
	}

	@GetMapping("/clearCart")
	public ResponseEntity<Object> clearCart() {
		session.clear();
		return Response.doResponse(true, true, HttpStatus.OK);
	}

}
