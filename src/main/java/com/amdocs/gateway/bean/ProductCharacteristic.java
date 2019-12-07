package com.amdocs.gateway.bean;

/**
 * The Class ProductCharacteristic.
 */
public class ProductCharacteristic {

	/** The characteristic id. */
	private long characteristicId;

	/** The product id. */
	private long productId;

	/** The characteristic. */
	private String characteristic;

	/**
	 * Gets the characteristic id.
	 *
	 * @return the characteristic id
	 */
	public long getCharacteristicId() {
		return characteristicId;
	}

	/**
	 * Sets the characteristic id.
	 *
	 * @param characteristicId
	 *            the new characteristic id
	 */
	public void setCharacteristicId(long characteristicId) {
		this.characteristicId = characteristicId;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId
	 *            the new product id
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the characteristic.
	 *
	 * @return the characteristic
	 */
	public String getCharacteristic() {
		return characteristic;
	}

	/**
	 * Sets the characteristic.
	 *
	 * @param characteristic
	 *            the new characteristic
	 */
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

}
